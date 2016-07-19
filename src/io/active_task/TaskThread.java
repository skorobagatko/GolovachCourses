package io.active_task;

/**
 * Поток который "оживляет" Task
 */
public class TaskThread extends Thread {

    private Task task;
    private volatile boolean pause;

    public TaskThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        while (task != null) {
            task.next();

        }
    }
}
