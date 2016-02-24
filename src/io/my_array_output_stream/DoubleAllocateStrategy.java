package io.my_array_output_stream;

public class DoubleAllocateStrategy implements AllocateStrategy {

    @Override
    public int nextAfter(int now) {
        return now * 2;
    }
}
