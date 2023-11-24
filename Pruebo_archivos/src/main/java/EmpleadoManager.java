/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Kenny
 */
        
public class EmpleadoManager {
    private RandomAccessFile rcods,remps;
    public EmpleadoManager(){
        try{
            File f=new File("Company ");
            f.mkdir();
            // instanciar los Rads dentro del folder company             
            rcods=new RandomAccessFile("Company/codigos.emp","rw");
            remps=new RandomAccessFile("Company/empleados.emp","rw");   
            // Inicializar el archivo de codifos si es nuevo
            initCode();
        }catch (IOException e){
            System.out.println(" No deberia pasar esto    ");
        }   
    }    
    private void initCode()throws IOException {
    if (rcods.length()==0){
        // 0 bytes
        rcods.writeInt(1);
        //             4bytes        
    }
    }
    private int getCode()throws IOException{
        // seek(int)
        // getFilePointer()
        rcods.seek(0);
        int code=rcods.readInt();//1
        rcods.seek(0);
        rcods.writeInt(code+1);
        return code;
    }
    public void addEmployee(String name,double salary)throws IOException{
        /*
        Formato Empleados.emp
        codigo - int 
        nombre - String 
        salario - double 
        fecha Contratacion - Fecha del momento - Long .
        fecha Despido - Fecha del Momento del despido - Long. 
        */
      // Asegurar que el puntero este al final 
      remps.seek(remps.length());
      // codigo 
      int code=getCode();
      remps.writeInt(code);
      // nombre 
      remps.writeUTF(name);
      // salario 
      remps.writeDouble(salary);
      // fecha Contratacion
      remps.writeLong(Calendar.getInstance().getTimeInMillis());
      // fecha Despedir
      remps.writeLong(0);
      //  Asegurar sus Archivos individuales.
      createYearSalesFileFor(code);
      
    }
   private String employeeFolder(int code){
       return "Company/empleado"+code;
   }
   private void createEmployeeFolders(int code)throws IOException{
       // crear Folder
       File femp=new File(employeeFolder(code));
       femp.mkdir();
       // crear los archivos de ventas del empleado
       createYearSalesFileFor(code);
   }
   private RandomAccessFile salesFileFor(int code )throws IOException{
       String dirPadre=employeeFolder(code);
       int yearActual=Calendar.getInstance().get(Calendar.YEAR);
       String path=dirPadre+"/Ventas"+yearActual+".emp";
       // se retorna con new Random Access File ()con dos campos: path y "rw"
       return new RandomAccessFile(path,"rw");
   }
   private void createYearSalesFileFor(int code)throws IOException{
       RandomAccessFile ryear= salesFileFor(code);
     /*
       Formato VentasYear.emp;
       ventas - Double
       estado - Boolean
       */          
     // inicia en 0 bytes
     if (ryear.length()==0){
         for (int mes=0;mes<12;mes++){
             ryear.writeDouble(0);
             ryear.writeBoolean(false);
         }
     }
             
   }
   private void listarUsers() throws IOException {
        remps.seek(0); 
        while (remps.getFilePointer() < remps.length()) {
            //remps
            int code = remps.readInt();
            String nombre = remps.readUTF();
            double salario = remps.readDouble();
            Date fechaContratacion =  new Date(remps.readLong());
            
            if(remps.readLong()==0){
            System.out.println("Codigo: " + code);
            System.out.println("Nombre: " + nombre);
            System.out.println("Salario: " + salario);
            System.out.println("Fecha de contratacion: " + fechaContratacion);
            }
        }
    }
   private void fireEmpleoyee(int code)throws IOException{
   remps.seek(0);
   while(remps.getFilePointer() < remps.length()){
            int codigo = remps.readInt();
            String nombre = remps.readUTF();
            double salario = remps.readDouble();
            Date fechaContratacion =  new Date(remps.readLong());
   if(codigo==code){
            remps.writeLong(Calendar.getInstance().getTimeInMillis());
   }
   }
   
   
   }
    
}

