package Modelo;

import Vista.VentanaCrearReservas;
import Vista.VentanaListaDevoluciones;
import Vista.VentanaListarReservas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reserva {

    private String cedula_cliente;
    private String nombre_libro;
    private String fecha_reserva;
    private String estado;
    private String direccion = "C:\\Users\\usuario\\Documents\\Datos";
    private static ArrayList<Reserva> listareservas = new ArrayList();
    private static ArrayList<Reserva> listadevoluciones = new ArrayList();

    public ArrayList<Reserva> getListareservas() {
        return listareservas;
    }

    public void setListareservas(ArrayList<Reserva> listareservas) {
        this.listareservas = listareservas;
    }

    public Reserva() {
    }

    public Reserva(String cedula_cliente, String nombre_libro, String fecha_reserva) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_libro = nombre_libro;
        this.fecha_reserva = fecha_reserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(String cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public static ArrayList<Reserva> getListadevoluciones() {
        return listadevoluciones;
    }

    public static void setListadevoluciones(ArrayList<Reserva> listadevoluciones) {
        Reserva.listadevoluciones = listadevoluciones;
    }

    public String toString() {
        return cedula_cliente + nombre_libro + fecha_reserva;
    }

    public void CargarDatoslista(Reserva reserva, VentanaCrearReservas crearreservas) {

        reserva.setCedula_cliente(crearreservas.getTxt_cedula().getText().toString());
        reserva.setNombre_libro(crearreservas.getCb_libros().getSelectedItem().toString());
        reserva.setFecha_reserva(Fecha(reserva, crearreservas));
        reserva.setEstado("Prestado");
        listareservas.add(reserva);

    }

    public String Fecha(Reserva reserva, VentanaCrearReservas crearreservas) {

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");

        Calendar cal = Calendar.getInstance();
        cal.setTime(crearreservas.getDc_date().getDate());
        Date tempDate = cal.getTime();

        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 2);
        tempDate = cal.getTime();
        String fecha = sdf.format(tempDate);
        return fecha;
    }

    public void listarreservas(Reserva reserva, Cliente cliente, Libro libro, VentanaListarReservas listarreservas) {

        DefaultTableModel modelo = new DefaultTableModel();
        String[] cabecera = new String[]{"Cedula ", "Nombre ", "Apellido ", "Libro", "Fecha_Reserva"};
        modelo.setColumnIdentifiers(cabecera);
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < cliente.getListaclientes().size(); i++) {
            fila[0] = cliente.getListaclientes().get(i).getCedula();
            fila[1] = cliente.getListaclientes().get(i).getNombre();
            fila[2] = cliente.getListaclientes().get(i).getApellido();
            fila[3] = libro.getListalibros().get(i).getNombre();
            fila[4] = reserva.getListareservas().get(i).getFecha_reserva();
            modelo.addRow(fila);
        }
        listarreservas.getTablareservas().setModel(modelo);

    }

    public void Crear_archivos_csv_reserva() {

        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = "/reservas.csv";
        try {
            fichero = new FileWriter(direccion + nombre);
            pw = new PrintWriter(fichero);
            pw.print("Cedula" + "," + "Nombre Libro" + "," + "Fecha" + "\n");
            for (int i = 0; i < listareservas.size(); i++) {
                pw.print(listareservas.get(i).getCedula_cliente() + ","
                        + "" + listareservas.get(i).getNombre_libro() + ","
                        + "" + listareservas.get(i).getFecha_reserva() + "\n");
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
                JOptionPane.showMessageDialog(null, e2);
                e2.printStackTrace();
            }
        }
    }

    public void lectura() {

        String linea = "";
        String valores[];
        String datos = " ";
        String nombre="\\reservas.csv";
        File archivo = new File(direccion+nombre);
        FileReader fr;

        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while (br.ready()) {

                if (!(linea = br.readLine()).equals(" ")) {
                    valores = linea.split(",");
                    for (int i = 0; i < valores.length; i++) {
                        datos = valores[i].toString();
                    }
                    Reserva reserva = new Reserva();

                    reserva.setCedula_cliente(valores[0].toString());
                    reserva.setNombre_libro(valores[1].toString());
                    reserva.setFecha_reserva(valores[2].toString());
                    reserva.setEstado("Devuelto");
                    if (reserva.getFecha_reserva().compareTo(fechaactual()) == 0) {

                        listadevoluciones.add(reserva);
                        JOptionPane.showMessageDialog(null, "Faltan libros \n"
                                + "vea las reservaciones faltantes");
                        System.out.println("coincidencia");
                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "AUN NO EXISTEN RESERVACIONES");
        }

    }

    public String fechaactual() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm");

        Calendar cal = Calendar.getInstance();
        Date tempDate = cal.getTime();
        String fecha = sdf.format(tempDate);
        return fecha;

    }

    public void listardevoluciones(VentanaListaDevoluciones ventanalistadevoluciones) {

        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String[] cabecera = new String[]{"Cedula ", "Nombre Libro ", "Fecha_Reserva", "Estado"};
            modelo.setColumnIdentifiers(cabecera);
            Object[] fila = new Object[modelo.getColumnCount()];
            for (int i = 0; i < listadevoluciones.size(); i++) {
                fila[0] = listadevoluciones.get(i).getCedula_cliente();
                fila[1] = listadevoluciones.get(i).getNombre_libro();
                fila[2] = listadevoluciones.get(i).getFecha_reserva();
                fila[3] = listadevoluciones.get(i).getEstado();

                modelo.addRow(fila);
            }
            ventanalistadevoluciones.getTabla_devoluciones().setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void Crear_archivos_csv_devoluciones() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre="/devoluciones.csv";
        try {
            fichero = new FileWriter(direccion+nombre);
            pw = new PrintWriter(fichero);

            pw.print("Cedula" + "," + "Nombre Libro" + "," + "Fecha" + "," + "Estado" + "\n");
            for (int i = 0; i < listadevoluciones.size(); i++) {
                pw.print(listadevoluciones.get(i).getCedula_cliente()
                        + "," + listadevoluciones.get(i).getNombre_libro()
                        + "," + listadevoluciones.get(i).getFecha_reserva()
                        + listadevoluciones.get(i).getEstado() + "\n");
            }
            JOptionPane.showMessageDialog(null, "Archivo Creado");

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
