package Controlador;

import Vista.VentanaCrearReservas;
import Vista.VentanaListarReservas;
import Vista.VentanaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {
    
    private VentanaMenu ventanamenu;

    public MenuController(VentanaMenu ventanamenu) {
        this.ventanamenu = ventanamenu;
        this.ventanamenu.setVisible(true);
        this.ventanamenu.setResizable(true);
        this.ventanamenu.setLocationRelativeTo(null);
        this.ventanamenu.getBtn_crear().addActionListener(this);
        this.ventanamenu.getBtn_ver().addActionListener(this);
    }

    public VentanaMenu getVentanamenu() {
        return ventanamenu;
    }

    public void setVentanamenu(VentanaMenu ventanamenu) {
        this.ventanamenu = ventanamenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventanamenu.getBtn_crear()){
            VentanaCrearReservas ventanacrearreservas = new VentanaCrearReservas();
           CrearReservasController controladorcrearreservas = new CrearReservasController(ventanacrearreservas);
           this.ventanamenu.dispose();
        }
        if(e.getSource()==ventanamenu.getBtn_ver()){
            VentanaListarReservas ventanalistarreservas = new VentanaListarReservas();
            ListarReservasController controladorlistarreservas = new ListarReservasController(ventanalistarreservas);
            this.ventanamenu.dispose();
        }
         }
    
    
}
