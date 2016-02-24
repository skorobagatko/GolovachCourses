package multithreading.interruptable_buffer;

public class InterruptBuffer {
    private ThreadNote producers;
    private ThreadNote consumers;
    private Integer elem;

    public synchronized void put(Integer newElem) {
        while (elem != null) {
            try {
                producers = (new ThreadNote(Thread.currentThread(), producers));
                this.wait();
            } catch (InterruptedException e) {
                // NOP
            }
        }
        elem = newElem;
        if (consumers != null) {
            consumers.thread.interrupt();
            consumers = consumers.next;
        }
    }

    public synchronized int get() {
        while (elem == null) {
            try {
                consumers = new ThreadNote(Thread.currentThread(), consumers);
                this.wait();
            } catch (InterruptedException e) {
                // NOP
            }
        }
        int result = elem;
        elem = null;
        if (producers != null) {
            producers.thread.interrupt();
            producers = producers.next;
        }
        return result;
    }
}
