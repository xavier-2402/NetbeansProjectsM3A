package Cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Cliente {
    
    public static void main(String[]args){
        final String host = "localhost";
        final int puerto = 5050;
        
        try {
            Socket cliente = new Socket(host,puerto);
           ObjectOutputStream mensaje  = new ObjectOutputStream(cliente.getOutputStream());
           mensaje.writeObject(" HOLA ");
            System.out.println("Se envió un mensaje");
           ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
           String mensaje2 =(String)entrada.readObject();
            System.out.println("Servidor esta escribiendo un mensaje");
            System.out.println("Servidor:"+mensaje2);
           cliente.close();
           JOptionPane.showMessageDialog(null, " Conexion cerrada");
           
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
    }
    
}
