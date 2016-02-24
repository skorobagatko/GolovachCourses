package multithreading.interruptable_buffer;

public class InterruptConsumer implements Runnable {
    private final InterruptBuffer buffer;

    public InterruptConsumer(InterruptBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            int elem = buffer.get();
            System.out.println(elem + " consumed");
        }
    }
}
