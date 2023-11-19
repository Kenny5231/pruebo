/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Kenny
 */

public class MiFile {
     private File mifile=null;
    
    public void setFile(String direccion){
        mifile= new File(direccion);
    }
    
    public void info(){
        if(mifile.exists()){
            System.out.println("*Datos del folder o RCHIVO**\n");
            System.out.println("Nombre: "+mifile.getName());
            System.out.println("Path: "+mifile.getPath());
            System.out.println("Abdoluta: "+mifile.getAbsolutePath());
            System.out.println("Bytes: "+mifile.length());
            System.out.println("Modificado en: "+new Date(mifile.lastModified()));
            System.out.println("Padre: "+mifile.getAbsoluteFile().getParentFile().getName());
            if(mifile.isFile()){
            System.out.println("Es un archivo");
            }else if(mifile.isDirectory()){
                System.out.println("Es un directorio");
            }
        }else{
            System.out.println("No existe");
        }  
    }
    public boolean Crearfile()throws IOException{
    return mifile.createNewFile();
    }
    
    public boolean Crearfolder(){
    return mifile.mkdirs();
    }
    
    public boolean borrar(){
    return mifile.delete();
    }
    public void dir(){
        
    if (mifile.isDirectory())
      System.out.println("Directorio: "+mifile.getAbsolutePath());
      System.out.println("---------------------");
   int cfiles=0,cdirs=0,tbytes=0;   
    for (File child: mifile.listFiles()){
     // fecha ultima modificacion
     Date ultima = new Date(child.lastModified());
        System.out.println(ultima+"\t");
     // cotejar si es un archivo o un folder
     if (child.isDirectory()){
         cdirs++;
         System.out.println("< DIR > \t\t");
     }else{
         cfiles++;
         tbytes+=child.length();
         System.out.print("     \t"+child.length()+"\t");           
     }
        System.out.println(child.getName());        
    }
        System.out.println(cfiles+" archivos\t"
                +tbytes+"");
        System.out.println(cdirs+"dirs\t");
    }
    
      private void tree (File dir,String tab){
          if(dir.isDirectory() && !dir.isHidden()){
              System.out.println(tab+dir.getName());
              for (File child: dir.listFiles()){
                  tree(child,tab+"--");
              }
          }
      }
      
      public void tree(){
         tree(mifile,""); 
      }
      
      public void writetext(boolean append)throws IOException { 
          try(FileWriter fw=new FileWriter(mifile,append)){
            do{
                String txt=FileTest.lea.nextLine();
                        if(!txt.equals(":P")){
                            fw.write(txt+"\t");
                        }else{
                            break;
                        }
            }while(true);  
          }
      }
     public void readText()throws IOException{
         try (FileReader fr=new FileReader(mifile)){
             char buffer[]=new char[(int)mifile.length()];
             int bytes=fr.read(buffer);
             System.out.println("\n Contenido\n -----------------------");
             System.out.println(buffer);
             System.out.println("Bytes Leidos: "+bytes);
             System.out.println("\nCon Scanner:\n----------------------");
             FileReader fr2=new FileReader(mifile);
             Scanner lector=new Scanner(fr2);
             while (lector.hasNext()){
                 System.out.println(lector.nextLine());
             }
             fr2.close();
             // fr2.flush()
             
         }
     }
     
     public void EscribirTexto(boolean append) throws IOException {
        try (PrintWriter escribir = new PrintWriter(new FileWriter(mifile, append))) {
            Scanner lea = new Scanner(System.in);
            System.out.println("Escribe el texto (Para finalizar escriba: end):");
            do {
                String txt = lea.nextLine();
                String texto= txt.toLowerCase();
                if (!texto.equals("end")) {
                    escribir.println(txt);
                } else {
                    break;
                }
            } while (true);
            System.out.println("Texto escrito en el archivo correctamente.");
        }
    }

    public void LeerTexto() throws IOException {
        try (BufferedReader leo = new BufferedReader(new FileReader(mifile))) {
            System.out.println("\nContenido del archivo:\n-----------------------");
            String linea;
            while ((linea = leo.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
