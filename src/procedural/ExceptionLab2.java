package procedural;

/**
 На месте каждого комментария в секции if (true)
 - оставить комментарий
 - поставить throw new NullPointerException();
 - поставить throw new RuntimeException();
 - поставить throw new IOException();
 - поставить throw new Error();
 Привести примеры всех возможных трасс
 */
public class ExceptionLab2 {
    public static void main(String[] args) {
        System.out.println(0);
        try {
            System.out.println(1);
            if (true) {  }
            System.out.println(2);
        } catch (NullPointerException e) {
            System.out.println(3);
            if (true) {  }
            System.out.println(4);
        } catch (RuntimeException e) {
            System.out.println(5);
            if (true) {  }
            System.out.println(6);
        } catch (Exception e) {
            System.out.println(7);
            if (true) {  }
            System.out.println(8);
        } finally {
            System.out.println(9);
            if (true) {  }
            System.out.println(10);
        }
        System.out.println(11);
    }
}
