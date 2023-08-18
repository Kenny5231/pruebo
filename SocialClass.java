/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab;

/**
 *
 * @author dell
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class SocialClass {
    
    protected ArrayList<String> friends;
    protected ArrayList<String> posts;
    protected String username;
    
    public SocialClass(String username){
        friends = new ArrayList();
        posts = new ArrayList();
        this.username = username;
    }
    
    public boolean addFriend(String user){
        boolean repetido=false;
        for(String usuario: friends){
            if(usuario.equals(user)){
                repetido=true;
            }
        }
        if(repetido==false){
            friends.add(user);
        JOptionPane.showMessageDialog(null, "Amigo agregado exitosamente.");
            return true;
        }
         JOptionPane.showMessageDialog(null, "No se pudo completar la accion.");

        return false;
    }
    
    public void addPost(String msg){
        posts.add(msg);
        JOptionPane.showMessageDialog(null, "Post agregado exitosamente");
    }
    
    abstract void timeLine();
    
    public void myProfile(){
        System.out.println("Usuario: "+username);
        timeLine();
        int contador=0;
        for(String usuario: friends){
            System.out.println(usuario);
            contador+=1;
            if(contador==10){
                System.out.println("\n");
                contador=0;
            }
        }
    }
    
    public String getUsername() {
        return username;
    }
    
    public int getPost() {
        return posts.size();
    }
    
}
