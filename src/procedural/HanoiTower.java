package procedural;

import java.util.Stack;

/*
 Задача "Ханойская башня" для 3-х дисков и 3-ч штырей.
 */
public class HanoiTower {
    public static void main(String[] args) {
        Stack<Integer> from = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();
        Stack<Integer> to = new Stack<Integer>();
        from.push(3);
        from.push(2);
        from.push(1);
        System.out.println(from + " " + help + " " + to);
        exchange(from, help, to, 3);
        System.out.println(from + " " + help + " " + to);
    }

    public static void exchange(Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int count) {
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }
}
