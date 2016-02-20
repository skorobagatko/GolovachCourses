package module3;

public class SingleElementBuffer {
    private Integer elem;

    public synchronized void put(Integer i) throws InterruptedException {
        while (elem != null) {
            this.wait();
        }
        elem = i;
        this.notifyAll();
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) { this.wait(); }
        int result = elem;
        elem = null;
        this.notifyAll();
        return result;
    }
}
