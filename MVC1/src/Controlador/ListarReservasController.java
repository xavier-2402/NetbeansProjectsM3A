package Controlador;

import Modelo.Cliente;
import Modelo.Libro;
import Modelo.Reserva;
import Vista.VentanaListaDevoluciones;
import Vista.VentanaListarReservas;
import Vista.VentanaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ListarReservasController implements ActionListener {

    private VentanaListarReservas ventanalistarreservas;

    public ListarReservasController(VentanaListarReservas ventanalistarreservas) {
        try {
            this.ventanalistarreservas = ventanalistarreservas;
            this.ventanalistarreservas.setVisible(true);
            this.ventanalistarreservas.setResizable(true);
            this.ventanalistarreservas.setLocationRelativeTo(null);
            this.ventanalistarreservas.getBtn_menu().addActionListener(this);
            this.ventanalistarreservas.getBtn_devoluciones().addActionListener(this);
            Reserva reserva = new Reserva();
            Libro libro = new Libro();
            Cliente cliente = new Cliente();
            reserva.listarreservas(reserva, cliente, libro, ventanalistarreservas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.ventanalistarreservas.getBtn_menu()) {
            VentanaMenu ventanamenu = new VentanaMenu();
            MenuController controladormennu = new MenuController(ventanamenu);
            this.ventanalistarreservas.dispose();
        }
        if(e.getSource()==this.ventanalistarreservas.getBtn_devoluciones()){
            VentanaListaDevoluciones listardevoluciones = new VentanaListaDevoluciones();
            ListaDevolucionesController  controladordevoluciones= new ListaDevolucionesController(listardevoluciones);
            this.ventanalistarreservas.dispose();
        }
    }

}
