package vista.consumo;

import app.ContextoAplicacion;
import controlador.ControladorConsumo;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class PanelConsumo extends JPanel {

    private ContextoAplicacion contexto;
    private ControladorConsumo controlador;

    // Componentes visuales
    private JComboBox<String> cmbHabitaciones;
    private JComboBox<String> cmbCategorias; // NUEVO: Para filtrar
    private JButton btnBuscarHab;
    private JButton btnAgregarProducto; // NUEVO: Para crear en BD
    
    // Contenedor dinámico para botones
    private JPanel panelBotones;
    private JScrollPane scrollBotones;

    // Carrito
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
        setBackground(new Color(30, 30, 30));
        setBounds(0, 0, 1100, 750);

        Font fuenteTitulo = new Font("Poppins", Font.BOLD, 18);
        Font fuenteNormal = new Font("Poppins", Font.PLAIN, 13);

        // --- ENCABEZADO Y HABITACIÓN ---
        JLabel lblTitulo = new JLabel("FACTURACIÓN - CONSUMOS");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(new Color(192, 255, 255));
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        JLabel lblHab = new JLabel("Habitación:");
        lblHab.setForeground(Color.WHITE);
        lblHab.setFont(fuenteNormal);
        lblHab.setBounds(20, 55, 80, 25);
        add(lblHab);

        cmbHabitaciones = new JComboBox<>();
        cmbHabitaciones.setBounds(100, 55, 120, 25);
        add(cmbHabitaciones);

       
        btnAgregarProducto = new JButton("+ Nuevo Producto");
        btnAgregarProducto.setBounds(240, 55, 150, 25);
        btnAgregarProducto.setBackground(new Color(0, 204, 204)); // El Cian del botón confirmar
        btnAgregarProducto.setForeground(Color.WHITE);
        btnAgregarProducto.setFocusPainted(false);
        btnAgregarProducto.setBorder(null); // Sin borde para que se vea más moderno
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnAgregarProducto);

        JLabel lblCat = new JLabel("Categoría:");
        lblCat.setForeground(Color.WHITE);
        lblCat.setFont(fuenteNormal);
        lblCat.setBounds(410, 55, 80, 25);
        add(lblCat);

        cmbCategorias = new JComboBox<>(new String[]{"Todas", "Bebidas", "Comidas", "Snacks", "Otros"});
        cmbCategorias.setBounds(490, 55, 120, 25);
        add(cmbCategorias);

        // --- PANEL DINÁMICO DE BOTONES CON SCROLL (GRID LAYOUT) ---
        panelBotones = new JPanel();
        // GridLayout: 0 filas (infinitas), 3 columnas, 15px de espacio horizontal y vertical
        panelBotones.setLayout(new GridLayout(0, 3, 15, 15));
        panelBotones.setBackground(new Color(30, 30, 30));

        scrollBotones = new JScrollPane(panelBotones);
        scrollBotones.setBounds(20, 100, 600, 530);
        scrollBotones.setBorder(null);
        scrollBotones.getVerticalScrollBar().setUnitIncrement(16); 
        add(scrollBotones);

        // --- PANEL DEL CARRITO (LADO DERECHO) ---
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
        tablaCarrito.setBackground(new Color(45, 45, 45));
        tablaCarrito.setForeground(Color.WHITE);
        tablaCarrito.setRowHeight(25);
        
        JScrollPane scrollCart = new JScrollPane(tablaCarrito);
        scrollCart.setBounds(650, 100, 400, 400);
        scrollCart.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102)));
        add(scrollCart);

        lblTotalPagar = new JLabel("Total a cargar: RD$ 0.0");
        lblTotalPagar.setFont(new Font("Poppins", Font.BOLD, 22));
        lblTotalPagar.setForeground(new Color(192, 255, 255));
        lblTotalPagar.setBounds(650, 510, 400, 40);
        add(lblTotalPagar);

        btnConfirmarCargo = new JButton("Confirmar Cargo a Habitación");
        btnConfirmarCargo.setBounds(650, 570, 400, 60);
        btnConfirmarCargo.setBackground(new Color(0, 204, 204));
        btnConfirmarCargo.setForeground(Color.WHITE);
        btnConfirmarCargo.setFont(new Font("Poppins", Font.BOLD, 16));
        btnConfirmarCargo.setFocusPainted(false);
        add(btnConfirmarCargo);
    }

    // --- MÉTODO ACTUALIZADO PARA RENDERIZAR EN GRID LAYOUT ---
    public void renderizarBotones(ArrayList<Producto> productos, java.awt.event.ActionListener accion) {
        panelBotones.removeAll();

        for (Producto p : productos) {
            JButton btn = new JButton("<html><center>" + p.getNombre() + "<br><b>RD$ " + p.getPrecio() + "</b></center></html>");
            btn.setPreferredSize(new Dimension(180, 120)); 
            
            btn.setBackground(new Color(51, 51, 51));
            btn.setForeground(new Color(192, 255, 255));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102)));
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
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

    // --- GETTERS ---
    public JComboBox<String> getCmbHabitaciones() { return cmbHabitaciones; }
    public JComboBox<String> getCmbCategorias() { return cmbCategorias; }
    public JButton getBtnConfirmarCargo() { return btnConfirmarCargo; }
    public JButton getBtnAgregarProducto() { return btnAgregarProducto; }
    public JTable getTablaCarrito() { return tablaCarrito; }

    public void setControlador(ControladorConsumo controlador) {
        this.controlador = controlador;
    }
}