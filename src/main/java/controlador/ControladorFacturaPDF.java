/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import dao.PdfDAO;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.PanelFacturacion;

/**
 *
 * @author DELL
 */
public class ControladorFacturaPDF {
    private String nombreHuesped;
    private String documentoHuesped;
    private String telefonoHuesped;
    private String nacionalidadHuesped;
    
    private String fechaActual = "";
    private String nombrePDF = "";
    
    private PanelFacturacion vistaFacturacion;
    private PdfDAO dao;

    public ControladorFacturaPDF(PanelFacturacion vistaFacturacion, PdfDAO dao) {
        this.vistaFacturacion = vistaFacturacion;
        this.dao = dao;
    }
    
    private void datosHuesped(int id) {
        Connection con = Conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement("select nombre, apellido, documentoIdentidad, telefono, nacionalidad from huesped where id=?*");
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                nombreHuesped = rs.getString("nombre") + rs.getString("apellido");
                documentoHuesped = rs.getString("documentoIdentidad");
                telefonoHuesped = rs.getString("telefono");
                nacionalidadHuesped = rs.getString("nacionalidadCliente");
                
            }
            con.close();
            
        } catch (SQLException e) {
            vistaFacturacion.mostrarError("Error al obtener los datos del PDF");
        }
        
    }
    
//    private void generarPDF() {
//        try {
//            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
//            String fechaNueva = "";
//            fechaNueva = fechaActual.replaceAll("/", "_");
//            
//            nombrePDF = "Facturacion_" + nombreHuesped + "_" + fechaNueva + ".pdf";
//            
//            FileOutputStream archivo;
//            File file = new File("src/pdf/" + nombrePDF);
//            archivo = new FileOutputStream(file);
//            
//            Document doc = new Document();
//            PdfWriter.getInstance(doc, archivo);
//            
//            Image img = Image.getInstance("src/img/hotelink.png");
//            Image 
//
//        } catch (DocumentException | IOException e) {
//            System.out.println("Error en: " + e.getMessage());
//        }
//    }
}
