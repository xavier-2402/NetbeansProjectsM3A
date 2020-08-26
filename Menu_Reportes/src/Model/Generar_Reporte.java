package Model;

import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Generar_Reporte {
    Connection con;
    Conexion conexion = new Conexion();

    public Generar_Reporte() {
    }

    public void cargar() {
        con=conexion.conexion;
        try {
//            JasperReport reporte = (JasperReport) JRLoader.loadObject("Prueba_reporte.jasper");
//            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte,null,con);
//           JRPdfExporter exporter = new JRPdfExporter();
           
//          
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("Prueba_reportes"));
//            exporter.exportReport();
            
            JasperPrint ventana = JasperFillManager.fillReport("C:\\Users\\usuario\\JaspersoftWorkspace\\MyReports\\Prueba_reporte.jasper",null,con);
            JasperViewer jasperViewer = new JasperViewer(ventana);
            jasperViewer.setVisible(true);
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }

}
