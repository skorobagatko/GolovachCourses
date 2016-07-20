package io.active_task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HelloTask implements Task, Serializable {

    /**
     * Сообщение
     */
    private String msg;
    /**
     * Кол-во раз, которое нужно вызвать задание
     */
    private int counter;
    /**
     * Сколько спать
     */
    private long sleepTime;

    public HelloTask(String msg, int counter, long sleepTime) {
        this.msg = msg;
        this.counter = counter;
        this.sleepTime = sleepTime;
    }

    @Override
    public Task next() {
        System.out.println(msg + ":" + counter);
        counter--;
        return (counter == 0) ? null : this;
    }

    @Override
    public long sleepTime() {
        return sleepTime;
    }

    public String getMsg() {
        return msg;
    }

    public int getCounter() {
        return counter;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(msg);
        out.writeInt(counter);
        out.writeLong(sleepTime);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.msg = in.readUTF();
        this.counter = in.readInt();
        this.sleepTime = in.readLong();
    }
}
