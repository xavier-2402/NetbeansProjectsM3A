package prueba_mov;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Controlador implements MouseMotionListener{
    
    private Ventana ventana;

    public Controlador(Ventana ventana) {
        this.ventana = ventana;
        this.ventana.setVisible(true);
        this.ventana.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        ventana.setLocation(this.ventana.getX()+e.getX(),this.ventana.getY()+e.getY());
         }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
