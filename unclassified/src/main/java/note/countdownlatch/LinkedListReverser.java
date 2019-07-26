package note.countdownlatch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author AmazingZ
 * @date 2018/11/1 16:16
 */
public class LinkedListReverser {


    /*
     * 反转一个链表
     * head为待反转链表的头结点
     * @return 反转后的链表头结点，当然该链表也是以null结尾
     */
    public Node reverseLinkedList(Node head) {

        /*
         *特殊处理
         */
//		//空链表，sise==0
//		if(head==null){
//			return null;
//		}
//		//只有一个结点的时候,size==1
//		if(head.getNext()==null){
//			return head;
//		}

        //把上两个特殊情况合起来
        if (head == null || head.getNext() == null) {
            return head;
        }


        //假设函数能够反转链表，返回头结点
        //---------------此处head有可能是null，head。getNext（）有可能是null-----------
        Node newHead = reverseLinkedList(head.getNext());
        //此时如图4状态，1的getNext就是第二个结点2，
        //把第二结点2的next指向head则实现把2的指针指向1，如图5
        //------------此处的getNext（）有可能是null------
        head.getNext().setNext(head);
        head.setNext(null);//最后指向null，如图6
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListCreator creator = new LinkedListCreator();
        LinkedListReverser reverser = new LinkedListReverser();


        ArrayList arrayList = new ArrayList<>();

//        Node.printLinkedList(
//                reverser.reverseLinkedList(creator.createLinkedList(arrayList))
//        );
//        Node.printLinkedList(
//                reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1)))
//        );
        Node.printLinkedList(
                reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1, 2, 3, 4, 5)))
        );

    }

}
