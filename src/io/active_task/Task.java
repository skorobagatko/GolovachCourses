package io.active_task;

public interface Task {
    public Task next();
    public long sleepTime();
}
