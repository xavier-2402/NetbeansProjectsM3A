
package Main;
//Xavier Yanza 

import Controlador.MenuController;
import Modelo.Libro;
import Modelo.Reserva;
import Vista.VentanaMenu;
import java.util.Timer;
import java.util.TimerTask;

public class MVC1 {

    public static void main(String[] args) {
        
        VentanaMenu ventanamenu = new VentanaMenu();
        MenuController menucontroller = new MenuController(ventanamenu);
        Libro libro = new Libro();
        libro.CargarDatosCombo();
        Reserva reserva = new Reserva();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                reserva.lectura();

            }
        };

        timer.scheduleAtFixedRate(task, 5000, 40000);
    }
    
}
