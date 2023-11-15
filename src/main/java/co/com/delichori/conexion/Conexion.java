package co.com.delichori.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private static Connection connect;

    public Conexion(){

        try  {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/delichori", "root","");
            if(connect != null){
                System.out.println("--------");
            }

        }catch (SQLException e){
            System.out.println(e);
        }

    }

    public static Connection get_connetion(){
        System.out.println();

        if (connect == null){
            new Conexion();
        }
        return  connect;

    }

    public static void close_connection(){

        try {
            System.out.println();
            if(connect != null) {
                connect.close();
                connect = null;
            }
        } catch (Exception e) {
            System.out.println(e);;
        }
        System.out.println();

    }
}

