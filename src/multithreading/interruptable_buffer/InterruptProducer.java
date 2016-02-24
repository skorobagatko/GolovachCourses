package multithreading.interruptable_buffer;

public class InterruptProducer implements Runnable {
    private int startValue;
    private InterruptBuffer buffer;

    public InterruptProducer(int startValue, InterruptBuffer buffer) {
        this.startValue = startValue;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(startValue + " produced");
                buffer.put(startValue++);
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
