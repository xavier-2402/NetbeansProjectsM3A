package codigo;

public class Ciudades {
    
    
    private String ciudad;

    public Ciudades(String ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudades() {
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public String toString(){
        return ciudad;
    }
    
}
