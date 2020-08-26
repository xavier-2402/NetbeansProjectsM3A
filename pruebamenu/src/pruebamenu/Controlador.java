
package pruebamenu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import org.edisoncor.gui.util.Avatar;

public final class Controlador implements KeyListener {
    Menu menu;

    public Controlador(Menu menu) {
        this.menu = menu;
        menu.setVisible(true);
        menu.getMenu().addKeyListener(this);
        llenarMenu();
    }
    
    public void llenarMenu(){
        List<Avatar> avatars=new ArrayList<Avatar>();
        avatars.add(new Avatar("Animales",loadImage("/imagenes/animales.png")));
        avatars.add(new Avatar("Letras",loadImage("/imagenes/letras.png")));
        avatars.add(new Avatar("Dias de la semana",loadImage("/imagenes/dias de la semana.png")));
        avatars.add(new Avatar("Colores",loadImage("/imagenes/colores.png")));
        avatars.add(new Avatar("Figuras",loadImage("/imagenes/figuras.png")));
        this.menu.getMenu().setAvatars(avatars);
    }
      public static Image loadImage(String filName){
        try {
            return ImageIO.read(Menu.class.getResource(filName));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode()==KeyEvent.VK_ENTER) {
            System.out.println("enter");
            metodos();
        }if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("ju");
            
        } else {
                Toolkit.getDefaultToolkit().beep();
            }
          }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void metodos(){
        if(this.menu.getMenu().getSelectedtitulo().equals("Animales")){
            JOptionPane.showMessageDialog(menu, "fghjkgf");
            
        }
    }
}
