package io.active_task;

import java.io.Serializable;

public class HelloTask implements Task, Serializable {


    @Override
    public Task next() {
        return null;
    }

    @Override
    public long sleepTime() {
        return 0;
    }
}
