package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.PanelFacturacion;

public class ControladorFacturaPDF {
    
    private PanelFacturacion vista;

    public ControladorFacturaPDF(PanelFacturacion vista) {
        this.vista = vista;
    }

    public void generarFacturaPDF() {
        try {

            Date date = new Date();
            String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaNueva = fechaActual.replaceAll("/", "_");

            String ruta = "facturas" + File.separator + "Facturacion_" + vista.getTxtHuesped()+ "_" + vista.getTxtIDReserva() + "_" + vista.getTxtFecha() + ".pdf";

            File carpeta = new File("facturas");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(ruta));

            doc.open();

            String rutaLogo = ControladorFacturaPDF.class.getResource("/img/hotelink.png").getPath();
            Image logo = Image.getInstance(rutaLogo);
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);
            
            
            logo.setAlignment(Element.ALIGN_CENTER);
            logo.scaleToFit(80, 80);
            doc.add(logo);

            Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.DARK_GRAY);
            Paragraph titulo = new Paragraph("Hotelink - Sistema Hotelero", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            Font fuenteSubtitulo = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.GRAY);
            Paragraph datosHotel = new Paragraph("Calle Principal 123  |  +1 809-000-0000  |  hotelink@gmail.com", fuenteSubtitulo);
            datosHotel.setAlignment(Element.ALIGN_CENTER);
            doc.add(datosHotel);

            LineSeparator linea = new LineSeparator();
            doc.add(new Chunk(linea));

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: " + "\n\n");
            doc.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);

            
            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Doc de identidad: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("ID Reserva: ", negrita));

            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(vista.getTxtDocumentoIdentida().getText());
            tablaCliente.addCell(vista.getTxtHuesped().getText());
            tablaCliente.addCell(vista.getTxtTelefono().getText());
            tablaCliente.addCell(vista.getTxtIDReserva().getText());

            doc.add(tablaCliente);
            
            Paragraph espacio = new Paragraph();
            doc.add(new Chunk(linea));

            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            
            PdfPTable tablaProducto = new PdfPTable(6);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            
            float[] ColumnaProducto = new float[]{1, 3, 2, 2, 2, 2};
            tablaProducto.setWidths(ColumnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell descrip = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell precioU = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell descuento = new PdfPCell(new Phrase("Descuento: ", negrita));
            PdfPCell itbis = new PdfPCell(new Phrase("ITBIS: ", negrita));
            PdfPCell total = new PdfPCell(new Phrase("Total: ", negrita));

            cantidad.setBorder(0);
            descrip.setBorder(0);
            precioU.setBorder(0);
            descuento.setBorder(0);
            itbis.setBorder(0);
            total.setBorder(0);

            cantidad.setBackgroundColor(BaseColor.LIGHT_GRAY);
            descrip.setBackgroundColor(BaseColor.LIGHT_GRAY);
            precioU.setBackgroundColor(BaseColor.LIGHT_GRAY);
            descuento.setBackgroundColor(BaseColor.LIGHT_GRAY);
            itbis.setBackgroundColor(BaseColor.LIGHT_GRAY);
            total.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablaProducto.addCell(cantidad);
            tablaProducto.addCell(descrip);
            tablaProducto.addCell(precioU);
            tablaProducto.addCell(descuento);
            tablaProducto.addCell(itbis);
            tablaProducto.addCell(total);
            
            for(int i = 0; i < vista.getTablaFactura().getRowCount(); i++){
                String cantidadTabla = vista.getTablaFactura().getValueAt(i, 0).toString();
                String descripcionTabla = vista.getTablaFactura().getValueAt(i, 1).toString();
                String precioUTabla = vista.getTablaFactura().getValueAt(i, 2).toString();
                String descuentoTabla = vista.getTablaFactura().getValueAt(i, 3).toString();
                String itbisTabla = vista.getTablaFactura().getValueAt(i, 4).toString();
                String totalTabla = vista.getTablaFactura().getValueAt(i, 5).toString();
                
                tablaProducto.addCell(cantidadTabla);
                tablaProducto.addCell(descripcionTabla);
                tablaProducto.addCell(precioUTabla);
                tablaProducto.addCell(descuentoTabla);
                tablaProducto.addCell(itbisTabla);
                tablaProducto.addCell(totalTabla);
            }
            
            doc.add(tablaProducto);
            
            //Total pagar
            Paragraph info = new Paragraph();
            doc.add(new Chunk(linea));
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + vista.getTxtTotal().getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            //Firma
           Paragraph firma = new Paragraph();
           firma.add(Chunk.NEWLINE);
           firma.add("Cancelacion y firma\n\n");
           firma.add("_______________________");
           firma.setAlignment(Element.ALIGN_CENTER);
           doc.add(firma);
           
           Paragraph mensaje = new Paragraph();
           mensaje.add(Chunk.NEWLINE);
           mensaje.add("¡Gracias por preferirnos!");
           mensaje.setAlignment(Element.ALIGN_CENTER);
           doc.add(mensaje);
           
           doc.close();
           
           Desktop.getDesktop().open(new File(ruta));
            
            
        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }

}
