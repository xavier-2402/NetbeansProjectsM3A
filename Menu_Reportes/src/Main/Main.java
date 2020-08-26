package Main;

import Controller.Menu_Controller;
import View.Menu_View;

public class Main {
    
    public static void main(String[]args){
        Menu_View mvista = new Menu_View();
        Menu_Controller controlador = new Menu_Controller(mvista);
        
    }
    
}
