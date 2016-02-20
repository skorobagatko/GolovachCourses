package module5_collections;

import java.util.Iterator;

public class SquaresIterator implements Iterator<Integer> {
    private final int max;
    private int current;

    public SquaresIterator(int left, int right) {
        this.current = left;
        this.max = right;
    }

    @Override
    public boolean hasNext() {
        while (!((Math.sqrt(current) % 1) == 0)) { current++; }
        return current < max;
    }

    @Override
    public Integer next() {
        return current++;
    }
}
