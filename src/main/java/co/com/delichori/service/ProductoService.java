package co.com.delichori.service;

import co.com.delichori.dao.ProductoDao;
import co.com.delichori.model.Producto;

import java.util.Scanner;

public class ProductoService {


    static Scanner sc = new Scanner(System.in);

    public  static void crearProducto(){

        System.out.println("Ingrese Id Producto: ");
        int idProducto = sc.nextInt();
        sc.skip("\n");
        System.out.println("Ingrese el nombre del producto: \n" );
        String nombre = sc.nextLine();
        System.out.println("Ingrese la descripcion del producto: \n");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese el precio venta del producto: \n");
        double precio =sc.nextDouble();
        System.out.print("Ingrese el precio costo del producto: \n");
        double costo =sc.nextDouble();
        System.out.print("Ingrese la cantidad de producto: \n");
        int existenciaProducto =sc.nextInt();


        double ganancia = precio - costo;
        System.out.print("ver ganancia producto: \n" + ganancia);



       /* ProductoDao productoDao = new ProductoDao();
        ProductoDao.verGananciaProductoDB();
        System.out.println(verGananciaProducto());*/




        Producto registro = new Producto();
        registro.setIdProducto(idProducto);
        registro.setNombreProducto(nombre);
        registro.setDescripcionProducto(descripcion);
        registro.setPrecioVentaProducto(precio);
        registro.setPrecioCostoProducto(costo);
        registro.setExistenciaProducto(existenciaProducto);
        registro.setGananciaProducto(ganancia);

        ProductoDao.crearProductoDB(registro);
    }

    public static  void verProducto(){

        ProductoDao.verProductoDB();

    }

    public  static  void actualizarProducto(){

        System.out.println("Indique para modificar: 1.Nombre 2.Descripción 3. Precio venta 4.Precio Costo 5. Existencias");
        int opc = sc.nextInt();
        sc.skip("\n");

        int idProducto;

        Producto update = new Producto(); //Instancia producto

        switch (opc){
            case 1:
                System.out.println("Modificar nombre");
                System.out.println("Ingrese el nuevo valor");
                String nombre = sc.nextLine();
                System.out.println("Indique el id del producto a actualizar: ");
                idProducto = sc.nextInt();
                opc = 1;
                update.setOpc(opc);
                update.setNombreProducto(nombre);
                update.setIdProducto(idProducto);
                ProductoDao.actualizarProductoDB(update);
                break;

            case 2:
                System.out.println("Modificar descripción");
                System.out.println("Ingrese el nuevo valor");
                String descripcion = sc.nextLine();
                System.out.println("Indique el id del producto a actualizar: ");
                idProducto = sc.nextInt();
                opc = 2;
                update.setOpc(opc);
                update.setDescripcionProducto(descripcion);
                update.setIdProducto(idProducto);
                ProductoDao.actualizarProductoDB(update);
                break;

            case 3:
                System.out.println("Modificar el precio de venta");
                System.out.println("Ingrese el nuevo valor");
                double precio = sc.nextDouble();
                System.out.println("Indique el id del producto a actualizar: ");
                idProducto = sc.nextInt();
                opc = 3;
                update.setOpc(opc);
                update.setPrecioVentaProducto(precio);
                update.setIdProducto(idProducto);
                ProductoDao.actualizarProductoDB(update);
                break;

            case 4:
                System.out.println("Modificar el precio del costo");
                System.out.println("Ingrese el nuevo valor");
                double costo = sc.nextDouble();
                System.out.println("Indique el id del producto a actualizar: ");
                idProducto = sc.nextInt();
                opc = 4;
                update.setOpc(opc);
                update.setPrecioCostoProducto(costo);
                update.setIdProducto(idProducto);
                ProductoDao.actualizarProductoDB(update);
                break;

            case 5:
                System.out.println("Modificar existencias");
                System.out.println("Ingrese el nuevo valor");
                int existencia = sc.nextInt();
                System.out.println("Indique el id del producto a actualizar: ");
                idProducto = sc.nextInt();
                opc = 5;
                update.setOpc(opc);
                update.setExistenciaProducto(existencia);
                update.setIdProducto(idProducto);
                ProductoDao.actualizarProductoDB(update);
                break;

            default:
                System.out.println("Seleccione una opción válida");
        }
    }

    public  static  void eliminarProducto(){

        System.out.println("Indique el id del producto a borrar: ");
        int idProducto = sc.nextInt();
        ProductoDao.eliminarProductoDB(idProducto); //Manda a producto dao el id que se recibe aquí

    }

   public static void verGananciaProducto() {

       ProductoDao.verGananciaProductoDB();

       }
}
