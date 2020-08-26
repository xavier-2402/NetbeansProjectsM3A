package codigo;

public class Cliente {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String fecha;
    private String ciudad;
    private int[] carroCompra;

    public Cliente(String cedula, String nombre, String apellido, String correo, String fecha, String ciudad,int[] carroCompra) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha = fecha;
        this.ciudad = ciudad;
         this.carroCompra = carroCompra;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int[] getCarroCompra() {
        return carroCompra;
    }

    public void setCarroCompra(int[] carroCompra) {
        this.carroCompra = carroCompra;
    }
    
    public String toString(){
        return cedula+"  "+nombre+"  "+apellido+" "+correo+" "+fecha+"  "+ciudad;
    }
}
