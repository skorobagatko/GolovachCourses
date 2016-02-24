package multithreading;

public class PrintBuilder implements Runnable {
    private String message;
    private int sleepTime;

    public PrintBuilder(String message, int sleepTime) {
        this.message = message;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(message);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
