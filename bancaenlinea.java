//Alex Guizado 8-989-1571| Jackeline McClean 3-751-1480| Jose Moreno  8-971-845| Jean Eleta 8-980-472
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;

public class bancaenlinea {
    public static void main(String[] args) throws IOException{
        BufferedReader objread = new BufferedReader(new InputStreamReader(System.in));
        //declaracion de variable 
        BancaSoporte objext = new BancaSoporte();//llamar a la funcion
        int opcion;
        int nc=0;
        String msgfinal;
        String nombre="";
        boolean salir=false;//esto hara que hasta que el usuario no coloque salir no pare el programa
        boolean cond = true;//esto hara que entre en un ciclo


        while(cond){
            try{
                System.out.println("-----BIENVENIDO A SU BANCA EN LINEA-----");
                System.out.println("\nIngrese su nombre por favor:");
                nombre = objread.readLine();
                System.out.println("Ingrese su numero de cuenta:");
                nc = Integer.parseInt(objread.readLine());
                break;
            }catch(Exception e)//por si al usuario pone los valores incorrecto en nombre y numero de cuenta el programa va a tirar error 
            {
                System.out.println("Los datos ingresado no son correcto");
                continue;//para que el programa continue desde 0 por si se ha ingresado el valor incorrecto 
            }
        }  
            do{//hasta poner salir, el programa sigue 
                try{
                    
                    System.out.println("\n-----MENU DE LA BANCA EN LINEA-----");
                    System.out.println("\n1. Deposito");
                    System.out.println("\n2. Retiro");
                    System.out.println("\n3. Salir");

                    System.out.println("Elija la opcion que desea por favor:");
                    opcion = Integer.parseInt(objread.readLine());

                    switch(opcion){
                        case 1:
                            objext.Deposito(nombre,nc);//lo que se puso en su public void del archivo externo se va a imprimir en el menu principal 
                                break;
                        case 2:
                            objext.Retiro(nombre, nc);
                                break;
                        case 3:
                            System.out.println("-----SALIDA DE LA BANCA EN LINEA-----");
                            System.out.println(" "+nombre);
                            msgfinal = objext.Salida();//llama a la funcion string salida
                            System.out.print(msgfinal);//envia el mensaje desde el archivo externo al archivo principal 
                            System.out.println("\n*****QUE TENGA UN BUEN DIA.*****");
                            System.out.println("*****GRACIAS POR SU VISITA.*****");
                            System.exit(0);//hace que el programa cierre y no entre a un ciclo repetitivo del cual no se saldra a pesar de pone salir el programa volvera al inicio
                        default:
                            System.out.println("El numero que coloco no esta dentro de las opciones.");
                            break;
                    }//fin switch
                }catch(Exception b)
                {
                    System.out.println("ERROR. DEBES COLOCAR UN NUMERO.");
                    objread.readLine();
                }
            }while(!salir);//fin while
    }//fin main 
}//fin class