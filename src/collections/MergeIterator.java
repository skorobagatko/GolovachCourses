package collections;

import java.util.Iterator;

public class MergeIterator implements Iterator<Integer> {
    private final Iterator<Integer> one;
    private final Iterator<Integer> two;
    private Integer currentOne;
    private Integer currentTwo;

    public MergeIterator(Iterator<Integer> one, Iterator<Integer> two) {
        this.one = one;
        this.two = two;
        currentOne = one.next();
        currentTwo = two.next();
    }

    /*
        Так как автоматического вызова методов hasNext() и next() для итераторов one/two в данном случае не происходит,
        мы создаем свою проверку достижения граничных значений каждого итератора.
        Как только один из итераторов достиг максимального значения, переменной currentOne/currentTwo
        присваивается значение null. Это и будет являться для нас "флагом" того, что итератор отработал
        весь свой диапазон значений.
        Таким образом, если обе переменные (currentOne и currentTwo) равны null, значит мы закончили работу.
     */
    @Override
    public boolean hasNext() {
        return (currentOne != null || currentTwo != null);
    }

    @Override
    public Integer next() {
        int result = 0;

        if (currentOne != null && currentTwo != null) {
            if (currentOne < currentTwo) {
                result = currentOne;
                currentOne = (one.hasNext()) ? one.next() : null;
            } else {
                result = currentTwo;
                currentTwo = (two.hasNext()) ? two.next() : null;
            }
        } else if (currentOne == null && currentTwo != null) {
            result = currentTwo;
            currentTwo = (two.hasNext()) ? two.next() : null;
        } else if (currentOne != null && currentTwo == null) {
            result = currentOne;
            currentOne = (one.hasNext()) ? one.next() : null;
        }
        return result;
    }
}
