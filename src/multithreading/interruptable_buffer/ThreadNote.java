package multithreading.interruptable_buffer;

public class ThreadNote {
    public final Thread thread;
    public final ThreadNote next;

    public ThreadNote(Thread thread, ThreadNote next) {
        this.thread = thread;
        this.next = next;
    }
}
