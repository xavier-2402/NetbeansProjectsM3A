package prueba_hilos;

public class Cajera extends Thread {

    private String nombre;
    private Cliente cliente;
    private long tiempoinicial;

    public Cajera(String nombre, Cliente cliente, long tiempoinicial) {
        super();
        this.nombre = nombre;
        this.cliente = cliente;
        this.tiempoinicial = tiempoinicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getTiempoinicial() {
        return tiempoinicial;
    }

    public void setTiempoinicial(long tiempoinicial) {
        this.tiempoinicial = tiempoinicial;
    }

    public void run() {
        System.out.println("la cajera " + this.nombre + " comienza a procesar la compra del cliente "
                + this.cliente.getNombre() + " en el tiempo:"
                + (System.currentTimeMillis() - this.tiempoinicial) / 1000 + " seg");

        for (int i = 0; i < this.cliente.getCarrocompra().length; i++) {
            this.esperarxsegundos(cliente.getCarrocompra()[i]);
            System.out.println("Procesando el producto " + (i + 1) + " del cliente " + this.cliente.getNombre() + " tiempo "
                    + (System.currentTimeMillis() - this.tiempoinicial) / 1000 + " seg");
            

        }
        System.out.println("La cajera "+this.getNombre()+" ha terminado de procesar"
        +this.cliente.getNombre()+ " en el tiempo "+(System.currentTimeMillis() - this.tiempoinicial) / 1000 + " seg" );
    }

    private void esperarxsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

}
