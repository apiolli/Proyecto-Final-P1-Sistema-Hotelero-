package vista.consumo;

import app.ContextoAplicacion;
import controlador.ControladorConsumo;
import java.awt.Color;
import java.awt.Font;
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


    private JComboBox<String> cmbHabitaciones;
    private JTable tablaCarrito;
    private JLabel lblTotalPagar;
    private JButton btnConfirmarCargo;
    private JButton btnBuscarHab;
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

      
        JLabel lblTitulo = new JLabel("FACTURACIÓN - CONSUMOS");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(new Color(192, 255, 255)); // Cian
        lblTitulo.setBounds(20, 10, 400, 30);
        add(lblTitulo);

        JLabel lblHab = new JLabel("Cargar a Habitación:");
        lblHab.setForeground(Color.WHITE);
        lblHab.setFont(fuenteNormal);
        lblHab.setBounds(20, 55, 150, 25);
        add(lblHab);

        cmbHabitaciones = new JComboBox<>();
        cmbHabitaciones.setBounds(170, 55, 150, 25);
        add(cmbHabitaciones);

        btnBuscarHab = new JButton("Buscar");
        btnBuscarHab.setBounds(330, 55, 100, 25);
        btnBuscarHab.setBackground(new Color(51, 51, 51));
        btnBuscarHab.setForeground(Color.WHITE);
        add(btnBuscarHab);

    
        JLabel lblCart = new JLabel("CARRITO TEMPORAL");
        lblCart.setFont(new Font("Poppins", Font.BOLD, 14));
        lblCart.setForeground(new Color(0, 204, 204));
        lblCart.setBounds(650, 70, 200, 20);
        add(lblCart);

        modeloCarrito = new DefaultTableModel(new Object[]{"Cant.", "Descripción", "Subtotal"}, 0);
        tablaCarrito = new JTable(modeloCarrito);
        tablaCarrito.setBackground(new Color(45, 45, 45));
        tablaCarrito.setForeground(Color.WHITE);
        tablaCarrito.setRowHeight(25);
        
        JScrollPane scroll = new JScrollPane(tablaCarrito);
        scroll.setBounds(650, 100, 400, 400);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102)));
        add(scroll);

        lblTotalPagar = new JLabel("Total a cargar: RD$ 0.0");
        lblTotalPagar.setFont(new Font("Poppins", Font.BOLD, 22));
        lblTotalPagar.setForeground(new Color(192, 255, 255));
        lblTotalPagar.setBounds(650, 510, 400, 40);
        add(lblTotalPagar);

        btnConfirmarCargo = new JButton("Confirmar Cargo a Habitación");
        btnConfirmarCargo.setBounds(650, 570, 400, 60);
        btnConfirmarCargo.setBackground(new Color(0, 204, 204)); // Cian brillante
        btnConfirmarCargo.setForeground(Color.WHITE);
        btnConfirmarCargo.setFont(new Font("Poppins", Font.BOLD, 16));
        btnConfirmarCargo.setFocusPainted(false);
        add(btnConfirmarCargo);
    }

    
    public void renderizarBotones(ArrayList<Producto> productos, java.awt.event.ActionListener accion) {
       
        for (java.awt.Component comp : this.getComponents()) {
            if (comp instanceof JButton && comp != btnConfirmarCargo && comp != btnBuscarHab) {
                this.remove(comp);
            }
        }

        int x = 20;
        int y = 100;
        int columnas = 0;

       
        for (Producto p : productos) {
            JButton btn = new JButton("<html><center>" + p.getNombre() + "<br><b>RD$ " + p.getPrecio() + "</b></center></html>");
            btn.setBounds(x, y, 180, 130);
            
          
            btn.setBackground(new Color(51, 51, 51));
            btn.setForeground(new Color(192, 255, 255));
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 102)));
            btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            
            btn.addActionListener(accion);
            this.add(btn);

            columnas++;
            if (columnas == 3) { 
                x = 20;
                y += 150;
                columnas = 0;
            } else {
                x += 200;
            }
        }
        
        this.revalidate();
        this.repaint();
    }

  
  public void agregarAlCarrito(String nombre, double precio) {
    DefaultTableModel modelo = (DefaultTableModel) tablaCarrito.getModel();
    boolean existe = false;
    int filaDestino = -1;

  
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String nombreEnTabla = modelo.getValueAt(i, 1).toString();
        if (nombreEnTabla.equals(nombre)) {
            existe = true;
            filaDestino = i;
            break;
        }
    }

    if (existe) {
     
        int cantidadActual = Integer.parseInt(modelo.getValueAt(filaDestino, 0).toString());
        int nuevaCantidad = cantidadActual + 1;
        double nuevoSubtotal = nuevaCantidad * precio;
        modelo.setValueAt(nuevaCantidad, filaDestino, 0);
        modelo.setValueAt(nuevoSubtotal, filaDestino, 2);
    } else {
        modelo.addRow(new Object[]{1, nombre, precio});
    }


    totalAcumulado += precio;
    lblTotalPagar.setText("Total a cargar: RD$ " + totalAcumulado);
}

    public JComboBox<String> getCmbHabitaciones() { return cmbHabitaciones; }
    public JButton getBtnConfirmarCargo() { return btnConfirmarCargo; }
    public JTable getTablaCarrito() { return tablaCarrito; }

    public void setControlador(ControladorConsumo controlador) {
        this.controlador = controlador;
    }
    
    public void limpiarCarrito() {
    modeloCarrito.setRowCount(0); 
    totalAcumulado = 0.0;     
    lblTotalPagar.setText("Total a cargar: RD$ 0.0");
}
}