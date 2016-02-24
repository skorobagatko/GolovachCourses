package multithreading;

public class Consumer implements Runnable {
    private int value;
    private SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                value = buffer.get();
                System.out.println("Consumed " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
