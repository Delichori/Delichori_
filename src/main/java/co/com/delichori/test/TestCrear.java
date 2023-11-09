package co.com.delichori.test;

import co.com.delichori.service.AdministradorService;
import co.com.delichori.service.ProductoService;

public class TestCrear {

    public static void main(String[] args) {




        ProductoService productoService= new ProductoService();
        ProductoService.crearProducto();

        AdministradorService administradorService = new AdministradorService();
        AdministradorService.registrarAdministrador();





    }




}
