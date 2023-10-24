import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Banco {
    private BlockingQueue<Cliente> filaNormal = new ArrayBlockingQueue<>(50);
    private BlockingQueue<Cliente> filaPreferencial = new ArrayBlockingQueue<>(50);

    public void agregarClienteNormal(Cliente cliente) throws InterruptedException {
        filaNormal.put(cliente);
    }

    public void agregarClientePreferencial(Cliente cliente) throws InterruptedException {
        filaPreferencial.put(cliente);
    }

    public Cliente siguienteCliente() throws InterruptedException {
        Cliente cliente = filaPreferencial.poll();
        if (cliente == null) {
            cliente = filaNormal.poll();
        }
        return cliente;
    }
    public boolean hayClientes() {
        return !filaNormal.isEmpty() || !filaPreferencial.isEmpty();
    }
}
