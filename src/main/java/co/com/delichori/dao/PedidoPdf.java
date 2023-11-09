package co.com.delichori.dao;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import co.com.delichori.model.Pedido;

import java.io.File;
import java.io.FileNotFoundException;

public class PedidoPdf {


    public static void generarPdf(Pedido pedido, String rutaArchivo) {
        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar contenido al PDF
            document.add(new Paragraph("Pedido ID: " + pedido.getIdPedido()));
            document.add(new Paragraph("Cédula Cliente: " + pedido.getCedulaCliente()));
            document.add(new Paragraph("Nombre Cliente: " + pedido.getNombreCliente()));
            document.add(new Paragraph("Apellido Cliente: " + pedido.getApellidoCliente()));
            document.add(new Paragraph("Dirección Cliente: " + pedido.getDireccionCliente()));
            document.add(new Paragraph("Cantidad del producto: " + pedido.getCantidadProducto()));
            document.add(new Paragraph("Fecha del Pedido: " + pedido.getFechaPedido()));
            document.add(new Paragraph("Valor Total Pedido: " + pedido.getValorTotalPedido()));

            document.close();

            System.out.println("PDF generado correctamente en: " + rutaArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Pedido pedido = new Pedido(); // Aquí debes tener tu objeto Pedido con los datos necesarios
        String rutaArchivo = "pedido.pdf"; // Ruta donde se guardará el archivo PDF
        generarPdf(pedido, rutaArchivo);
    }
}

