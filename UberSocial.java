/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class UberSocial {
    private static ArrayList<SocialClass> redes = new ArrayList();
    
    public static SocialClass buscar(String username){
        for(SocialClass usuario: redes){
            if(usuario.getUsername().equals(username)){
                return usuario;
            }
        }
        return null;
    }
    
    public static void agregarCuenta(String username, String tipo){
        if(buscar(username)==null){
            if(tipo.equals("Facebook")){
                redes.add(new Facebook(username));
                        JOptionPane.showMessageDialog(null, "Agregado exitosamente");
            } else{
                redes.add(new Twitter(username));
                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
            }
        }else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario no valido.");

        }
    }
    
    public static void agregarPost(String username, String post) {
        SocialClass account = buscar(username);
        
        if (account instanceof Twitter) {
            ((Twitter) account).addPost(post);
        } else if(account instanceof Facebook) {
            ((Facebook) account).addPost(post);
        } else {
        JOptionPane.showMessageDialog(null, "El usuario no existe.");        }
        
    }
    
    public static void agregarComment(String user, int postID, String autor, String comment){
        Comment comentario = new Comment(postID, autor, comment);
        if(buscar(user)!=null){
        if(buscar(user) instanceof Facebook){
            Facebook userface = (Facebook) buscar(user);
            userface.addComment(comentario);
            JOptionPane.showMessageDialog(null, "Agregado exitosamente");
        }   
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe.");
        }
    }
    
    public static void agregarAmigo(String user1, String user2){
        if(buscar(user1)!=null && buscar(user2)!=null){
            for(SocialClass usuario1: redes){
                if(usuario1.getUsername().equals(user1)){
                    for(SocialClass usuario2: redes){
                        if(usuario2.getUsername().equals(user2)){
                            if((usuario1 instanceof Twitter && usuario2 instanceof Twitter) || (usuario1 instanceof Facebook && usuario2 instanceof Facebook)){
                                usuario1.addFriend(user2);
                                usuario2.addFriend(user1);
                                JOptionPane.showMessageDialog(null, "Agregado exitosamente");
                                break;
                            }
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo completar la accion.");
        }
        
    }
    
    public static void profileFrom(String user){
        if(buscar(user)!=null){
            buscar(user).myProfile();
        }
    }
    
}

