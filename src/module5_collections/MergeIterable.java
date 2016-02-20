package module5_collections;

import java.util.Iterator;

public class MergeIterable implements Iterable<Integer> {
    private final Iterable<Integer> one;
    private final Iterable<Integer> two;

    public MergeIterable(Iterable<Integer> one, Iterable<Integer> two) {
        this.one = one;
        this.two = two;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MergeIterator(one.iterator(), two.iterator());
    }
}
