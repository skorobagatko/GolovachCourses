package procedural;

/**
 * Created by Stanislav on 01.02.2016.
 */
public class Node {
    int value;
    Node next;

    public Node(int value) {
        new Node(value, null);
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public static void main(String[] args) {
        Node node = createIter(10);
        System.out.println(node);
        System.out.println(sizeIter(node));

        Node node2 = createRec(5);
        System.out.println("toString - " + node2);
        System.out.println("SizeIter - " + sizeIter(node2));
        System.out.println("SizeRec - " + sizeRec(node2));
        System.out.println("SumIter - " + sumIter(node2));
        System.out.println("SumRec - " + sumRec(node2));
        node2.add(new Node(45, null), 5);
        System.out.println("Add - " + node2);
        System.out.println("MaxIter - " + maxIter(node2));
        remove(node2);
        System.out.println("Remove - " + node2);
    }
    // Создаем список итеративно
    public static Node createIter( int size ) {
        Node result = null;
        for (int i = size; i >= 0; i--) {
            result = new Node(0, result);
        }
        return result;
    }
    // Создаем список рекурсивно
    public static Node createRec( int size ) {
        if (size >= 0) return new Node(0, createRec(size - 1));;
        return null;
    }
    // Удаляем последний элемент из списка
    public static void remove( Node node ) {
        Node copy = node;
        int size = sizeIter(copy);
        for ( int i = 0; i < size-1; i++) {
            copy = copy.next;
        }
        copy.next = null;
    }
    // Добавляем элемент в список в указанную позицию
    public void add(Node node, int index) {
        Node origin = this;
        if (index == 0) {
            node.next = this.next;  // разобраться как вставлять элемент в начало списка
        } else {
            for (int i = 0; i < index - 1; i++) {
                origin = origin.next;
            }
            node.next = origin.next;
            origin.next = node;
        }
    }
    // Узнаем размер списка итеративно
    public static int sizeIter(Node node) {
        if (node == null) return 0;
        if (node.next == null) return 1;
        Node copy = node;
        int result = 0;
        while (copy.next != null) {
            result++;
            copy = copy.next;
        }
        return result;
    }
    // Узнаем размер списка рекурсивно
    public static int sizeRec(Node node) {
        if (node.next == null) return 0;
        int result = 1;
        return result += sizeRec(node.next);
    }
    // Суммируем все элементы списка итеративно
    public static int sumIter(Node node) {
        Node copy = node;
        int result = 0;
        while (copy.next != null) {
            result += copy.value;
            copy = copy.next;
        }
        return result;
    }
    // Суммируем все элементы списка рекурсивно
    public static int sumRec(Node node) {
        int result = 0;
        if (node.next != null) result = node.value += sumRec(node.next);
        return result;
    }
    // Ищем максимальный элемент в списке (итеративно)
    public static int maxIter(Node node) {
        int result = 0;
        while (node != null) {
            if (node.value > result) { result = node.value; }  // Почему-то выводит не правильное значение
            node = node.next;
        }
        return result;
    }
    // Переопределяем метод для вывода на экран
    public String toString() {
        Node node = this;
        StringBuilder sb = new StringBuilder("{");
        while ( node.next != null) {
            sb.append(" ").append(node.value);
            node = node.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

}
