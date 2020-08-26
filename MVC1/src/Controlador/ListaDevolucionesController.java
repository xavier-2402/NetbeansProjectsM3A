package Controlador;

import Modelo.Reserva;
import Vista.VentanaListaDevoluciones;
import Vista.VentanaListarReservas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDevolucionesController  implements ActionListener {
    private VentanaListaDevoluciones listadevoluciones;
    Reserva reserva = new Reserva();

    public ListaDevolucionesController(VentanaListaDevoluciones listadevoluciones) {
        this.listadevoluciones = listadevoluciones;
        this.listadevoluciones.setVisible(true);
        this.listadevoluciones.setResizable(true);
        this.listadevoluciones.setLocationRelativeTo(null);
        this.listadevoluciones.getBtn_atras().addActionListener(this);
        this.listadevoluciones.getBtn_guardar().addActionListener(this);
        this.reserva.listardevoluciones(listadevoluciones);
        
                
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==this.listadevoluciones.getBtn_atras()){
            VentanaListarReservas listarreservas = new VentanaListarReservas();
            ListarReservasController controladorreservas = new ListarReservasController(listarreservas );
            this.listadevoluciones.dispose();
        }
       if(e.getSource()==this.listadevoluciones.getBtn_guardar()){
           reserva.Crear_archivos_csv_devoluciones();
       }
    
    }
}
