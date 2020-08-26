package Modelo;

import Vista.VentanaCrearReservas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Libro {

    private int codigo;
    private String nombre;
    private String anio;
    private String editorial;
    private String autores;
    public static ArrayList<String> libros;
    private static ArrayList<Libro> listalibros = new ArrayList();

    public Libro(String nombre, String anio, String editorial, String autores, int codigo) {
        this.nombre = nombre;
        this.anio = anio;
        this.editorial = editorial;
        this.autores = autores;
        this.codigo = codigo;

    }

    public Libro() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Libro> getListalibros() {
        return listalibros;
    }

    public void setListalibros(ArrayList<Libro> listalibros) {
        this.listalibros = listalibros;
    }

    public String toString() {
        return "" + codigo + nombre + anio + autores + editorial;
    }

    public void CargarDatosCombo() {

        libros = new ArrayList();
        String linea = "";
        String valores[];
        String datos = " ";
        String direccion = "C:\\Users\\usuario\\Documents\\Datos\\";
        String nombre = "listadolibros.csv";
        File archivo = new File(direccion + nombre);
        FileReader fr;

        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {

                if (!(linea = br.readLine()).equals(" ")) {
                    valores = linea.split(",");

                    this.setNombre(valores[0].toString());

                    libros.add(this.getNombre().toString());
                }
            }
            libros.remove(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void CargarDatosLista(Libro libro, VentanaCrearReservas crearreservas) {
        libro.setCodigo(crearreservas.getCb_libros().getSelectedIndex());
        libro.setNombre(crearreservas.getCb_libros().getSelectedItem().toString());
        listalibros.add(libro);
        DefaultTableModel modelo = new DefaultTableModel();
        String[] cabecera = new String[]{"Codigo", "Nombre"};
        modelo.setColumnIdentifiers(cabecera);
        if (crearreservas.getCb_libros().getSelectedIndex() == libro.getCodigo()) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = libro.getCodigo();
            fila[1] = libro.getNombre();
            modelo.addRow(fila);

        }
        crearreservas.getTabla_libros().setModel(modelo);
        crearreservas.getBtn_add().setEnabled(false);
    }
   

}
