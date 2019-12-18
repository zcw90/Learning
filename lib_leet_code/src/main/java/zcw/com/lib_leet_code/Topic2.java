package zcw.com.lib_leet_code;

public class Topic2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ListNode head = createList(array);
        printList(head);
        head = solution.listReversal(head);
        printList(head);
        System.out.println("-----");

//        int[] array2 = {2, 4, 3};
//        int[] array3 = {5, 6, 4};
//        int[] array2 = {1};
//        int[] array3 = {9,9,9};
//        int[] array2 = {5};
//        int[] array3 = {5,};
//        int[] array2 = {9,9,9};
//        int[] array3 = {1};
        int[] array2 = {3,7};
        int[] array3 = {9,2};
        ListNode list1 = createList(array2);
        printList(list1);
        ListNode list2 = createList(array3);
        printList(list2);
        list1 = solution.addTwoNumbers(list1, list2);
        printList(list1);
    }

    public static ListNode createList(int[] array) {
        if(array == null) {
            throw new IllegalArgumentException("argument is null.");
        }

        if(array.length < 1) {
            throw new IllegalArgumentException("array length is 0.");
        }

        ListNode head = new ListNode(array[0]);
        ListNode temp = head;
        for(int i = 1; i < array.length; i++) {
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }

        return head;
    }

    public static void printList(ListNode list) {
        if(list == null) {
            throw new IllegalArgumentException("list is null.");
        }

        while (list != null) {
            System.out.print(list.val + "\t");
            list = list.next;
        }
        System.out.println();
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            throw new IllegalArgumentException("argument is null.");
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int sum = 0;
        while(temp1 != null || temp2 != null) {
            sum /= 10;
            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if(sum / 10 == 1) {
            current.next = new ListNode(1);
        }

        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            throw new IllegalArgumentException("argument is null.");
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int sum = 0;
        while(temp1 != null || temp2 != null) {
            sum /= 10;
            if(temp1 != null) {
                sum += temp1.val;
                temp1 = temp1.next;
            }

            if(temp2 != null) {
                sum += temp2.val;
                temp2 = temp2.next;
            }

            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        if(sum / 10 == 1) {
            current.next = new ListNode(1);
        }

        return head.next;
    }

    /**
     * 链表反转
     * @param list
     * @return
     */
    public ListNode listReversal(ListNode list) {
        if(list == null) {
            throw new IllegalArgumentException("list is null.");
        }

        ListNode p = list;
        ListNode q = list.next;
        ListNode head = list;

        while(q != null) {
            head.next = q.next;

            q.next = p;
            p = q;
            q = head.next;
        }

        return p;
    }
}