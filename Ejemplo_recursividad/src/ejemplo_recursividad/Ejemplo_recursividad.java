package ejemplo_recursividad;

public class Ejemplo_recursividad {

    public static void main(String[] args) {
      Ejemplo_recursividad e = new Ejemplo_recursividad();
        System.out.println(e.potencia(5));
        System.out.println(e.suma(9,8));
    }
    
    public double potencia(int n){
        if(n==0)
            return 1;
        else
            return 2*potencia(n-1);
        
    }
    
    public int suma(int a,int b){
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }else{
            return suma(a,(b-1))+1;
        }
    }
    
}
