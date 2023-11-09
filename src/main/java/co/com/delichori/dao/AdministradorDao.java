package co.com.delichori.dao;

import co.com.delichori.conexion.Conexion;
import co.com.delichori.model.Administrador;
import co.com.view.MenuAdinistrador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdministradorDao {



    static Scanner sc = new Scanner(System.in);
    public static void registrarAdministradorDB(Administrador registro){

        try(Connection conexion = Conexion.get_connetion()){//Inicia la conexión

            PreparedStatement ps = null; //Sirve para prepara el sql de la DB, preparar sentencia de SQL

            try {

                String query = "INSERT INTO administrador(cedulaAdministrador, nombreAdministrador, apellidoAdministrador, email, clave)VALUES(?,?,?,?,?)";

                ps = conexion.prepareStatement(query);

                ps.setInt(1, registro.getCedulaAdministrador());
                ps.setString(2, registro.getNombreAdministrador());
                ps.setString(3, registro.getApellidoAdministrador());
                ps.setString(4, registro.getEmail());
                ps.setString(5, registro.getClave());

                ps.executeUpdate();

                System.out.println("Registro de administrador exitoso");

            }catch (SQLException e){
                System.out.println(e);
            }
        }catch (SQLException e){

            System.out.println(e);

        }finally {
            Conexion.close_connection();
        }
    }
    public static void eliminarAdministradorDB(int cedulaAdministrador){

        try(Connection connect = Conexion.get_connetion()){

            PreparedStatement ps = null;

            try {
                String query = "DELETE FROM administrador where administrador.cedulaAdministrador = ?";
                ps = connect.prepareStatement(query);
                ps.setInt(1, cedulaAdministrador);
                ps.executeUpdate();
                System.out.println("El registro ha sido eliminado correctamente");
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

    public static void iniciarSesionDB(){


        Administrador registro = new Administrador();

        System.out.println("Ingrese su email: ");
        String email = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String clave = sc.nextLine();

        if (email.equals(registro.getEmail()) && clave.equals(registro.getClave())) {
            System.out.println("Bienvenido");
            MenuAdinistrador.menuAdmin();
        } else {
            System.out.println("Credenciales no válidas");
        }

    }
}
