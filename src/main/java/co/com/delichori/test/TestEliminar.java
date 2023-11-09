package co.com.delichori.test;

import co.com.delichori.service.AdministradorService;
import co.com.delichori.service.ProductoService;

public class TestEliminar {

    public static void main(String[] args) {

        AdministradorService administradorService = new AdministradorService();
        AdministradorService.eliminarAministrador();


        ProductoService productoService = new ProductoService();
        ProductoService.eliminarProducto();




    }


}
