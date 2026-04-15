package controlador;

import dao.CheckDAO;
import dao.ConsumosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.Timer;
import modelo.Consumo;
import modelo.Producto; 
import vista.consumo.DiagAggConsumo;
import vista.consumo.PanelConsumo;

public class ControladorConsumo {
    private ConsumosDAO dao;
    private PanelConsumo vista;
    private DiagAggConsumo diagAggConsumo;
    private CheckDAO checkDAO;
    private Timer timer;

    public ControladorConsumo(PanelConsumo vista, ConsumosDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void cargarBotonesProductos() {
        try {
            ArrayList<Producto> productos = dao.listarProductosCatálogo();
            
            vista.renderizarBotones(productos, e -> {
                JButton btn = (JButton) e.getSource();
                for (Producto p : productos) {
                    if (btn.getText().contains(p.getNombre())) {
                        vista.agregarAlCarrito(p.getNombre(), p.getPrecio());
                        break;
                    }
                }
            });

        } catch (SQLException e) {
            System.out.println("Error al cargar botones: " + e.getMessage());
        }
    }

    public void iniciar() {
        try {
  
            vista.getCmbHabitaciones().removeAllItems();
            ArrayList<Integer> habitaciones = checkDAO.cargarHabitacionesOcupadas();
            for (Integer hab : habitaciones) {
                vista.getCmbHabitaciones().addItem("Habitación " + hab);
            }
            cargarBotonesProductos();
            
            for (java.awt.event.ActionListener al : vista.getBtnConfirmarCargo().getActionListeners()) {
                vista.getBtnConfirmarCargo().removeActionListener(al);
            }
            vista.getBtnConfirmarCargo().addActionListener(e -> procesarCargoHabitacion());

        } catch (SQLException e) {
            System.out.println("Error al iniciar POS: " + e.getMessage());
        }
    }

    public void procesarCargoHabitacion() {
        String item = (String) vista.getCmbHabitaciones().getSelectedItem();
        if (item == null) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Seleccione una habitación");
            return;
        }
        int noHabitacion = Integer.parseInt(item.replace("Habitación ", ""));

        try {
            Object[] reserva = checkDAO.buscarReserva(noHabitacion);
            if (reserva == null) {
                javax.swing.JOptionPane.showMessageDialog(vista, "No hay reserva activa");
                return;
            }
            int idReserva = (int) reserva[0];

            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) vista.getTablaCarrito().getModel();
            if (modelo.getRowCount() == 0) {
                javax.swing.JOptionPane.showMessageDialog(vista, "El carrito está vacío");
                return;
            }

            for (int i = 0; i < modelo.getRowCount(); i++) {
                int cantidad = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                String descripcion = modelo.getValueAt(i, 1).toString();
                double subtotal = Double.parseDouble(modelo.getValueAt(i, 2).toString());
                double precioUnitario = subtotal / cantidad;

                Consumo nuevoConsumo = new Consumo(idReserva, descripcion, cantidad, precioUnitario);
                dao.guardar(nuevoConsumo);
            }

            javax.swing.JOptionPane.showMessageDialog(vista, "¡Cargos aplicados con éxito!");
            
            vista.limpiarCarrito(); 
            
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(vista, "Error al guardar: " + e.getMessage());
        }
    }

    public void buscarReserva() {
        if (diagAggConsumo == null) return;
        try {
            int noHab = Integer.parseInt(diagAggConsumo.getCmbHab().getSelectedItem().toString());
            Object[] reserva = checkDAO.buscarReserva(noHab);
            if (reserva != null) {
                diagAggConsumo.getTxtIDreserva().setText(String.valueOf(reserva[0]));
                diagAggConsumo.getTxtHuesped().setText((String) reserva[1]);
            }
        } catch (Exception e) {
            diagAggConsumo.mostrarError("Error al buscar reserva");
        }
    }

    public void agregarConsumo() {
        if (diagAggConsumo == null) return;
        try {
            int idReserva = Integer.parseInt(diagAggConsumo.getTxtIDreserva().getText());
            String desc = diagAggConsumo.getTxtDescripcion().getText();
            int cant = Integer.parseInt(diagAggConsumo.getSpCantidad().getValue().toString());
            double precio = Double.parseDouble(diagAggConsumo.getTxtPrecio().getText());
            
            Consumo consumo = new Consumo(idReserva, desc, cant, precio);
            if (dao.guardar(consumo) > 0) {
                diagAggConsumo.mostrarExito("Consumo agregado");
            }
        } catch (Exception e) {
            diagAggConsumo.mostrarError("Error al guardar");
        }
    }

    public void setDiagAggConsumo(DiagAggConsumo diagAggConsumo) {
        this.diagAggConsumo = diagAggConsumo;
    }

    public void setCheckDAO(CheckDAO checkDAO) {
        this.checkDAO = checkDAO;
    }
}