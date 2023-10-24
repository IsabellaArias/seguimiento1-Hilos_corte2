public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Thread cajeroThread = new Thread(new Cajero(banco));
        cajeroThread.start();

        // Simulación de clientes llegando al banco
        for (int i = 1; i <= 10; i++) {
            Cliente cliente = new Cliente("Cliente " + i);
            try {
                if (i % 3 == 0) {
                    banco.agregarClientePreferencial(cliente);
                } else {
                    banco.agregarClienteNormal(cliente);
                }
                System.out.println(cliente.getNombre() + " llegó al banco.");
                Thread.sleep(1000); // Simula el tiempo entre llegada de clientes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

