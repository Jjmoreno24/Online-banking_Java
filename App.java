//Alex Guizado 8-989-1571| Jackeline McClean 3-751-1480| Jose Moreno  8-971-845| Jean Eleta 8-980-472
import java.io.*;
public class App {
    public static void main(String[] args) throws Exception {
        //declaracion de variables y clases
        BufferedReader objread = new BufferedReader(new InputStreamReader(System.in));
        AdminUsuario user=new AdminUsuario();
        int x;
        boolean control=true;
        //impresion del menu
        while(control){
            try {
                System.out.println("----------sistema de notas----------\nSeleccione el numero de la accion que desea ejecutar\n1.Agregar nuevo usuario\n2.Actualizar Contraseña\n3.Ver notas y Promedio Final\n4.Ver todos los usuarios\n5.salir");
                x=Integer.parseInt(objread.readLine()); 
                //switch case para cada valor introducido
                switch(x){
                    case 1:
                    //llamada a la funcion encargada de crear un nuevo usuario
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        user.newUser();
                        System.out.println("Presione enter para continuar......");
                        objread.readLine();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        break;
                    case 2:
                    //llamada a la funcion para actualizar una contraseña
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        user.accPass();
                        System.out.println("Presione enter para continuar......");
                        objread.readLine();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        break;
                    case 3:
                    //llamada a la funcion para ver la notas de un alumno
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla  
                        user.notes();
                        System.out.println("Presione enter para continuar......");
                        objread.readLine();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        break;
                    case 4:
                    //llamada a la funcion para ver todos los usuarios 
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        user.verUsario();
                        System.out.println("Presione enter para continuar......");
                        objread.readLine();
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        break;
                    case 5:
                    //cambio de la variable de control para finalizar el ciclo
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        control=false;
                        break;
                    default:
                    //defalult controla en caso de que el valor se mayor que 5 o menor que 0
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();//limpia pantalla
                        System.out.println("Esta opcion no existe, vuelva a introducirla");
                        break;
                }//fin switch case
            } catch (Exception e) {
                //excepcion en caso de una entrada invalida
                    System.out.println("**********Error del Sistema Volviendo al menu principal*************");
            }//fin try catch
        }//fin while
    }//finn main
}//fin class
