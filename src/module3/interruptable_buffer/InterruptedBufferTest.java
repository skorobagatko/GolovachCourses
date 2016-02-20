package module3.interruptable_buffer;

public class InterruptedBufferTest {
    public static void main(String[] args) {
        InterruptBuffer buffer = new InterruptBuffer();
        Thread[] producers = {
                new Thread(new InterruptProducer(1, buffer)),
                new Thread(new InterruptProducer(2000, buffer)),
                new Thread(new InterruptProducer(40000, buffer))
        };
        Thread[] consumers = {
                new Thread(new InterruptConsumer(buffer)),
                new Thread(new InterruptConsumer(buffer)),
        };

        for (Thread t : producers) { t.start(); }
        for (Thread t : consumers) { t.start(); }
    }
}
