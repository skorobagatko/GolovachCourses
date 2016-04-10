package exceptions;

/*
     На месте каждого комментария в секции if (true)
    - оставить комментарий
    - поставить throw new NullPointerException();
    - поставить throw new Error();
    Привести примеры всех возможных трасс
 */
public class ExceptionLab1 {
    public static void main(String[] args) {
        System.out.println(0);
        try {
            System.out.println(1);
            if (true) { }
            System.out.println(2);
        } catch (RuntimeException e) {
            System.out.println(3);
            if (true) { throw new NullPointerException(); }
            System.out.println(4);
        } finally {
            System.out.println(5);
            if (true) { throw new Error();}
            System.out.println(6);
        }
        System.out.println(7);
    }
}

/*
c c c - 0 1 2 5 6 7
t c c - 0 1 3 4 5 6 7
e c c - 0 1 5 6 Error
c t c - 0 1 2 5 6 7
c e c - 0 1 2 5 6 7
c c t - 0 1 2 5 NPE
c c e - 0 1 2 5 Error
t t c - 0 1 3 5 6 NPE
t t t - 0 1 3 5 NPE
t t e - 0 1 3 5 Error
c t t - 0 1 2 5 NPE
t e e - 0 1 3 5 Error
t e c - 0 1 3 5 6 Error
e e e - 0 1 5 Error
e c e - 0 1 5 Error
e t e - 0 1 5 Error
e e t - 0 1 5 NPE
e e c - 0 1 5 6 Error
c e e - 0 1 2 5 Error
c t e - 0 1 2 5 Error
 */
