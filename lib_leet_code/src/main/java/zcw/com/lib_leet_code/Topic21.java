package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/7/5.<br><br>
 */
public class Topic21 {

    public static void main(String[] args) {
        Topic21 instance = new Topic21();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Util.printList(instance.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(-1);
        ListNode cursor = head;

        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cursor.next = l1;
                l1 = l1.next;
            }
            else {
                cursor.next = l2;
                l2 = l2.next;
            }

            cursor = cursor.next;
        }

        if(l1 != null) {
            cursor.next = l1;
        }
        else {
            cursor.next = l2;
        }

        return head.next;
    }
}
