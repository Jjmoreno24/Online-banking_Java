import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class BancaSoporte {
    //Declaracion de variable 
    int saldo=1000;
    float agregar;
    float retirar;

    public void Deposito(String nombre, int nc)throws IOException{
        BufferedReader objread = new BufferedReader(new InputStreamReader(System.in));
        //Declaracion de variable 
        int opc1;

            System.out.println("------DEPOSITO------");
            System.out.println("\nBuen día, Bienvenido");
            System.out.println("\nNombre del usuario:"+nombre);
            System.out.println("Numero de cuenta:"+nc);
            System.out.println("\n1. Depositar");
            System.out.println("\n2. Ver saldo actual");

            System.out.println("\nElija la opcion que desee por favor:");
            opc1 = Integer.parseInt(objread.readLine());

                switch(opc1){
                    case 1:
                        System.out.println("----ESCOGIO DEPOSITAR----");
                        System.out.println("\nCuanto dinero desea ingresar en la cuenta: ");
                        agregar = Float.parseFloat(objread.readLine());
                        while(agregar < 0){//esto no va a permitir que el usuario ingrese numeros menores que 0 
                            System.out.println("\n(No se aceptan numeros negativos). Vuelve a introducir el valor.");
                            agregar = Float.parseFloat(objread.readLine());
                        }
                        saldo += agregar;//para que cada vez que el usuario agregue un monto este se ira acumulando en la variabe saldo 
                        System.out.println("El saldo total es de: $"+saldo);
                        break;
                    case 2:
                        System.out.println("----VER SALDO ACTUAL----");
                        System.out.println("\nSaldo Actual es de: $"+saldo);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("El numero que coloco no esta dentro de las opciones.");
                        break;
                    }//fin switch opc1
    }//fin Deposito 

    public void Retiro(String nombre, int nc)throws IOException{
        BufferedReader objread = new BufferedReader(new InputStreamReader(System.in));
        //Declarar variable 
        int opc2;

            System.out.println("------RETIRO------");
            System.out.println("\nBuen día, Bienvenido");
            System.out.println("\nNombre del usuario:"+nombre);
            System.out.println("Numero de cuenta:"+nc);
            System.out.println("\n1. Retirar");
            System.out.println("\n2. Ver saldo actual");

            System.out.println("\nElija la opcion que desee por favor:");
            opc2 = Integer.parseInt(objread.readLine());

                switch(opc2){
                    case 1:
                        System.out.println("----ESCOGIO RETIRAR----");
                        System.out.println("\nCuano dinero desea retirar:");
                        retirar = Float.parseFloat(objread.readLine());
                        if(retirar < 0){//para que no se agregue numeros menores que 0 
                            System.out.println("\nLa cantidad ingresada no puede ser menor que 0");
                        }
                        else if(retirar > saldo)//esto hara que cuando el usuario ingrese un monto que no contiene saldo el programa de una vez le dira que no se puede.
                        {
                            System.out.println("La cantidad a retirar es mayor al saldo");
                        }//fin if 
                        else
                        {
                            saldo -= retirar;//cada vez que el usuario que retirar una cantidad de saldo este restara del saldo actual que tiene la variable 
                            System.out.println("El saldo disponibles es de: $"+saldo);
                        }//fin else 
                        break;
                    case 2:
                        System.out.println("----VER SALDO ACTUAL----");
                        System.out.println("\nSaldo Actual es de: $"+saldo);
                        break;
                    default:
                    System.out.println("El numero que coloco no esta dentro de las opciones.");
                }//fin switch3.0
    }//fin Retiro 
    
    public String Salida(){
        String respuesta;

        respuesta = "Su saldo es: "+saldo;

        return respuesta;//hace que retorne al archivo principal con su mensaje 

    }//fin Salida
    
}//fin class 