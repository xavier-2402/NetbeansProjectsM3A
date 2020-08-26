
package leer_archivo_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Leer_archivo_csv {

//   
    public static void main(String[] args) {
      
        String linea = "";
        String valores [];
        String datos=" ";
        File archivo = new File("C:\\Users\\usuario\\Documents\\ejemplos\\ejemplo.csv");
        FileReader  fr;
        
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
             
            while(br.ready()){
              
                if(!(linea=br.readLine()).equals(" ")){
                    System.out.println(linea);
                    valores=linea.split(",");
                    datos=valores[0].toString()+" "+valores[2].toString()+" "+valores[4].toString()+" "+valores[6].toString()+" "+valores[8].toString()+"\n"
                            + ""+valores[1].toString()+" "+valores[3].toString()+" "+valores[5].toString()+" "+valores[7].toString()+" "+valores[9].toString() ;
                    
                }
            }
            System.out.println(datos);
           
        } catch (Exception e) {
        }
        
        
        
    }
    
}
