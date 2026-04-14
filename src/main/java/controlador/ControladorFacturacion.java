
package controlador;

import dao.CheckDAO;
import dao.ConsumosDAO;
import dao.FacturacionDAO;
import vista.PanelFacturacion;

public class ControladorFacturacion {
    private PanelFacturacion vista;
    private FacturacionDAO dao;
    private CheckDAO checkDAO;
    private ConsumosDAO consumosDAO;
    
    public ControladorFacturacion(PanelFacturacion vista, FacturacionDAO dao, CheckDAO checkDAO, ConsumosDAO consumosDAO) {
        this.vista = vista;
        this.dao = dao;
    }
    
//    // 1. Carga reservas completadas en el comboBox
//    public void iniciar() { ... }
//    
//    // 2. Al seleccionar una reserva del comboBox
//    public void cargarFactura() { ... }
//    
//    // 3. Calcular cambio
//    public void calcularCambio() { ... }
//    
//    // 4. Registrar venta
//    public void registrarVenta() { ... }
    
    
}
