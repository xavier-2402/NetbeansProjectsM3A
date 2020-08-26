package prueba_hilos;

/**
 *
 * @author Xavier Yanza
 */
public class Prueba_hilos {

    public static void main(String[] args) {
        long tiempoinicial = System.currentTimeMillis();
        Cliente cliente1 = new Cliente("cliente1", new int[]{1, 2, 4, 2, 5, 3, 5, 5, 7, 6, 9, 8, 2});
        Cliente cliente2 = new Cliente("cliente2", new int[]{1, 2, 4});
        Cliente cliente3 = new Cliente("cliente3", new int[]{1, 2, 4, 4, 4, 7, 6, 5, 5, 1, 7, 7});
        Cliente cliente4 = new Cliente("cliente4", new int[]{1, 2, 4, 3, 8, 9, 9, 7, 7});

        Cajera cajera1 = new Cajera("Cajera1", cliente1, tiempoinicial);
        Cajera cajera2 = new Cajera("Cajera2", cliente2, tiempoinicial);
        Cajera cajera3 = new Cajera("Cajera3", cliente3, tiempoinicial);
        Cajera cajera4 = new Cajera("Cajera4", cliente4, tiempoinicial);
        
        cajera1.start();
        cajera2.start();
        cajera3.start();
        cajera4.start();
    }

}
