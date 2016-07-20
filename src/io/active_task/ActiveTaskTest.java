package io.active_task;

import java.io.*;

/**
 *
 */
public class ActiveTaskTest {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        ActiveTask activeTask = new ActiveTask(new HelloTask("Hello", 20, 100));
        Thread.sleep(1000);
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buff);
        out.writeObject(activeTask);
        out.flush();
        out.close();
        System.out.println(buff.toByteArray().length);
        ByteArrayInputStream arr = new ByteArrayInputStream(buff.toByteArray());
        ObjectInputStream in = new ObjectInputStream(arr);
        ActiveTask newTask = (ActiveTask) in.readObject();
    }
}
