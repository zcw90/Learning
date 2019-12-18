package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/6/17.<br><br>
 */
public class Topic1019_2 {
    public static void main(String[] args) {
        Topic1019_2 instance = new Topic1019_2();

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

    private int[] result;
    private ListNode nextLargerNode;
    public int[] nextLargerNodes(ListNode head) {
        if(head == null) {
            return new int[0];
        }

        if(head.next == null) {
            return new int[1];
        }

        nextLargerNode(head, 0);

        return result;
    }

    public ListNode nextLargerNode(ListNode node, int count) {
        if(node == null) {
            result = new int[count];
            return null;
        }

        nextLargerNode = nextLargerNode(node.next, count + 1);
        while(nextLargerNode != null && node.val >= nextLargerNode.val) {
            nextLargerNode = nextLargerNode.next;
        }

        result[count] = nextLargerNode != null ? nextLargerNode.val : 0;
        node.next = nextLargerNode;

        return node;
    }
}
