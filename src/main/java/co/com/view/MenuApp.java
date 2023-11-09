package co.com.view;

import co.com.delichori.service.AdministradorService;

import java.util.Scanner;

public class MenuApp {


    Scanner sc = new Scanner(System.in);

    public void menuApp(){

        System.out.println("Presione 1 para iniciar");
        int opc = sc.nextInt();

        do{
            System.out.println("Bienvenido. Digite 1 si es un administrador, de lo contrario digite 2");
            opc = sc.nextInt();

            if(opc == 1){
                System.out.println("Inicie sesión");
                AdministradorService.iniciarSesion();
            }else{
                MenuCliente.menuCliente();
            }
        }while(opc == 1);


    }
}
