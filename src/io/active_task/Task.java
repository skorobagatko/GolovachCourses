package io.active_task;

/**
 * sleepTime() - указывает сколько нужно спать
 * Затем вызываем метод next(), который выполняет какую-то работу и
 * переходит к новому заданию
 */
public interface Task {
    public Task next();
    public long sleepTime();
}
