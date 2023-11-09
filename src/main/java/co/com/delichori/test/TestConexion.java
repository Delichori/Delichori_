package co.com.delichori.test;

import co.com.delichori.conexion.Conexion;

import java.sql.Connection;

public class TestConexion {



    public static void main(String[] args) {


        try(Connection connect = Conexion.get_connetion()) {



        }catch (Exception e){
            System.out.println(e);
        }finally {
            Conexion.close_connection();
        }


    }
}


