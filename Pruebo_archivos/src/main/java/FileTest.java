
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
public class FileTest {
     static Scanner lea=new Scanner(System.in);    
    public static void main(String[] args) {
      MiFile mf=new MiFile();
    int opcion=0;
    do{
        System.out.println("************* Menu *******************");
        System.out.println("-1 Set Archivo/Folder");
        System.out.println("-2 Ver Informacion");
        System.out.println("-3 Crear Archivo");
        System.out.println("-4 Crear Folder");
        System.out.println("-5 Borrar ");
        System.out.println("-6 DIR");
        System.out.println("-7 Tree");
        System.out.println("-8 Write Text ");
        System.out.println("-9 Read Text");
        System.out.println("-10 Nueva forma de: Write Text ");
        System.out.println("-11 Nueva forma de: Read Text");
        System.out.println("-12 Salir ");
        System.out.println("Elija una opcion (1-10): ");
        try{
        opcion=lea.nextInt();
        lea.nextLine();
        switch (opcion){
            case 1: 
                System.out.println("Direccion");
                mf.setFile(lea.next());
                break;
            case 2:
                mf.info();
                break;
            case 3: 
                if(mf.Crearfile()){
                    System.out.println("Se Creo");
                }else{
                    System.out.println("No se creo ");
                }                    
               break; 
            case 4:
                if(mf.Crearfolder()){
                    System.out.println("Se Creo Folder");
                }else{
                    System.out.println("No se Creo");
                }
                break;
            case 5: 
                if (mf.borrar())
                    System.out.println("se Borro Existosamente");
                else
                    System.out.println("No se Elimino");
                break;
            case 6:
                 mf.dir();
                 break;
            case 7:
                mf.tree();
                break;
            case 8:
                mf.writetext(true);
                break;
            case 9:
                mf.readText();
                break;
            case 10:
                mf.EscribirTexto(true);
                break;
            case 11:
                mf.LeerTexto();
                break;
            case 12: 
              System.out.println("Cerrando este programa...Gracias por su atencion."); 
                
        }
        }catch(InputMismatchException e){
            System.out.println("Ingrese una Opcion Valida!");
            lea.next();
        }catch(NullPointerException e){
            System.out.println("Por favor , seleccione primero la opcion 1");            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }        
    }while(opcion!=12);
    }
}
