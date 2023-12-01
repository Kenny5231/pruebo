/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nodo;

/**
 *
 * @author Kenny
 */
public class Nodo {
    public int codigo;
    public String nombre;
    public Nodo siguiente;
    
    public Nodo(int code,String name){
    codigo=code;
    nombre=name;
    siguiente=null;
    }
    public String toString(){
    return"Nodo { Codigo: "+codigo+" ,Nombre: "+nombre+" }";
    }
    
    
    
    
}
