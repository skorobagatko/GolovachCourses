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
            try {
                Thread.sleep(task.sleepTime());
            } catch (InterruptedException e) {
                if (pause) {
                    while (pause) {
                    }
                } else {
                    return;
                }
            }
            task = task.next();
        }
    }

    public void pauseStart() {
        pause = true;
        this.interrupt();
    }

    public void pauseStop() {
        pause = false;
    }

    public Task getTask() {
        return task;
    }
}
