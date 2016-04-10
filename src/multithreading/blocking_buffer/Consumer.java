package multithreading.blocking_buffer;

import java.util.concurrent.TimeoutException;

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
                value = buffer.get(100L);
                System.out.println("Consumed " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Time is out");
        }
    }
}
