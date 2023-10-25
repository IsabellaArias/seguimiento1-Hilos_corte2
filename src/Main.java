public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Thread priority = new Thread(() -> {
            while (true) {
                String usuario = null;
                try {
                    usuario = banco.getFilaPreferencial().take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Cliente prioritario en proceso: " + usuario);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });
        Thread ordinario = new Thread(() ->{
            while (true){
                if (banco.getFilaPreferencial().isEmpty()){
                    String usuario = null;
                    try {
                        usuario = banco.filaNormal.take();
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                    System.out.println("Cliente normal en proceso:" + usuario);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e){}
                }
            }
        });
        priority.start();
        ordinario.start();
        banco.agregarClienteNormal("Diego");
        banco.agregarClienteNormal("Isabella");
        banco.agregarClientePreferencial("Ana");
        banco.agregarClientePreferencial("Saavedra");
        banco.agregarClientePreferencial("Jeyson");
    }
}






