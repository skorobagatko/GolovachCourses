package collections.equals_hashcode;

import java.util.Arrays;

/**
 * Дан класс, представляющий собой некоторую бизнес-сущность (entity), объект предметной области (domain object).
 * Необходимо для него корректно определить методы equals(..), hashCode() и toString().
 */
public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;

    public EntityB(String[][] stringArr, double[] doubleArr) {
        this.stringArr = stringArr;
        this.doubleArr = doubleArr;
    }

    public String[][] getStringArr() {
        return stringArr;
    }

    public double[] getDoubleArr() {
        return doubleArr;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + ((stringArr == null) ? 0 : Arrays.deepHashCode(stringArr));
        result = 31 * result + ((doubleArr == null) ? 0 : Arrays.hashCode(doubleArr));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        EntityB that = (EntityB) obj;
        return (Arrays.deepEquals(this.stringArr, that.stringArr)
                && Arrays.equals(this.doubleArr, that.doubleArr));
    }

    @Override
    public String toString() {
        return "EntityB : \n" + Arrays.deepToString(this.stringArr) +
                "\n" + Arrays.toString(doubleArr);
    }
}
