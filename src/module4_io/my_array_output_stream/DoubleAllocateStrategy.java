package module4_io.my_array_output_stream;

import jdk.nashorn.internal.runtime.AllocationStrategy;

public class DoubleAllocateStrategy implements AllocateStrategy {

    @Override
    public int nextAfter(int now) {
        return now * 2;
    }
}
