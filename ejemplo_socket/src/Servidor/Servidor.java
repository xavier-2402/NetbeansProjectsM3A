package Servidor;
import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Servidor {
    
    public static void main(String[]args){
        final int puerto = 5050;
        try {
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Cliente esta escribiendo");
            Socket cliente = servidor.accept();
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            String mensaje =(String)entrada.readObject();
            System.out.println("Cliente: "+mensaje);
            ObjectOutputStream respuesta = new ObjectOutputStream(cliente.getOutputStream());
            respuesta.writeObject(" Hola que tal");
            System.out.println("Enviando mensaje");
            cliente.close();
            servidor.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
