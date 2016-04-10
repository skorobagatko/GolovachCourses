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
        int prime = 17;
        int result = 1;
        if (stringArr == null) { result = prime * result; }
        else {
            for (int i = 0; i < stringArr.length; i++) {
                for (int j = 0; j < stringArr[i].length; j++) {
                    String currentString = stringArr[i][j];
                    result = prime * result + ((currentString != null) ? currentString.hashCode() : 0);
                }
            }
        }
        if (doubleArr == null) { result = prime * result; }
        else {
            for (double d : doubleArr) {
                long l = Double.doubleToLongBits(d);
                int current = (int) (l - (l >>> 32));
                result = prime * result + current;
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        EntityB that = (EntityB) obj;
        if (this.hashCode() == that.hashCode()) return true;
        return (Arrays.equals(this.stringArr, that.stringArr) && Arrays.equals(this.doubleArr, that.doubleArr));
    }

    @Override
    public String toString() {
        return new String("EntityB : \n" + Arrays.deepToString(this.stringArr) +
                                    "\n" + Arrays.toString(doubleArr));
    }

    public static void main(String[] args) {
        String[][] stringArr = {{"Mike", "John"}, {"Sara", "Pit", "Phil"}, {"Andrew"}};
        double[] doubleArr = {0.12, 1.34, 3,48};
        EntityB entity = new EntityB(stringArr, doubleArr);
        System.out.println(entity);
    }
}
