package crear_archivos_json;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Crear_archivos_json {

    public static void main(String[] args) throws FileNotFoundException {
       
       archivos_json aj = new archivos_json();

        try {
             JsonParser parser = new JsonParser();
        FileReader fr = new FileReader("datos.json");
        JsonElement datos = parser.parse(fr);
        aj.dumpJSONElement(datos);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
}
