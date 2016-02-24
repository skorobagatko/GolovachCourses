package multithreading;


public class PlayTheAccordion {
    public static void main(String[] args) throws InterruptedException {
        Thread commanderThread = new CommanderThread();
        Thread commanderThread2 = new CommanderThread();
        commanderThread.start();
        commanderThread2.start();
        commanderThread.join();
        commanderThread2.join();
    }
}
