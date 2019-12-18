package zcw.com.lib_leet_code;

/**
 * Created by 朱城委 on 2019/7/5.<br><br>
 */
public class Topic23 {

    public static void main(String[] args) {
        Topic23 instance = new Topic23();

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }

        ListNode head = null;
        while (!isEnd(lists)) {

        }

        return head;
    }

    /**
     * 判断是否所以链表都到了末尾
     * @param lists
     * @return 如果所有链表都到了末尾，返回true，否则返回false。
     */
    private boolean isEnd(ListNode[] lists) {
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                return false;
            }
        }

        return true;
    }
}
