package collections.equals_hashcode;

/**
 *
 */
public class EntityTest {

    public static void main(String[] args) {
        // EntityB test
        String[][] stringArr1 = new String[][]{{"a"},{"b"}};
        double[] doubleArr1 = new double[]{Double.NaN, Double.POSITIVE_INFINITY};
        EntityB entity1 = new EntityB(stringArr1, doubleArr1);
        String[][] stringArr2 = new String[][]{{"a"},{"b"}};
        double[] doubleArr2 = new double[]{Double.NaN, Double.POSITIVE_INFINITY};
        EntityB entity2 = new EntityB(stringArr2, doubleArr2);
        System.out.println(entity2.equals(entity1));

        // EntityC test

    }
}
