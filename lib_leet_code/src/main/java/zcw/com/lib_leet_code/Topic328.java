package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/6/14.<br><br>
 */
public class Topic328 {

    public static void main(String[] args) {
        Topic328 topic328 = new Topic328();

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        ListNode head = Util.createList(array);
        Util.printList(head);

        ListNode oddEvenHead = topic328.oddEvenList(head);
        Util.printList(oddEvenHead);

        head = Util.createList(array2);
        Util.printList(head);

        oddEvenHead = topic328.oddEvenList(head);
        Util.printList(oddEvenHead);

//        ListNode oddHead = topic328.oddList(head, true);
//        Util.printList(oddHead);
    }

    /**
     * 奇偶链表
     * @param head 头节点
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode evenHead = head;
        ListNode evenTail = evenHead;
        ListNode oddHead = head.next;
        ListNode oddTail = oddHead;
        ListNode indexNode = head;

        while (indexNode != null && indexNode.next != null) {
            indexNode = indexNode.next.next;

            if(indexNode != null) {
                evenTail.next = indexNode;
                oddTail.next = indexNode.next;
            }
            else {

            }


            evenTail = evenTail.next;
            oddTail = oddTail.next;
        }

        evenTail.next = oddHead;
        return evenHead;
    }

    /**
     * 获取奇链表，或者偶链表
     * @param head 头节点
     * @param odd true获取奇链表；false获取偶链表。
     * @return
     */
    public ListNode oddList(ListNode head, boolean odd) {
        if(head == null) {
            return null;
        }

        ListNode oddHead;
        ListNode oddTail;
        ListNode indexNode;

        if(odd) {
            oddHead = head.next;
            oddTail = oddHead;
            indexNode = head.next;
        }
        else {
            oddHead = head;
            oddTail = oddHead;
            indexNode = head;
        }


        while (indexNode != null && indexNode.next != null) {
            indexNode = indexNode.next.next;
            oddTail.next = indexNode;
            oddTail = oddTail.next;
        }

        return oddHead;
    }
}
