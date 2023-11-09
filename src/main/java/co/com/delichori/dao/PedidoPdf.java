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
                    document.add(new Paragraph("Cédula Cliente: " + rs.getInt("cedulaCliente")));
                    document.add(new Paragraph("Nombre Cliente: " + rs.getString("nombreCliente")));
                    document.add(new Paragraph("Apellido Cliente: " + rs.getString("apellidoCliente")));
                    document.add(new Paragraph("Direccion Cliente: " + rs.getString("direccionCliente")));
                    document.add(new Paragraph("Id Producto: " +rs.getInt("idProducto")));
                    document.add(new Paragraph("Cantidad del producto: " + rs.getInt("cantidadProducto")));
                    document.add(new Paragraph("Fecha Actual: " + rs.getDate("fechaPedido")));
                    document.add(new Paragraph("SU PEDIDO SERÁ ENTREGADO EN LOS SIGUIENTES TRES DÍAS CALENDARIO"));
                    document.add(new Paragraph("Valor Total Pedido: " + rs.getDouble("valorTotalPedido")));


                }

            } catch (SQLException e) {

                System.out.println("No se recuperaron registros ");
                System.out.println(e);
            } finally {
                Conexion.close_connection();
            }

            document.close();

            System.out.println("PDF generado correctamente en: " + rutaArchivo);
        } catch (FileNotFoundException e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Pedido pedido = new Pedido();
        String rutaArchivo = "D:/pedido.pdf"; // Ruta donde se guardará el archivo PDF
        generarPdf(pedido, rutaArchivo);
    }
}

