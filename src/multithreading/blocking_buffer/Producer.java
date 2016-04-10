package multithreading.blocking_buffer;

import java.util.concurrent.TimeoutException;

public class Producer implements Runnable {
    private int startValue;
    private int sleepTime;
    private SingleElementBuffer buffer;

    public Producer(int startValue, int sleepTime, SingleElementBuffer buffer) {
        this.startValue = startValue;
        this.sleepTime = sleepTime;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Produced " + startValue);
            try {
                buffer.put(startValue++, 100L);
                Thread.sleep(sleepTime); // Метод sleep эмулирует работу, просто занимает время
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Time is out");
            }
        }
    }
}
