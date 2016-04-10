package multithreading.blocking_buffer;

import java.util.concurrent.TimeoutException;

public class SingleElementBuffer {
    private Integer elem;

    public synchronized void put(Integer newElem, long timeout) throws InterruptedException, TimeoutException {
        // На мой взгляд:
        // Такая реализация не корректна, если в метод передать timeout=0
        // В этом случае мы даже не выполним проверку на наличие в буфере эелемента
        // В итоге, новый элемент перезатрет тот, который был в очереди - т.е. мы теряем данные
        long waitTime = timeout;
        while (elem != null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0 && elem != null) throw new TimeoutException();
        elem = newElem;
        this.notifyAll();
    }

    public synchronized Integer get(long timeout) throws InterruptedException, TimeoutException {
        long waitTime = timeout;
        while (elem != null && waitTime > 0) {
            long t0 = System.currentTimeMillis();
            this.wait(waitTime);
            long t1 = System.currentTimeMillis();
            long elapsedTime = t1 - t0;
            waitTime -= elapsedTime;
        }
        if (waitTime <= 0 && elem == null) throw new TimeoutException();
        int result = elem;
        elem = null;
        this.notifyAll();
        return result;
    }
}
