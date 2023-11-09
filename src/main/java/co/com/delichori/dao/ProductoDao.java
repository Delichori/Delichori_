package co.com.delichori.dao;

import co.com.delichori.conexion.Conexion;
import co.com.delichori.model.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {


    public  static void crearProductoDB(Producto registro ){

        try(Connection conexion = Conexion.get_connetion()){

            PreparedStatement ps =null;

            try {

                String query = "INSERT INTO producto(idProducto,nombreProducto,descripcionProducto,precioCosto,precioVenta,existenciaProducto)VALUES(?,?,?,?,?,?)";

                ps = conexion.prepareStatement(query);

                ps.setInt(1,registro.getIdProducto());
                ps.setString(2,registro.getNombreProducto());
                ps.setString(3,registro.getDescripcionProducto());
                ps.setDouble(4,registro.getPrecioVentaProducto());
                ps.setDouble(5,registro.getPrecioCostoProducto());
                ps.setDouble(6, registro.getExistenciaProducto());

                ps.executeUpdate(); // para insert delete update

                System.out.println("Registro de producto exitoso ");

            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){

            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }

    public static void verProductoDB(){
        //manda
        PreparedStatement ps= null;
        //trae el resultado de la consulta
        ResultSet rs =null;

        try(Connection connect = Conexion.get_connetion()){

            String query = "SELECT * FROM producto";

            ps = connect.prepareStatement(query);//manda
            rs = ps.executeQuery();//recibe

            while (rs.next()){

                System.out.println("\n");
                System.out.println("Id producto: "+ rs.getInt("idProducto"));
                System.out.println("Nombre del producto: " + rs.getString("nombreProducto"));
                System.out.println("Descripcion del producto: " + rs.getString("descripcionProducto"));
                System.out.println("Precio venta del producto: " + rs.getDouble("precioVenta"));
            }
        }catch (SQLException e){
            System.out.println("No se recuperaron registros ");
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }

    public  static  void  actualizarProductoDB(Producto update ){
        try(Connection connect = Conexion.get_connetion()){

            PreparedStatement ps = null;

            try { //Try interno donde corre el query

                int opc = update.getOpc();

                System.out.println(opc);

                if (opc == 1) {

                    String query = "UPDATE producto SET nombreProducto=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getNombreProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.execute();

                    System.out.println("Actualización exitosa");

                }else if (opc == 2){

                    String query = "UPDATE producto SET descripcionProducto=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setString(1, update.getDescripcionProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.execute();

                    System.out.println("Actualización exitosa");

                }else if (opc ==3){

                    String query = "UPDATE producto SET precioVenta=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getPrecioVentaProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.execute();

                    System.out.println("Actualización exitosa");

                }else if (opc == 4){

                    String query = "UPDATE producto SET precioCosto=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getPrecioCostoProducto());
                    ps.setInt(2, update.getIdProducto());
                    ps.execute();

                    System.out.println("Actualización exitosa");

                }else if (opc ==5){

                    String query = "UPDATE producto SET existenciaProducto=? WHERE id = ?";

                    ps = connect.prepareStatement(query);
                    ps.setDouble(1, update.getExistenciaProducto());
                    ps.setInt(2, update.getIdProducto());
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
        }finally { //Sin importar si el try falla o no el finally se ejecuta
            Conexion.close_connection();
        }
    }

    public static void eliminarProductoDB(int idProducto){

        try(Connection connect = Conexion.get_connetion()){

            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM producto where producto.idProducto = ?"; //Con el signo de interrogación le indicamos que le pasamos el id por ()
                ps = connect.prepareStatement(query);
                ps.setInt(1, idProducto);
                ps.executeUpdate();
                System.out.println("El registro ha sido eliminado correctamente");
            }catch (SQLException e){
                System.out.println("No se eliminó el registro");
                System.out.println(e);
            }

        }catch (SQLException e){
            System.out.println(e);
        }finally { //Sin importar si el try falla o no el finally se ejecuta
            Conexion.close_connection();
        }
    }

    public static void verGananciaProductoDB(){
        //manda
        PreparedStatement ps= null;
        //trae el resultado de la consulta
        ResultSet rs =null;

        try(Connection connect = Conexion.get_connetion()){

            String query = "SELECT * FROM producto";

            ps = connect.prepareStatement(query);//manda
            rs = ps.executeQuery();//recibe

            while (rs.next()){

                Producto ganancia = new Producto();

                System.out.println("\n");
                System.out.println("Precio venta del producto: " + rs.getDouble("precio"));
                System.out.println("Precio costo del producto: " + rs.getDouble("costo"));

                double gananciaProducto = ganancia.getPrecioVentaProducto() - ganancia.getPrecioCostoProducto();
                ganancia.setGananciaProducto(gananciaProducto);

            }
        }catch (SQLException e){
            System.out.println("No se recuperaron registros ");
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }
    }
}
