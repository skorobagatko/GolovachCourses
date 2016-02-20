package module3;

public class RabbitAtack {
    public static void main(String[] args) {
        new Thread(new RabbitPrinter()).start();
    }
}
