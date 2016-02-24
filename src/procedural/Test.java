package procedural;

/**
 * Created by Stanislav on 03.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println(0);
            main(args);
            System.out.println(1);
        } catch (StackOverflowError e) {
            System.out.println("catch");
            main(args);
        }
    }

}
