package co.com.view;

import co.com.delichori.service.AdministradorService;
import co.com.delichori.service.PedidoService;
import co.com.delichori.service.ProductoService;

import java.util.Scanner;

public class MenuAdinistrador {

    static Scanner sc = new Scanner(System.in);

    public static void menuAdmin(){

        System.out.println("Presione 1 para ver el menu: ");
        int init = sc.nextInt();

        while (init != 0 ){
            System.out.println("Menú de Administrador :" +
                    "\n1. Registrar Administrador " +
                    "\n2. Eliminar Administrador " +
                    "\n3. Crear Producto " +
                    "\n4. Ver Producto " +
                    "\n5. Actualizar Producto " +
                    "\n6. Eliminar Producto " +
                    "\n7. Ver Ganancia de Producto " +
                    "\n8. Ver Pedido " +
                    "\n9. Actualizar Pedido " +
                    "\n10. Cancelar Pedido " +
                    "\n11. Cerrar sesion \n");

            int opc = sc.nextInt();

            switch (opc) {

                case 1:
                    System.out.println("Registre un administrador");
                    AdministradorService.registrarAdministrador();
                    break;
                case 2:
                    System.out.println("Elimine un administrador");
                    AdministradorService.eliminarAministrador();
                    break;
                case 3:
                    System.out.println("Cree un producto");
                    ProductoService.crearProducto();
                    break;
                case 4:
                    System.out.println("Ver productos");
                    ProductoService.verProducto();
                    break;
                case 5:
                    System.out.println("Actualice el producto");
                    ProductoService.actualizarProducto();
                    break;
                case 6:
                    System.out.println("Elimine un producto");
                    ProductoService.eliminarProducto();
                    break;
                case 7:
                    System.out.println("Vea la ganancia de producto");
                    ProductoService.verGananciaProducto();
                    break;
                case 8:
                    System.out.println("Vea un pedido");
                    PedidoService.verPedido();
                    break;
                case 9:
                    System.out.println("Actualice un pedido");
                    PedidoService.actualizarPedido();
                    break;
                case 10:
                    System.out.println("Cancele un pedido");
                    PedidoService.cancelarPedido();
                    break;
                case 11:
                    System.out.println("Cerrar sesion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor seleccione una opción válida.");
                    break;
            }
        }
    }

}
