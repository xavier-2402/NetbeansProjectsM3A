package Controlador;

import Modelo.Cliente;
import Modelo.Libro;
import Modelo.Reserva;
import Vista.VentanaCrearReservas;
import Vista.VentanaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CrearReservasController implements ActionListener {

    private VentanaCrearReservas ventanacrearreservas;
    private Libro libro;

    public CrearReservasController(VentanaCrearReservas ventanacrearreservas) {
        try {
            this.ventanacrearreservas = ventanacrearreservas;
            this.ventanacrearreservas.setVisible(true);
            this.ventanacrearreservas.setResizable(true);
            this.ventanacrearreservas.setLocationRelativeTo(null);
            this.ventanacrearreservas.getBtn_guardar().setEnabled(false);
            this.ventanacrearreservas.getBtnmenu().addActionListener(this);
            this.ventanacrearreservas.getBtn_guardar().addActionListener(this);
            for (String libro : libro.libros) {
                this.ventanacrearreservas.getCb_libros().addItem(libro);
            }
            this.ventanacrearreservas.getBtn_add().addActionListener(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == this.ventanacrearreservas.getBtnmenu()) {
                VentanaMenu ventanamenu = new VentanaMenu();
                MenuController controladormennu = new MenuController(ventanamenu);
                this.ventanacrearreservas.dispose();
            }
            if (e.getSource() == this.ventanacrearreservas.getBtn_guardar()) {
                Cliente cliente = new Cliente();
                Reserva reserva = new Reserva();
                cliente.CargarDatosLista(cliente, ventanacrearreservas);
                reserva.CargarDatoslista(reserva, ventanacrearreservas);
                this.ventanacrearreservas.getTxt_cedula().setText("");
                this.ventanacrearreservas.getTxt_nombre().setText("");
                this.ventanacrearreservas.getTxt_apellido().setText("");
                this.ventanacrearreservas.getBtn_add().setEnabled(true);
                cliente.Crear_archivos_csv_clientes();
                reserva.Crear_archivos_csv_reserva();
            }
            if (e.getSource() == this.ventanacrearreservas.getBtn_add()) {
                Libro libro = new Libro();           
                libro.CargarDatosLista(libro, ventanacrearreservas);
                this.ventanacrearreservas.getBtn_guardar().setEnabled(true);
               
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
