package co.com.delichori.dao;
import co.com.delichori.conexion.Conexion;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import co.com.delichori.model.Pedido;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoPdf {

    public static void generarPdf(Pedido pedido, String rutaArchivo) {


        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            PreparedStatement ps = null;
            ResultSet rs = null;

            try (Connection connect = Conexion.get_connetion()) {
                String query = "SELECT * FROM pedido where pedido.cedulaCliente = cedulaCliente";

                ps = connect.prepareStatement(query);
                rs = ps.executeQuery();


                while (rs.next()) {
                    System.out.println("\n");
                    document.add(new Paragraph("Pedido ID: " + rs.getInt("idPedido")));
                    /*System.out.println("Id pedido: " + rs.getInt("idPedido"));
                    System.out.println("Cédula Cliente: " + rs.getInt("cedulaCliente"));
                    System.out.println("Nombre Cliente: " + rs.getString("nombreCliente"));
                    System.out.println("Apellido Cliente: " + rs.getString("apellidoCliente"));
                    System.out.println("Direccion Cliente: " + rs.getString("direccionCliente"));
                    System.out.println("Id Producto: " +rs.getInt("idProducto"));
                    System.out.println("Cantidad del producto: " + rs.getInt("cantidadProducto"));
                    System.out.println("Fecha Actual: " + rs.getDate("fechaPedido"));
                    System.out.println("SU PEDIDO SERÁ ENTREGADO EN LOS SIGUIENTES TRES DÍAS CALENDARIO");
                    System.out.println("Valor Total Pedido: " + rs.getDouble("valorTotalPedido"));*/


                }

            } catch (SQLException e) {

                System.out.println("No se recuperaron registros ");
                System.out.println(e);
            } finally {
                Conexion.close_connection();
            }


            /*// Agregar contenido al PDF
            document.add(new Paragraph("Pedido ID: " + pedido.getIdPedido()));
            document.add(new Paragraph("Cédula Cliente: " + pedido.getCedulaCliente()));
            document.add(new Paragraph("Nombre Cliente: " + pedido.getNombreCliente()));
            document.add(new Paragraph("Apellido Cliente: " + pedido.getApellidoCliente()));
            document.add(new Paragraph("Dirección Cliente: " + pedido.getDireccionCliente()));
            document.add(new Paragraph("Cantidad del producto: " + pedido.getCantidadProducto()));
            document.add(new Paragraph("Fecha del Pedido: " + pedido.getFechaPedido()));
            document.add(new Paragraph("Valor Total Pedido: " + pedido.getValorTotalPedido()));*/

            document.close();

            System.out.println("PDF generado correctamente en: " + rutaArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Pedido pedido = new Pedido(); // Aquí debes tener tu objeto Pedido con los datos necesarios
        String rutaArchivo = "D:/pedido.pdf"; // Ruta donde se guardará el archivo PDF
        generarPdf(pedido, rutaArchivo);
    }
}

