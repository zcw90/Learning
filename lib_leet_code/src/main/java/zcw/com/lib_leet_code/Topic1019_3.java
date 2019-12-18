package zcw.com.lib_leet_code;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by 朱城委 on 2019/6/17.<br><br>
 */
public class Topic1019_3 {
    public static void main(String[] args) {
        Topic1019_3 instance = new Topic1019_3();

        int[] array1 = new int[] {2, 1, 5};
        int[] array2 = new int[] {2, 7, 4, 3, 5};
        int[] array3 = new int[] {1, 7, 5, 1, 9, 2, 5, 1};
        int[] array4 = new int[] {9, 7, 6, 7, 6, 9};
        int[] array5 = new int[] {4, 3, 2, 5, 1, 8, 10};

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

        head = Util.createList(array4);
        for(int value : instance.nextLargerNodes(head)) {
            System.out.print(value + "\t");
        }
        System.out.println();

        head = Util.createList(array5);
        for(int value : instance.nextLargerNodes(head)) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }

        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                result[stack.pop()] = list.get(i);
            }

            stack.push(i);
        }

        return result;
    }
}
