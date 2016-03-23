package procedural;

/*
 * Реализация двусвязного списка и методов для работы с ним
 */
public class DoubleNode {
    private  int value;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(int value, DoubleNode next, DoubleNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }


}
