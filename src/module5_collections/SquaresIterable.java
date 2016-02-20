package module5_collections;

import java.util.Iterator;

public class SquaresIterable implements Iterable<Integer> {
    private final int left;
    private final int right;

    public SquaresIterable(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SquaresIterator(left, right);
    }
}
