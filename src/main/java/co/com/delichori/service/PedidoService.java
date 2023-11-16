package co.com.delichori.service;

import co.com.delichori.dao.PedidoDao;
import co.com.delichori.dao.PedidoPdfDao;
import co.com.delichori.dao.ProductoDao;
import co.com.delichori.model.Pedido;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PedidoService {


    //Acá se les da forma a los métodos y después se llaman a los que pertenezcan al admin

    static Scanner sc = new Scanner(System.in);

    public static void realizarPedido() {

        System.out.println("Digitar por favor su número de cédula");
        int cedulaCliente = sc.nextInt();
        sc.skip("\n");

        System.out.println("Por favor digitar su nombre");
        String nombreCliente = sc.nextLine();

        System.out.println("por favor digitar sus apellidos");
        String apellidoCliente = sc.nextLine();

        System.out.println("Por favor ingrese dirección de entrega");
        String direccionCliente = sc.nextLine();

        System.out.println("Usted está viendo los productos ofrecidos por Delichori: ");
        ProductoDao.verProductoDB();
        System.out.println();


        System.out.println("Digíte Id del producto deseas: ");
        int idProducto = sc.nextInt();
        sc.skip("\n");

        System.out.println("Ingrese cantidad producto solicitado: ");
        int cantidad = sc.nextInt();
        sc.skip("\n");

        System.out.println("Fecha del Pedido: \n");
        LocalDateTime fechaActual = LocalDateTime.now();
        System.out.println(fechaActual + "\n");

        System.out.println("\n SU PEDIDO SERÁ ENTREGADO EN LOS SIGUIENTES TRES DÍAS CALENDARIO");
        double precioUnidad = 4000;
        double total = cantidad * precioUnidad;

        System.out.println("El valor Total del Pedido es: \n"+total+ "\n");


        Pedido registro = new Pedido();

        registro.setCedulaCliente(cedulaCliente);
        registro.setNombreCliente(nombreCliente);
        registro.setApellidoCliente(apellidoCliente);
        registro.setDireccionCliente(direccionCliente);
        registro.setIdProducto(idProducto);
        registro.setCantidadProducto(cantidad);
        registro.setFechaPedido(LocalDate.from(fechaActual));
        registro.setValorTotalPedido(total);

        PedidoDao.crearPedidoDB(registro);

    }

    public static void verPedido() {

        System.out.println("Digíte Id Pedido: ");
        int idPedido = sc.nextInt();
        PedidoDao.verPedidoDB(idPedido);
    }

    public static void verPedidoCliente() {

        System.out.println("Digíte su cédula: ");
        int cedulaCliente = sc.nextInt();
        PedidoDao.verPedidoClienteDB(cedulaCliente);
    }

    /*public static void imprimirPedido(){
        System.out.println("Digíte su cédula: ");
        int cedulaCliente = sc.nextInt();
        PedidoPdfDao.generarPdf("Pedido pedido", "String rutaArchivo", "int cedulaCliente");
    }*/



    public static void actualizarPedido() {
        System.out.println("Indique para modificar: 1.Estado Pedido ");
        int opc = sc.nextInt();
        sc.skip("\n");

        int id;

        Pedido update= new Pedido();

        if (opc == 1) {
            System.out.println("Actualizar Estado Pedido");
            System.out.println("Ingrese el nuevo Estado del pedido: 'CONFIRMADO', 'DESPACHADO', 'PAGADO'. ");
            String estado = sc.nextLine();
            System.out.println("Indique el id del pedido a actualizar: ");
            id = sc.nextInt();
            opc = 1;
            update.setOpc(opc);
            update.setEstadoPedido(estado);
            update.setIdPedido(id);
            PedidoDao.actualizarPedidoDB(update);

        }else{
                System.out.println("Seleccione una opción válida");
        }
    }


    public static void cancelarPedido() {

        System.out.println("Indique el id del pedido a cancelar: ");
        int idPedido = sc.nextInt();
        ProductoDao.eliminarProductoDB(idPedido);


    }



}
