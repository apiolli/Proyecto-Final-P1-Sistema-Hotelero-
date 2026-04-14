
package controlador;

import dao.CheckDAO;
import dao.ConsumosDAO;
import dao.FacturacionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ReporteFactura;
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
                String texto = "#" + id + " - " + r[1] + " - Hab. " + r[2];
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
            if (datosHuesped != null) {
                vista.getTxtIDReserva().setText(String.valueOf(datosHuesped.getIdReserva()));
                vista.getTxtHuesped().setText(datosHuesped.getHuesped().getNombre() + "" + datosHuesped.getHuesped().getApellido());
                vista.getTxtTelefono().setText(datosHuesped.getHuesped().getTelefono());
                vista.getTxtDocumentoIdentida().setText(datosHuesped.getHuesped().getDocumentoIdentidad());
                vista.getTxtFecha().setText(datosHuesped.getFechaVenta());
                
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
    
//    // 3. Calcular cambio
//    public void calcularCambio() { ... }
//    
//    // 4. Registrar venta
//    public void registrarVenta() { ... }
    
    
}
