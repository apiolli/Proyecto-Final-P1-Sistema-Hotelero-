package vista.consumo;

import app.ContextoAplicacion;
import controlador.ControladorConsumo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import modelo.Producto;

public class PanelConsumo extends JPanel {

    private ContextoAplicacion contexto;
    private ControladorConsumo controlador;

    private JComboBox<String> cmbHabitaciones;
    private JComboBox<String> cmbCategorias; 
    private JButton btnBuscarHab;
    private JButton btnAgregarProducto; 
    
    private JPanel panelBotones;
    private JScrollPane scrollBotones;

    private JTable tablaCarrito;
    private JLabel lblTotalPagar;
    private JButton btnConfirmarCargo;
    private DefaultTableModel modeloCarrito;
    private double totalAcumulado = 0.0;

    public PanelConsumo(ContextoAplicacion contexto) {
        this.contexto = contexto;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(null);
        setBackground(new Color(242, 242, 242));
        setBounds(0, 0, 1100, 750);

        Font fuenteTitulo = new Font("Poppins", Font.BOLD, 18);
        Font fuenteNormal = new Font("Poppins", Font.BOLD, 13);

        JLabel lblTitulo = new JLabel("FACTURACIÓN - CONSUMOS");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(new Color(0, 204, 204));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        JLabel lblHab = new JLabel("Habitación:");
        lblHab.setForeground(new Color(0, 204, 204));
        lblHab.setFont(fuenteNormal);
        lblHab.setBounds(20, 55, 80, 25);
        add(lblHab);

        cmbHabitaciones = new JComboBox<>();
        cmbHabitaciones.setBounds(100, 55, 120, 25);
        cmbHabitaciones.setForeground(Color.BLACK);
        cmbHabitaciones.setBackground(Color.WHITE);
        cmbHabitaciones.setFont(fuenteNormal);
        cmbHabitaciones.setFocusable(false);
        add(cmbHabitaciones);

       
        btnAgregarProducto = new JButton("+ Nuevo Producto");
        btnAgregarProducto.setBounds(240, 55, 150, 25);
        btnAgregarProducto.setBackground(new java.awt.Color(0, 204, 204));
        btnAgregarProducto.setFont(new java.awt.Font("Poppins", 1, 14));
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setToolTipText("");
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.setFocusable(false);
        btnAgregarProducto.setIconTextGap(10);
        
        btnAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarProducto.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarProducto.setBackground(new Color(0, 204, 204));
            }
        });      
        add(btnAgregarProducto);

        JLabel lblCat = new JLabel("Categoría:");
        lblCat.setForeground(new Color(0, 204, 204));
        lblCat.setFont(fuenteNormal);
        lblCat.setBounds(410, 55, 80, 25);
        add(lblCat);

        cmbCategorias = new JComboBox<>(new String[]{"Todas", "Bebidas", "Comidas", "Snacks", "Otros"});
        cmbCategorias.setBounds(490, 55, 120, 25);
        cmbCategorias.setForeground(Color.BLACK);
        cmbCategorias.setBackground(Color.WHITE);
        cmbCategorias.setFont(fuenteNormal);
        cmbCategorias.setFocusable(false);
        add(cmbCategorias);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 3, 15, 15));
        panelBotones.setBackground(new Color(242, 242, 242));

        scrollBotones = new JScrollPane(panelBotones);
        scrollBotones.setBounds(20, 100, 600, 530);
        scrollBotones.setBorder(null);
        scrollBotones.getVerticalScrollBar().setUnitIncrement(16); 
        add(scrollBotones);

        JLabel lblCart = new JLabel("CARRITO TEMPORAL");
        lblCart.setFont(new Font("Poppins", Font.BOLD, 14));
        lblCart.setForeground(new Color(0, 204, 204));
        lblCart.setBounds(650, 70, 200, 20);
        add(lblCart);

       modeloCarrito = new DefaultTableModel(new Object[]{"Cant.", "Descripción", "Subtotal"}, 0) {
        @Override
         public boolean isCellEditable(int row, int column) {
        return false; 
            }
           };
        tablaCarrito = new JTable(modeloCarrito);
        tablaCarrito.setRowHeight(25);
        
        JTableHeader header = tablaCarrito.getTableHeader();

        header.setBackground(new Color(20, 30, 40));
        header.setForeground(new Color(0, 204, 204));
        header.setFont(new Font("Poppins", Font.BOLD, 13));
        header.setPreferredSize(new Dimension(0, 35));
        header.setBorder(null);
        
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column
                );

                label.setBackground(new Color(20, 30, 40));
                label.setForeground(new Color(0, 204, 204));
                label.setFont(new Font("Poppins", Font.BOLD, 13));
                label.setOpaque(true);
                label.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(0, 0, 0, 1, tablaCarrito.getGridColor()),
                    new EmptyBorder(0, 12, 0, 0) 
                ));

                return label;
            }
        });
        
        tablaCarrito.setBackground(Color.WHITE);
        tablaCarrito.setForeground(Color.BLACK);   
        tablaCarrito.setFont(new Font("Poppins", Font.PLAIN, 13)); 
        tablaCarrito.setRowHeight(20);                             
        tablaCarrito.setGridColor(new Color(0, 204, 204));
        tablaCarrito.setFillsViewportHeight(true);           
        tablaCarrito.setFocusable(false);  
        
        JScrollPane scrollCart = new JScrollPane(tablaCarrito);
        scrollCart.setBounds(650, 100, 400, 400);
        scrollCart.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102)));
        add(scrollCart);

        lblTotalPagar = new JLabel("Total a cargar: RD$ 0.0");
        lblTotalPagar.setFont(new Font("Poppins", Font.BOLD, 22));
        lblTotalPagar.setForeground(new Color(0, 204, 204));
        lblTotalPagar.setBounds(650, 510, 400, 40);
        add(lblTotalPagar);

        btnConfirmarCargo = new JButton("Confirmar Cargo a Habitación");
        btnConfirmarCargo.setBounds(650, 570, 400, 60);
        btnConfirmarCargo.setBackground(new java.awt.Color(0, 204, 204));
        btnConfirmarCargo.setFont(new java.awt.Font("Poppins", 1, 14));
        btnConfirmarCargo.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmarCargo.setToolTipText("");
        btnConfirmarCargo.setBorder(null);
        btnConfirmarCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmarCargo.setFocusable(false);
        btnConfirmarCargo.setIconTextGap(10);
        
        btnConfirmarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfirmarCargo.setBackground(new Color(81, 109, 110));

            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfirmarCargo.setBackground(new Color(0, 204, 204));
            }
        }); 
                
        add(btnConfirmarCargo);
    }

    public void renderizarBotones(ArrayList<Producto> productos, java.awt.event.ActionListener accion) {
        panelBotones.removeAll();

        for (Producto p : productos) {
            JButton btn = new JButton("<html><center>" + p.getNombre() + "<br><b>RD$ " + p.getPrecio() + "</b></center></html>");
            btn.setPreferredSize(new Dimension(180, 120)); 
            
            btn.setFont(new java.awt.Font("Poppins", 1, 14));
            btn.setBackground(new Color(20, 30, 40));
            btn.setForeground(new Color(0, 204, 204));
            btn.setToolTipText("");
            btn.setBorder(null);
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            btn.setFocusable(false);
            btn.setIconTextGap(10);

            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new java.awt.Color(0, 204, 204));
                    btn.setForeground(new java.awt.Color(255, 255, 255));

                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(new Color(20, 30, 40));
                    btn.setForeground(new Color(0, 204, 204));
                }
            }); 
            
            btn.addActionListener(accion);
            panelBotones.add(btn); 
        }
        
        panelBotones.revalidate();
        panelBotones.repaint();
    }

    public void agregarAlCarrito(String nombre, double precio) {
        DefaultTableModel modelo = (DefaultTableModel) tablaCarrito.getModel();
        boolean existe = false;
        int filaDestino = -1;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 1).toString().equals(nombre)) {
                existe = true;
                filaDestino = i;
                break;
            }
        }

        if (existe) {
            int cantidad = Integer.parseInt(modelo.getValueAt(filaDestino, 0).toString()) + 1;
            modelo.setValueAt(cantidad, filaDestino, 0);
            modelo.setValueAt(cantidad * precio, filaDestino, 2);
        } else {
            modelo.addRow(new Object[]{1, nombre, precio});
        }
        
        totalAcumulado += precio;
        lblTotalPagar.setText("Total a cargar: RD$ " + totalAcumulado);
    }

    public void limpiarCarrito() {
        modeloCarrito.setRowCount(0);
        totalAcumulado = 0.0;
        lblTotalPagar.setText("Total a cargar: RD$ 0.0");
    }

    public JComboBox<String> getCmbHabitaciones() { return cmbHabitaciones; }
    public JComboBox<String> getCmbCategorias() { return cmbCategorias; }
    public JButton getBtnConfirmarCargo() { return btnConfirmarCargo; }
    public JButton getBtnAgregarProducto() { return btnAgregarProducto; }
    public JTable getTablaCarrito() { return tablaCarrito; }

    public void setControlador(ControladorConsumo controlador) {
        this.controlador = controlador;
    }
}