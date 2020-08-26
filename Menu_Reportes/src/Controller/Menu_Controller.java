package Controller;

import Model.Generar_Reporte;
import View.Menu_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Menu_Controller implements ActionListener  {
    
    private Menu_View menuvista;

    public Menu_Controller(Menu_View menuvista) {
        this.menuvista = menuvista;
        this.menuvista.setVisible(true);
        this.menuvista.getBtn_reporte().addActionListener(this);
        this.menuvista.getBtn_reportes_parametros().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==this.menuvista.getBtn_reporte()){
            Generar_Reporte vr = new Generar_Reporte();
            vr.cargar();
        }
        if(e.getSource()==this.menuvista.getBtn_reportes_parametros()){
           
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(menuvista, ex);
        }
        }
    
    
    
}
