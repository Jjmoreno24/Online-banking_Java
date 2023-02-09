import java.io.*;
public class AdminUsuario {
    //declariacion de variables y metodos globales
    BufferedReader objread = new BufferedReader(new InputStreamReader(System.in));
    static String[] lista = new String[5];
    static String[] pass = new String[5];
    static float[][] notas= new float[5][5];//primer indice numero del usuario, notas 
    static int x=0;

    public void newUser() throws Exception{
        //declaracion de variables para la el metodo de nuevo usuario
        String leer="";
        int i;
        float h;
        boolean control=true;
        if(x<5){
            if(x==0){
                System.out.println("Introduzca el nombre de usuario: ");
                lista[x]=objread.readLine();
                System.out.println("Introduzca la contraseña para el usuario: ");
                pass[x]=objread.readLine();
            }else{
                while(control){
                    System.out.println("Introduzca el nombre de usuario: ");
                    leer=objread.readLine();
                    for(i=0;i<x;i++){
                        if(leer.equals(lista[i])){
                            System.out.println("El Nombre de usuario introducido ya existe ingrese uno nuevo: ");
                            break;
                        }//fin if
                        else if(i==x-1){
                            control=false;
                        }//fin else

                    }//fin for
                }//fin while
                lista[x]=leer;
                System.out.println("Introduzca la contraseña para el usuario: ");
                pass[x]=objread.readLine();
            }//fin else 
            for(i=0;i<5;i++){
                try{
                    System.out.print("Introduzca la nota n"+(i+1)+": ");
                    h=Float.parseFloat(objread.readLine());
                    while(h<0||h>5){
                        System.out.print("Recuerde que el rango de calificacion no puede ser menor que 0, ni mayor a 5\n");
                        System.out.print("Introduzca la nota n"+(i+1)+": ");
                        h=Float.parseFloat(objread.readLine());
                    }//while
                    notas[x][i]=h;
                }catch(Exception e){
                    System.out.println("EL valor introducido es invalido");
                    i=i-1;
                }//fin try catch
            }//fin for
            x+=1;
        }else{
            System.out.println("NUMERO DE USUARIOS LLENO");
        }//fin else
    }//fin metodo new user

    public void accPass() throws Exception{
        //declaracion de variables para la el metodo de actualizar contraseña
        String user="";
        String passt="";
        boolean control=true;
        int i;
        if(x>0){
            System.out.println("Introduzca el nombre de usuario: ");
            user=objread.readLine();
        }//fin if
        else{
            System.out.println("No hay usuario para cambiar contraseña");
        }//fin else
        for(i=0;i<x;i++){
            if(user.equals(lista[i])){
                while(control){
                    System.out.println("Introduzca su contraseña antigua: ");
                    passt=objread.readLine();
                    if(passt.equals(pass[i])){
                        System.out.println("Introduzca la nueva contraseña: ");
                        pass[i]=objread.readLine();
                        control=false;
                    }//fin if
                    else{
                        System.out.println("La contraseña no coincide, introduzcala nuevamente");
                    }//fin else
                }//fin while
                break;
            }//fin if
            else if(i==x-1){
                System.out.println("Este usuario no existe");
            }//fin else if
        }//fin for         
    }//fin metodo acPass 

    public void notes() throws Exception{
        //declaracion de variables para la el metodo de ver notas 
        String usuario="";
        String passt="";
        int i,h;
        float prom=0;
        boolean control=true;
        boolean print=false;
        if(x>0){
            System.out.println("Introduzca el nombre de usuario: ");
            usuario=objread.readLine();
            for(i=0;i<x;i++){
                if(usuario.equals(lista[i])){
                    while(control){
                        System.out.println("Introduzca su contraseña");
                        passt=objread.readLine();
                        if(passt.equals(pass[i])){
                            for(h=0;h<5;h++){
                                System.out.println("Nota n"+(h+1)+": "+notas[i][h]);
                                prom+=notas[i][h];
                                control=false;
                                print=true;
                            }//fin for
                        }//fin if
                        else{
                            System.out.println("La contraseña no coincide, introduzcala nuevamente");
                        }//fin else
                    }//fin while
                    break;
                }//fin if
                else if(i==x-1){
                    System.out.println("Este usuario no existe");
                }//fin else if
            }//fin for
        }//fin if
        else{
            System.out.println("No hay usuario para ver notas");
        }//fin else
        if(print){
            prom=prom/5;
            System.out.println("El promedio de las notas es: "+prom);
        }
    } //fin metodo notas

    public void verUsario() throws Exception{
        //declaracion de variables para la el metodo de ver usuarios 
        if(x>0){
            for(int i=0;i<x;i++){
                System.out.println("Usuario n"+(i+1)+": "+lista[i]);
            }//fin if
        }//fin for
        else{
            System.out.println("No hay usuarios que mostrar");
        }//fin else
    }//fin ver usuario

}//fin class
