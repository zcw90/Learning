package com.zcw.taskdemo;

import java.util.Random;

/**
 * Created by 朱城委 on 2019/pic2/25.<br><br>
 */
public class Test {

    public static void main(String[] args) {
        LinkNode head = new LinkNode();
        LinkNode tempNode = head;
        head.value = randomInt(100);

        for(int i = 0; i < 9; i++) {
            tempNode.next = new LinkNode();
            tempNode = tempNode.next;
            tempNode.value = randomInt(100);
        }

        traverse(head);

        LinkNode node = reversal(head, 5);
        traverse(node);

        node = reverse(node);
        traverse(node);
    }

    private static int randomInt(int maxValue) {
        return new Random().nextInt(maxValue);
    }

    private static void traverse(LinkNode head) {
        LinkNode node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static LinkNode reversal(LinkNode head, int step) {
        LinkNode headTemp = head;
        LinkNode nodeTemp = head;

        while(nodeTemp != null && step > 0) {
            if(step == 1) {
                headTemp = nodeTemp.next;
                nodeTemp.next = null;
                break;
            }

            nodeTemp = nodeTemp.next;
            step--;
        }

        if(headTemp == head || headTemp == null) {
            return head;
        }

        nodeTemp = headTemp;
        while (nodeTemp.next != null) {
            nodeTemp = nodeTemp.next;
        }
        nodeTemp.next = head;

        return headTemp;
    }

    private static LinkNode reverse(LinkNode head) {
        LinkNode headTemp = head;
        LinkNode nodeCurrent = head;
        LinkNode nodeNext;

        while (nodeCurrent != null) {
            nodeNext = nodeCurrent.next;

            if(nodeCurrent == headTemp) {
                headTemp.next = null;
            }
            else {
                nodeCurrent.next = headTemp;
                headTemp = nodeCurrent;
            }

            nodeCurrent = nodeNext;
        }

        return headTemp;
    }

    private static LinkNode reverse2(LinkNode head) {
        if(head.next == null) {
            return head;
        }

        LinkNode headTemp = reverse2(head.next);
        headTemp.next = head;
        return headTemp;
    }

    private static class LinkNode {
        public LinkNode next;
        public int value;
    }
}
