package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/6/14.<br><br>
 */
public class Util {

    /**
     * 创建链表
     * @param array
     * @return
     */
    public static ListNode createList(int[] array) {

        if(array == null || array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode indexNode = head;

        for(int i = 1; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            indexNode.next = node;
            indexNode = indexNode.next;
        }

        return head;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");

            head = head.next;
        }
        System.out.println();
    }

    /**
     * 打印数组
     * @param array
     */
    public static void printArray(int[] array) {
        if(array == null) {
            return ;
        }

        for(int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
