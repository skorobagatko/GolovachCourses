package module3;

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
            System.out.println("Produce " + startValue);
            try {
                buffer.put(startValue++);
                Thread.sleep(sleepTime); // Метод sleep эмулирует работу, просто занимает время
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
