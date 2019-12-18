package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 朱城委 on 2019/6/17.<br><br>
 */
public class Topic1019 {
    public static void main(String[] args) {
        Topic1019 instance = new Topic1019();

        int[] array1 = new int[] {2, 1, 5};
        int[] array2 = new int[] {2, 7, 4, 3, 5};
        int[] array3 = new int[] {1, 7, 5, 1, 9, 2, 5, 1};

        ListNode head = Util.createList(array1);
        for(int value : instance.nextLargerNodes(head)) {
            System.out.print(value + "\t");
        }
        System.out.println();

        head = Util.createList(array2);
        for(int value : instance.nextLargerNodes(head)) {
            System.out.print(value + "\t");
        }
        System.out.println();

        head = Util.createList(array3);
        for(int value : instance.nextLargerNodes(head)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return new int[] {};
        }

        List<Integer> list = new ArrayList<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            list.add(nextLargerNode(tempNode));

            tempNode = tempNode.next;
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int nextLargerNode(ListNode node) {
        if(node == null) {
            return 0;
        }

        int value = node.val;
        ListNode tempNode = node.next;
        while(tempNode != null) {
            if(tempNode.val > value) {
                return tempNode.val;
            }

            tempNode = tempNode.next;
        }

        return 0;
    }
}
