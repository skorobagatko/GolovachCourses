package module3;

public class RabbitPrinter implements Runnable {
    @Override
    public void run() {
        System.out.println("New rabbit was born!");
        new Thread(new RabbitPrinter()).start();
        new Thread(new RabbitPrinter()).start();
    }
}
