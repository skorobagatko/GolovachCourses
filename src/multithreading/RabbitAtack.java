package multithreading;

public class RabbitAtack {
    public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();
    }
}
