package io.active_task;

import java.io.Serializable;

public class ActiveTask implements Serializable {
    private transient TaskThread thread;

    public ActiveTask(Task task) {
        this.thread = new TaskThread(task);
        this.thread.start();
    }

    public void pauseStart() {

    }

    public void pauseStop() {

    }
}
