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
import vista.consumo.DiagAggProducto;

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
            String categoria = vista.getCmbCategorias().getSelectedItem().toString();
            ArrayList<Producto> productos = dao.listarProductosPorCategoria(categoria);
            
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
            System.out.println("Error al cargar botones filtrados: " + e.getMessage());
        }
    }

    public void iniciar() {
        // --- BLOQUE 1: HABITACIONES ---
        try {
            vista.getCmbHabitaciones().removeAllItems();
            ArrayList<Integer> habitaciones = checkDAO.cargarHabitacionesConReserva();
            for (Integer hab : habitaciones) {
                vista.getCmbHabitaciones().addItem("Habitación " + hab);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar habitaciones (Revisa las columnas de tu BD): " + e.getMessage());
        }

        // --- BLOQUE 2: PRODUCTOS (Ahora están a salvo de los errores de arriba) ---
        cargarBotonesProductos();

        // --- BLOQUE 3: EVENTOS ---
        // Filtro de Categorías
        for (java.awt.event.ActionListener al : vista.getCmbCategorias().getActionListeners()) {
            vista.getCmbCategorias().removeActionListener(al);
        }
        vista.getCmbCategorias().addActionListener(e -> cargarBotonesProductos());

        // Botón Confirmar Cargo
        for (java.awt.event.ActionListener al : vista.getBtnConfirmarCargo().getActionListeners()) {
            vista.getBtnConfirmarCargo().removeActionListener(al);
        }
        vista.getBtnConfirmarCargo().addActionListener(e -> procesarCargoHabitacion());

        // Botón + Nuevo Producto
        for (java.awt.event.ActionListener al : vista.getBtnAgregarProducto().getActionListeners()) {
            vista.getBtnAgregarProducto().removeActionListener(al);
        }
        vista.getBtnAgregarProducto().addActionListener(e -> abrirDialogoNuevoProducto());
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
    
    public void abrirDialogoNuevoProducto() {
        java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(vista);
        DiagAggProducto dialogo = new DiagAggProducto(parent, true);
        
        dialogo.getBtnGuardar().addActionListener(e -> {
            try {
                String nombre = dialogo.getTxtNombre().getText();
                double precio = Double.parseDouble(dialogo.getTxtPrecio().getText());
                String categoria = (String) dialogo.getCmbCategoria().getSelectedItem();
                
                if (nombre.isEmpty()) { 
                    dialogo.mostrarError("El nombre no puede estar vacío"); 
                    return; 
                }

                Producto nuevoProducto = new Producto();
                nuevoProducto.setNombre(nombre);
                nuevoProducto.setPrecio(precio);
                nuevoProducto.setCategoria(categoria);

                if (dao.guardarProductoCatalogo(nuevoProducto)) {
                    dialogo.mostrarExito("Producto agregado correctamente.");
                    dialogo.dispose(); 
                    cargarBotonesProductos(); 
                }
            } catch (NumberFormatException ex) {
                dialogo.mostrarError("Precio inválido.");
            } catch (SQLException ex) {
                dialogo.mostrarError("Error BD: " + ex.getMessage());
            }
        });

        dialogo.setVisible(true);
    }

    public void setDiagAggConsumo(DiagAggConsumo diagAggConsumo) {
        this.diagAggConsumo = diagAggConsumo;
    }

    public void setCheckDAO(CheckDAO checkDAO) {
        this.checkDAO = checkDAO;
    }
}