package io.active_task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ActiveTask implements Serializable {
    private transient TaskThread thread;

    public ActiveTask(Task task) {
        this.thread = new TaskThread(task);
        this.thread.start();
    }

    public void pauseStart() {
        thread.pauseStart();
    }

    public void pauseStop() {
        thread.pauseStop();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        thread.pauseStart();
        Task task = thread.getTask();
        if (task instanceof HelloTask) {
            HelloTask helloTask = (HelloTask) task;
            out.writeBoolean(true);
            out.writeUTF(helloTask.getMsg());
            out.writeInt(helloTask.getCounter());
            out.writeLong(helloTask.sleepTime());
        } else {
            out.writeBoolean(false);
            out.writeObject(task);
        }
        thread.pauseStop();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        boolean isHelloTask = in.readBoolean();
        if (isHelloTask) {
            String msg = in.readUTF();
            int counter = in.readInt();
            long sleepTime = in.readLong();
            this.thread = new TaskThread(new HelloTask(msg, counter, sleepTime));
        } else {
            this.thread = new TaskThread((Task) in.readObject());
        }
        this.thread.start();
    }
}
