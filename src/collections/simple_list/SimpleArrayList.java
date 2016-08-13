package collections.simple_list;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.max;

/**
 *
 */
public class SimpleArrayList<E> implements SimpleList<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }


    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheck(index);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return data[cursor++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean contains(Object element) {
        if (element == null) { // look for null
            for (int k = 0; k < size; k++) {
                if (null == data[k]) {
                    return true;
                }
            }
        } else { // look for !null
            for (int k = 0; k < size; k++) {
                if (element.equals(data[k])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E set(int index, E newElement) {
        rangeCheck(index);
        E oldElement = data[index];
        data[index] = newElement;
        return oldElement;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++) {
                if (data[index] == null) {
                    simpleRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(data[index])) {
                    simpleRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    private void simpleRemove(int index) {
        int range = size - 1 - index;
        System.arraycopy(data, index+1, data, index, range);
        data[--size] = null;
    }


    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int index = 0; index < size; index++) {
            sb.append(data[index]);
            if (index == size-1) break;
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
