/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nodo;

/**
 *
 * @author Kenny
 */
public class Lista {
    private Nodo inicio=null;
    private int size=0;
    
    public boolean isEmpty(){
    return inicio==null;
    }
    
    public void addNodo(Nodo object){
    if(object==null){
        return;
    }
    if(isEmpty()){
        inicio=object;
    }else{
        Nodo tmp=inicio;
        while(tmp.siguiente!=null){
        tmp=tmp.siguiente;
        }
        tmp.siguiente=object;
    }
    size++;
    }
    public void print(){
        Nodo tmp=inicio;
        while(tmp!=null){
            System.out.println(tmp.toString());
            tmp= tmp.siguiente;
        }
    }
    
    public Nodo get(int code){
    Nodo tmp= inicio;
    while(tmp!=null){
    if(tmp.codigo==code){
    return tmp;
    }
    tmp=tmp.siguiente;
    }
    return null;
    }
    
    public boolean contains(int code){
    return get(code)!=null;
    }
    
    public boolean remove(int code){
    if(!isEmpty()){
        if(inicio.codigo==code){
            inicio= inicio.siguiente;
            size --;
            return true;
        }else{
        Nodo tmp=inicio;
        while(tmp.siguiente!=null){
            if(tmp.siguiente.codigo==code){
             tmp.siguiente=tmp.siguiente.siguiente;
             return true;
            }
        }  
    }
    }
    return false;
    }
    
    
    
    public boolean remove1(int code){
    if(!isEmpty()){
        Nodo tmp= inicio;
        Nodo nuevo=null;
        while(tmp!=null && siguientetmp(tmp)){
            if(tmp.codigo==code){
            tmp=nuevo;
            return true;
            }else
            tmp= tmp.siguiente;
        }
        
        
    }
    return false;
    }
    public boolean siguientetmp(Nodo tmp){
    tmp=tmp.siguiente;
    if(tmp!=null){
    return true;
    }
    return false;
    }
    
    

}