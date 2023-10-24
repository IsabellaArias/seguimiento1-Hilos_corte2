public class Cajero implements Runnable {
        private Banco banco;

    public Cajero(Banco banco) {
            this.banco = banco;
        }

        @Override
        public void run() {
            while (banco.hayClientes()) {
                try {
                    Cliente cliente = banco.siguienteCliente();
                    if (cliente != null) {
                        System.out.println("Atendiendo a " + cliente.getNombre());
                        Thread.sleep(2000); // Simula el tiempo que toma atender a un cliente
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Todos los clientes han sido atendidos. El cajero se retira.");
        }
}

