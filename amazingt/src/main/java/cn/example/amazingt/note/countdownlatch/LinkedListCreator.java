package cn.example.amazingt.note.countdownlatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AmazingZ
 * @date 2018/11/1 16:17
 */
public class LinkedListCreator {

    /*
     * 创建一个链表
     * @return 链表的头结点，返回链表的最后一个结点的getNext()==null.
     */
    public Node createLinkedList(List<Integer> data){
        //假设传入空的List
        if(data.isEmpty()){
            return null;
        }

        //取出传入数据的第一个结点
        Node firstNode=new Node(data.get(0));
        //取走一个元素后，从第二个元素创建一个链表，
        //因为返回的是Node，所以用Node来接收
        //假设传入来的List有一个元素，则走到这里时sublist传入的两个参数相等
        //但是sublist函数的定义可以看到fromIndex==toIndex时，返回null
        /*
         *  &lt;tt&gt;fromIndex&lt;/tt&gt; and &lt;tt&gt;toIndex&lt;/tt&gt; are equal, the returned list is
         */
        //与我们期望返回值一致
//		Node headOfSublistNode=
//				createLinkedList(data.subList(1, data.size()));
//		//第一个结点的next指向规模缩小的链表返回来的头结点
//		firstNode.setNext(headOfSublistNode);
        //上面两行代码清理成如下代码
        firstNode.setNext(createLinkedList(data.subList(1, data.size())));
        return firstNode;

    }
    public static void main(String[] args) {
        LinkedListCreator creator=new LinkedListCreator();

        ArrayList arrayList=new ArrayList<>();

        Node.printLinkedList(
                creator.createLinkedList(arrayList)
        );
        Node.printLinkedList(
                creator.createLinkedList(Arrays.asList(1))
        );
        Node.printLinkedList(
                creator.createLinkedList(Arrays.asList(1,2,3,4,5))
        );
    }
}
