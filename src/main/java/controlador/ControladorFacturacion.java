
package controlador;

import dao.CheckDAO;
import dao.ConsumosDAO;
import dao.FacturacionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;
import modelo.ReporteFactura;
import modelo.personas.Huesped;
import vista.PanelFacturacion;

public class ControladorFacturacion {
    private PanelFacturacion vista;
    private FacturacionDAO dao;
    private CheckDAO checkDAO;
    private ConsumosDAO consumosDAO;
    private ArrayList<Integer> idsReservas = new ArrayList<>();
    
    public ControladorFacturacion(PanelFacturacion vista, FacturacionDAO dao, CheckDAO checkDAO, ConsumosDAO consumosDAO) {
        this.vista = vista;
        this.dao = dao;
    }
    
    public void iniciar() { 
        try {
            idsReservas.clear();
            vista.getCmbReservasCompletadas().removeAllItems();

            ArrayList<Object[]> reservas = dao.cargarReservasCompletadas();
            for (Object[] r : reservas) {
                int id = (int) r[0];
                String texto = "ID: " + id + " | " + r[1] + " " + r[2] + " | Hab. " + r[3];
                vista.getCmbReservasCompletadas().addItem(texto);
                idsReservas.add(id);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error SQL");
        }
    
    }
    
    public void cargarFactura() {
        try {
            int id = idsReservas.get(vista.getCmbReservasCompletadas().getSelectedIndex());
            ReporteFactura datosHuesped = dao.cargarDatosReserva(id);
            
            String seleccion = vista.getCmbReservasCompletadas().getSelectedItem().toString();
            String[] partes = seleccion.split(" \\| ");
            System.out.println("Cantidad de partes: " + partes.length);
            for (String parte : partes) {
                System.out.println("Parte: '" + parte + "'");
            }
            
            if (datosHuesped != null) {
                vista.getTxtIDReserva().setText(String.valueOf(datosHuesped.getIdReserva()));
                vista.getTxtHuesped().setText(datosHuesped.getHuesped().getNombre() + " " + datosHuesped.getHuesped().getApellido());
                vista.getTxtTelefono().setText(datosHuesped.getHuesped().getTelefono());
                vista.getTxtDocumentoIdentida().setText(datosHuesped.getHuesped().getDocumentoIdentidad());
                vista.getTxtFecha().setText(datosHuesped.getFechaVenta());
                
                cargarDetalleFactura(id);
                vista.mostrarExito("Datos de factura generados.");
            }
            else {
                vista.mostrarError("No se han podido cargar los datos del huesped");
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Ha ocurrido un error para cargar esa reserva, ingrese otra.");
        }
    
    }
    
    public void cargarDetalleFactura(int idReserva) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) vista.getTablaFactura().getModel();
            modelo.setRowCount(0);

            ArrayList<Object[]> detalle = dao.cargarDetalleFactura(idReserva);
            for (Object[] fila : detalle) {
                modelo.addRow(fila);
            }
            calcularTotales();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void calcularTotales() {
        double subtotal = 0, itbis = 0, total = 0;
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaFactura().getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            int cantidad = (int) modelo.getValueAt(i, 0);
            double precioUnitario = (double) modelo.getValueAt(i, 2);
            double itbisUnitario = (double) modelo.getValueAt(i, 4);

            subtotal += cantidad * precioUnitario;
            itbis    += itbisUnitario * cantidad;
            total    += (double) modelo.getValueAt(i, 5);
        }

        vista.getTxtSubtotal().setText(String.valueOf(subtotal));
        vista.getTxtITBIS().setText(String.valueOf(itbis));
        vista.getTxtTotal().setText(String.valueOf(total));
    }
    
    public void registrarVenta() {
        try {
            int idReserva = idsReservas.get(vista.getCmbReservasCompletadas().getSelectedIndex());
            System.out.println("Huesped: '" + vista.getTxtHuesped().getText() + "'");
            
            String nombreCompleto = vista.getTxtHuesped().getText();
            String[] partesNombres = nombreCompleto.split(" ");
            String nombre = partesNombres[0];
            String apellido = partesNombres[1];
            
            
            String seleccion = vista.getCmbReservasCompletadas().getSelectedItem().toString();
            int habitacion = Integer.parseInt(seleccion.split(" \\| ")[2].replace("Hab. ", ""));
            double descuento = vista.getTxtDescuento().getText().isEmpty() ? 0.0 : Double.parseDouble(vista.getTxtDescuento().getText());

            ReporteFactura reporte = new ReporteFactura();
            reporte.setIdReserva(idReserva);
            reporte.setHuesped(new Huesped(nombre, apellido));
            reporte.setHabitacion(habitacion);
            reporte.setSubtotal(Double.parseDouble(vista.getTxtSubtotal().getText()));
            reporte.setItbis(Double.parseDouble(vista.getTxtITBIS().getText()));
            reporte.setDescuento(descuento);
            reporte.setTotal(Double.parseDouble(vista.getTxtTotal().getText()));
            reporte.setFormaPago(vista.getCmbFormaPago().getSelectedItem().toString());

            int respuesta = dao.registrarVenta(reporte);
            if (respuesta > 0) {
                dao.eliminarReserva(idReserva);
                vista.mostrarExito("Venta registrada con éxito");
                iniciar();
            } else {
                vista.mostrarError("Error al registrar la venta");
            }
        } catch (SQLException e) {
            vista.mostrarError("Error de base de datos");
            System.out.println(e.getMessage());
        }
    }
    
    public void calcularCambio() {
        double efectivo = Double.parseDouble(vista.getTxtEfectivo().getText());
        double total = Double.parseDouble(vista.getTxtTotal().getText());
        double cambio = efectivo - total;
        vista.getTxtCambio().setText(String.format("%.2f", cambio));
    }
    
    
}
