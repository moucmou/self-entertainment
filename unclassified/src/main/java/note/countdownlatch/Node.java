package note.countdownlatch;

/**
 * @author AmazingZ
 * @date 2018/11/1 16:17
 */
public class Node {

    private final int value;//用户定义之后就不能修改
    private Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;//这样建立出来的结点都是单点Node
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    //打印函数
    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.getValue());
            ;
            System.out.print(" ");
            head = head.getNext();
        }
        System.out.println();
    }
}
