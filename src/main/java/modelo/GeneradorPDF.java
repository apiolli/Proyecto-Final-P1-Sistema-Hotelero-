/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
//public class GeneradorPDF {
    
//    public static void generar(ReporteFactura reporte, DefaultTableModel modelo) {
//        File carpeta = new File("facturas");
//        if (!carpeta.exists()) carpeta.mkdirs();
//
//        String ruta = "facturas/factura_" + reporte.getIdReserva() + ".pdf";
//        
//        try {
//            Document doc = new Document();
//            PdfWriter.getInstance(doc, new FileOutputStream(ruta));
//            
//            doc.open();
//            
//            // Logo
//            String rutaLogo = GeneradorPDF.class.getResource("/img/hotelink.png").getPath();
//            Image logo = Image.getInstance(rutaLogo);
//            logo.setAlignment(Element.ALIGN_CENTER);
//            logo.scaleToFit(80, 80);
//            doc.add(logo);
//
//            // Nombre del hotel
//            Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD, BaseColor.DARK_GRAY);
//            Paragraph titulo = new Paragraph("Hotelink - Sistema Hotelero", fuenteTitulo);
//            titulo.setAlignment(Element.ALIGN_CENTER);
//            doc.add(titulo);
//
//            // Datos del hotel
//            Font fuenteSubtitulo = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.GRAY);
//            Paragraph datosHotel = new Paragraph("Calle Principal 123  |  +1 809-000-0000  |  hotelink@gmail.com", fuenteSubtitulo);
//            datosHotel.setAlignment(Element.ALIGN_CENTER);
//            doc.add(datosHotel);
//
//            // Línea separadora
//            LineSeparator linea = new LineSeparator();
//            doc.add(new Chunk(linea));
//            
//            // espacio
//            doc.add(Chunk.NEWLINE);
//
//            // tabla de 2 columnas: datos huesped | numero factura
//            PdfPTable tablaDatos = new PdfPTable(2);
//            tablaDatos.setWidthPercentage(100);
//
//            // celda izquierda - datos del huesped
//            Font fuenteNegrita = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//            Font fuenteNormal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
//
//            PdfPCell celdaIzquierda = new PdfPCell();
//            celdaIzquierda.setBorder(PdfPCell.NO_BORDER);
//            celdaIzquierda.addElement(new Paragraph("Pagado por", fuenteNegrita));
//            celdaIzquierda.addElement(new Paragraph(reporte.getHuesped().getNombre() + " " + reporte.getHuesped().getApellido(), fuenteNormal));
//            celdaIzquierda.addElement(new Paragraph(reporte.getHuesped().getTelefono(), fuenteNormal));
//            celdaIzquierda.addElement(new Paragraph(reporte.getHuesped().getDocumentoIdentidad(), fuenteNormal));
//
//            // celda derecha - numero factura
//            PdfPCell celdaDerecha = new PdfPCell();
//            celdaDerecha.setBorder(PdfPCell.NO_BORDER);
//            celdaDerecha.setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//            Font fuenteRecibo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
//            Paragraph recibo = new Paragraph("RECIBO", fuenteRecibo);
//            recibo.setAlignment(Element.ALIGN_RIGHT);
//            celdaDerecha.addElement(recibo);
//            celdaDerecha.addElement(new Paragraph("Recibo #: 00001", fuenteNormal));
//            
//            String fechaHoy = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
//            
//            Paragraph numeroFactura = new Paragraph("Recibo #: 00001", fuenteNormal);
//            numeroFactura.setAlignment(Element.ALIGN_RIGHT);
//            celdaDerecha.addElement(numeroFactura);
//
//            Paragraph fecha = new Paragraph("Fecha: " + fechaHoy, fuenteNormal);
//            fecha.setAlignment(Element.ALIGN_RIGHT);
//            celdaDerecha.addElement(fecha);
//
//            tablaDatos.addCell(celdaIzquierda);
//            tablaDatos.addCell(celdaDerecha);
//            doc.add(tablaDatos);
//            doc.add(Chunk.NEWLINE);
//            
//                        // línea separadora
//            doc.add(new Chunk(new LineSeparator()));
//            doc.add(Chunk.NEWLINE);
//
//            // tabla con 6 columnas
//            PdfPTable tablaDetalle = new PdfPTable(6);
//            tablaDetalle.setWidthPercentage(100);
//            tablaDetalle.setWidths(new float[]{1, 3, 2, 2, 2, 2}); // anchos de columnas
//
//            // colores
//            BaseColor colorHeader = new BaseColor(20, 30, 40);
//            BaseColor colorCyan = new BaseColor(0, 204, 204);
//
//            // encabezados de la tabla
//            Font fuenteHeader = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, colorCyan);
//            String[] columnas = {"Cantidad", "Descripcion", "Precio Unitario", "Descuento", "ITBIS", "Total"};
//
//            for (String columna : columnas) {
//                PdfPCell celda = new PdfPCell(new Phrase(columna, fuenteHeader));
//                celda.setBackgroundColor(colorHeader);
//                celda.setPadding(8);
//                celda.setBorder(PdfPCell.NO_BORDER);
//                tablaDetalle.addCell(celda);
//            }
//
//            // filas de datos desde el modelo de la tabla
//            Font fuenteFila = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
//            for (int i = 0; i < modelo.getRowCount(); i++) {
//                for (int j = 0; j < modelo.getColumnCount(); j++) {
//                    PdfPCell celda = new PdfPCell(
//                        new Phrase(String.valueOf(modelo.getValueAt(i, j)), fuenteFila)
//                    );
//                    celda.setPadding(6);
//                    celda.setBorderColor(colorCyan);
//                    tablaDetalle.addCell(celda);
//                }
//            }
//
//            doc.add(tablaDetalle);
//            doc.add(Chunk.NEWLINE);
//            
//            // tabla de totales alineada a la derecha
//            PdfPTable tablaTotales = new PdfPTable(2);
//            tablaTotales.setWidthPercentage(40);
//            tablaTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);
//            tablaTotales.setWidths(new float[]{2, 2});
//
//            Font fuenteTotal = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
//            Font fuenteTotalNegrita = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//
//            // metodo helper para agregar filas
//            // Label | Valor
//            Object[][] totales = {
//                {"Subtotal:", String.format("RD$ %.2f", reporte.getSubtotal())},
//                {"ITBIS (18%):", String.format("RD$ %.2f", reporte.getItbis())},
//                {"Descuento:", String.format("RD$ %.2f", reporte.getDescuento())},
//                {"Total a pagar:", String.format("RD$ %.2f", reporte.getTotal())}
//            };
//
//            for (int i = 0; i < totales.length; i++) {
//                boolean esTotal = i == totales.length - 1;
//                Font fuente = esTotal ? fuenteTotalNegrita : fuenteTotal;
//                BaseColor fondo = esTotal ? colorHeader : BaseColor.WHITE;
//                BaseColor fuenteColor = esTotal ? colorCyan : BaseColor.BLACK;
//
//                fuente.setColor(fuenteColor);
//
//                PdfPCell celdaLabel = new PdfPCell(new Phrase((String) totales[i][0], fuente));
//                PdfPCell celdaValor = new PdfPCell(new Phrase((String) totales[i][1], fuente));
//
//                celdaLabel.setBackgroundColor(fondo);
//                celdaValor.setBackgroundColor(fondo);
//                celdaLabel.setPadding(6);
//                celdaValor.setPadding(6);
//                celdaValor.setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//                tablaTotales.addCell(celdaLabel);
//                tablaTotales.addCell(celdaValor);
//            }
//
//            doc.add(tablaTotales);
//            doc.add(Chunk.NEWLINE);
//
//            // nota final
//            Font fuenteNota = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY);
//            Paragraph nota = new Paragraph("Gracias por hospedarse con nosotros. ¡Esperamos su próxima visita!", fuenteNota);
//            nota.setAlignment(Element.ALIGN_CENTER);
//            doc.add(nota);
//            
//            doc.close();
//            
//            // abrir el PDF automáticamente
//            Desktop.getDesktop().open(new File(ruta));
//            
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
//    
//     public void generarFacturaPDF(ReporteFactura reporte, DefaultTableModel modelo) {
//        File carpeta = new File("facturas");
//        if (!carpeta.exists()) carpeta.mkdirs();
//
//        String ruta = "facturas/factura_" + reporte.getIdReserva() + ".pdf";
//         
//        try {
//
//            Date date = new Date();
//            String fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
//            String fechaNueva = "";
//            fechaNueva = fechaActual.replaceAll("/", "_");
//
//            String nombreArchivoPDFVenta = "Venta_" + reporte.getIdReserva() + "_" + fechaNueva + ".pdf";
//
//            FileOutputStream archivo;
//            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
//            archivo = new FileOutputStream(file);
//
//            Document doc = new Document();
//            PdfWriter.getInstance(doc, archivo);
//            doc.open();
//
//            Image img = Image.getInstance("src/img/ventas.png");
//            Paragraph fecha = new Paragraph();
//            Font negrita = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK);
//            fecha.add(Chunk.NEWLINE); 
//            fecha.add("Factura: 001" + "\nFecha: " + fechaActual + "\n\n");
//
//            PdfPTable Encabezado = new PdfPTable(4);
//            Encabezado.setWidthPercentage(100);
//            Encabezado.getDefaultCell().setBorder(0);
//
//            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
//            Encabezado.setWidths(ColumnaEncabezado);
//            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
//            Encabezado.addCell(img);
//
//            String titulo = "Hotelink - Sistema hotelero";
//            String nombre = "Cesar Diaz";
//            String telefono = "809-123-3322";
//            String direccion = "Santo Domingo, Republica Dominicana";
//            String razon = "El mejor sistema hotelero";
//
//            Encabezado.addCell(""); 
//            Encabezado.addCell(titulo + "\n\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
//            Encabezado.addCell(fecha);
//            doc.add(Encabezado);
//
//            //CUERPO
//            Paragraph cliente = new Paragraph();
//            cliente.add(Chunk.NEWLINE);//nueva linea
//            cliente.add("Datos del cliente: " + "\n\n");
//            doc.add(cliente);
//
//            //DATOS DEL CLIENTE
//            PdfPTable tablaCliente = new PdfPTable(4);
//            tablaCliente.setWidthPercentage(100);
//            tablaCliente.getDefaultCell().setBorder(0);//quitar bordes
//            //tamaño de las celdas
//            float[] ColumnaCliente = new float[]{25f, 45f, 30f, 40f};
//            tablaCliente.setWidths(ColumnaCliente);
//            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
//            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/RUC: ", negrita));
//            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
//            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
//            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));
//            //quitar bordes 
//            cliente1.setBorder(0);
//            cliente2.setBorder(0);
//            cliente3.setBorder(0);
//            cliente4.setBorder(0);
//            //agg celda a la tabla
//            tablaCliente.addCell(cliente1);
//            tablaCliente.addCell(cliente2);
//            tablaCliente.addCell(cliente3);
//            tablaCliente.addCell(cliente4);
//            tablaCliente.addCell(cedulaCliente);
//            tablaCliente.addCell(nombreCliente);
//            tablaCliente.addCell(telefonoCliente);
//            tablaCliente.addCell(direccionCliente);
//            //agregar al documento
//            doc.add(tablaCliente);
//            
//            //ESPACIO EN BLANCO
//            Paragraph espacio = new Paragraph();
//            espacio.add(Chunk.NEWLINE);
//            espacio.add("");
//            espacio.setAlignment(Element.ALIGN_CENTER);
//            doc.add(espacio);
//            
//            //AGREGAR LOS PRODUCTOS
//            PdfPTable tablaProducto = new PdfPTable(4);
//            tablaProducto.setWidthPercentage(100);
//            tablaProducto.getDefaultCell().setBorder(0);
//            //tamaño de celdas
//             float[] ColumnaProducto = new float[]{15f, 50f, 15f, 20f};
//             tablaProducto.setWidths(ColumnaProducto);
//             tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
//             PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
//             PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
//             PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
//             PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));
//             //quitar bordes
//             producto1.setBorder(0);
//             producto2.setBorder(0);
//             producto3.setBorder(0);
//             producto4.setBorder(0);
//             //agregar color al encabezadi del producto
//             producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
//             producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
//             producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
//             producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            //agg celda a la tabla
//            tablaProducto.addCell(producto1);
//            tablaProducto.addCell(producto2);
//            tablaProducto.addCell(producto3);
//            tablaProducto.addCell(producto4);
//            
//            for(int i = 0; i < InterFacturacion.jTable_productos.getRowCount(); i++){
//                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
//                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
//                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
//                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();
//                
//                tablaProducto.addCell(cantidad);
//                tablaProducto.addCell(producto);
//                tablaProducto.addCell(precio);
//                tablaProducto.addCell(total);
//            }
//            
//            //agregar al documento
//            doc.add(tablaProducto);
//            
//            //Total pagar
//            Paragraph info = new Paragraph();
//            info.add(Chunk.NEWLINE);
//            info.add("Total a pagar: " + InterFacturacion.txt_total_pagar.getText());
//            info.setAlignment(Element.ALIGN_RIGHT);
//            doc.add(info);
//            
//            //Firma
//           Paragraph firma = new Paragraph();
//           firma.add(Chunk.NEWLINE);
//           firma.add("Cancelacion y firma\n\n");
//           firma.add("_______________________");
//           firma.setAlignment(Element.ALIGN_CENTER);
//           doc.add(firma);
//           
//            //Mensaje
//           Paragraph mensaje = new Paragraph();
//           mensaje.add(Chunk.NEWLINE);
//           mensaje.add("¡Gracias por su compra!");
//           mensaje.setAlignment(Element.ALIGN_CENTER);
//           doc.add(mensaje);
//           
//           //cerrar el documento y el archivo
//           doc.close();
//           archivo.close();
//           
//           //abrir el documento al ser generado automaticamente
//            Desktop.getDesktop().open(file);
//            
//            
//        } catch (DocumentException | IOException e) {
//            System.out.println("Error en: " + e);
//        }
//    }
//
//}
