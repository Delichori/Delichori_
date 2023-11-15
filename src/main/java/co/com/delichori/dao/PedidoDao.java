package co.com.delichori.dao;

import co.com.delichori.conexion.Conexion;
import co.com.delichori.model.Pedido;

import java.sql.*;

public class PedidoDao {


    public static void crearPedidoDB(Pedido registro) {

        try (Connection conexion = Conexion.get_connetion()) {

            PreparedStatement ps = null;

            try {
                String query = "INSERT INTO pedido(cedulaCliente, nombreCliente, apellidoCliente, direccionCliente, idProducto, estadoPedido, cantidadProducto, fechaPedido, valorTotalPedido) VALUES (?,?,?,?,?,?,?,?,?)";

                ps = conexion.prepareStatement(query);

                ps.setInt(1, registro.getCedulaCliente());
                ps.setString(2, registro.getNombreCliente());
                ps.setString(3, registro.getApellidoCliente());
                ps.setString(4, registro.getDireccionCliente());
                ps.setInt(5, registro.getIdProducto());
                ps.setString(6, registro.getEstadoPedido());
                ps.setInt(7,registro.getCantidadProducto());
                ps.setDate(8, Date.valueOf(registro.getFechaPedido()));
                ps.setDouble(9, registro.getValorTotalPedido());

                ps.executeUpdate();

                System.out.println("Registro de pedido exitoso ");

            } catch (SQLException e) {
                System.out.println(e);
            }


        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Conexion.close_connection();
        }

    }

    public static void verPedidoDB(int idPedido) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connect = Conexion.get_connetion()) {
            String query = "SELECT * FROM pedido where pedido.idPedido = idPedido";

            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();


            while (rs.next()) {
                System.out.println("\n");
                System.out.println("Id pedido: " + rs.getInt("idPedido"));

                System.out.println("Cédula Cliente: " + rs.getInt("cedulaCliente"));
                System.out.println("Nombre Cliente: " + rs.getString("nombreCliente"));
                System.out.println("Apellido Cliente: " + rs.getString("apellidoCliente"));
                System.out.println("Direccion Cliente: " + rs.getString("direccionCliente"));
                System.out.println("Id Producto: " +rs.getInt("idProducto"));
                System.out.println("Estado del Pedido: " + rs.getString("estadoPedido"));
                System.out.println("Cantidad del producto: " + rs.getInt("cantidadProducto"));
                System.out.println("Fecha Actual: " + rs.getDate("fechaPedido"));
                System.out.println("Valor Total Pedido: " + rs.getDouble("valorTotalPedido"));


            }

        } catch (SQLException e) {

            System.out.println("No se recuperaron registros ");
            System.out.println(e);
        } finally {
            Conexion.close_connection();
        }

    }


    public static void verPedidoClienteDB(int cedulaCliente) {

        PreparedStatement ps = null;
        ResultSet rs = null;

        try (Connection connect = Conexion.get_connetion()) {
            String query = "SELECT * FROM pedido where pedido.cedulaCliente = ?";

            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();


            while (rs.next()) {
                System.out.println("\n");
                System.out.println("Id pedido: " + rs.getInt("idPedido"));
                System.out.println("Cédula Cliente: " + rs.getInt("cedulaCliente"));
                System.out.println("Nombre Cliente: " + rs.getString("nombreCliente"));
                System.out.println("Apellido Cliente: " + rs.getString("apellidoCliente"));
                System.out.println("Direccion Cliente: " + rs.getString("direccionCliente"));
                System.out.println("Id Producto: " +rs.getInt("idProducto"));
                System.out.println("Cantidad del producto: " + rs.getInt("cantidadProducto"));
                System.out.println("Fecha Actual: " + rs.getDate("fechaPedido"));
                System.out.println("SU PEDIDO SERÁ ENTREGADO EN LOS SIGUIENTES TRES DÍAS CALENDARIO");
                System.out.println("Valor Total Pedido: " + rs.getDouble("valorTotalPedido"));


            }

        } catch (SQLException e) {

            System.out.println("No se recuperaron registros ");
            System.out.println(e);
        } finally {
            Conexion.close_connection();
        }

    }

    public static void actualizarPedidoDB(Pedido update) {
        try(Connection connect = Conexion.get_connetion()){

            PreparedStatement ps = null;

            try {

                int opc = update.getOpc();

                System.out.println(opc);

                if (opc == 1) {

                    String query = "UPDATE pedido SET estadoPedido=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getEstadoPedido());
                    ps.setInt(2, update.getIdPedido());
                    ps.execute();

                    System.out.println("Actualización exitosa");
                }else{

                    System.out.println("La opción no es válida");

                }

            }catch (SQLException e){
                System.out.println("No fue posible actualizar el registro");
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }



    public static void cancelarPedidoDB(int idPedido) {

        try(Connection connect = Conexion.get_connetion()){

            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM pedido where pedido.idPedido = ?";
                ps = connect.prepareStatement(query);
                ps.setInt(1, idPedido);
                ps.executeUpdate();
                System.out.println("El pedido ha sido cancelado exitosamente");
            }catch (SQLException e){
                System.out.println("No se eliminó el registro");
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }

}
