package io.active_task;

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
}
