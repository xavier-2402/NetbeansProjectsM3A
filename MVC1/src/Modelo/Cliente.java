package Modelo;

import Vista.VentanaCrearReservas;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente {

    private String cedula;
    private String nombre;
    private String apellido;
    private static ArrayList<Cliente>listaclientes = new ArrayList();


    public Cliente(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
      
    }

    public Cliente() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Cliente> getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList<Cliente> listaclientes) {
        this.listaclientes = listaclientes;
    }

 

    public String toString() {
        return cedula + nombre + apellido ;
    }

    public void CargarDatosLista(Cliente cliente,VentanaCrearReservas crearreservas){
        cliente.setCedula(crearreservas.getTxt_cedula().getText());
        cliente.setNombre(crearreservas.getTxt_nombre().getText());
        cliente.setApellido(crearreservas.getTxt_apellido().getText());
        listaclientes.add(cliente);
        JOptionPane.showMessageDialog(null, "DATOS GUARDADOS EXITOSAMENTE");
           
    }
   
     public void Crear_archivos_csv_clientes() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        String direccion="C:\\Users\\usuario\\Documents\\Datos/";
        String nombre="clientes.csv";
        try {
            fichero = new FileWriter(direccion+nombre);
            pw = new PrintWriter(fichero);
            pw.print("Cedula" + "," + "Nombre" + "," + "Apellido" + "\n");
            for (int i = 0; i < listaclientes.size(); i++) {
                pw.print(listaclientes.get(i).getCedula() + "," + listaclientes.get(i).getNombre() + "," + listaclientes.get(i).getApellido() + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(null, e2);
            }

        }  
     }
}
