package zcw.com.lib_structure;

/**
 * Created by 朱城委 on 2019/7/1.<br><br>
 * 带双亲线索二叉树节点
 */
public class BiThrWithParentNode {
    public char data;

    public BiThrWithParentNode left;
    public BiThrWithParentNode right;
    public BiThrWithParentNode parent;

    public PointerTag lTag = PointerTag.Link;
    public PointerTag rTag = PointerTag.Link;

    /**
     * 线索二叉树孩子节点标识，如果为{@link #Link}，表示指向左右孩子指针；如果为{@link #Thread}，表示指向前驱或者后继的线索。
     */
    public enum PointerTag {
        /** 指向左右孩子指针 */
        Link,

        /** 指向前驱或者后继的线索 */
        Thread
    }
}
