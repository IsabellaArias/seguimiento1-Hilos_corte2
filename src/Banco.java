
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Banco {
    public BlockingQueue<String> filaNormal = new LinkedBlockingQueue<>();
    public BlockingQueue<String> filaPreferencial = new LinkedBlockingQueue<>();

    public void agregarClienteNormal(String cliente){filaNormal.add(cliente);}

    public void agregarClientePreferencial(String cliente){filaPreferencial.add(cliente);}

   public BlockingQueue<String> getFilaPreferencial(){
        return filaPreferencial;
   }
}
