package zcw.com.basic.copy;

/**
 * Created by 朱城委 on 2019/9/23.<br><br>
 * 深拷贝、浅拷贝Demo
 */
public class CopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        shallowCopy();
        System.out.println("==========");
        deepCopy();
    }

    /**
     * 浅拷贝示例
     */
    private static void shallowCopy() {
        StudentShallow student1 = new StudentShallow("张三");
        StudentShallow student2 = student1;
        System.out.println("student1: " + student1.getName());
        System.out.println("student2: " + student2.getName());
        System.out.println("student1 == student2: " + (student1 == student2));

        student2.setName("李四");
        System.out.println("student1: " + student1.getName());
        System.out.println("student2: " + student2.getName());
        System.out.println("student1 == student2: " + (student1 == student2));
    }

    /**
     * 浅拷贝示例
     */
    private static void deepCopy() throws CloneNotSupportedException {
        StudentDeep student1 = new StudentDeep("张三");
        StudentDeep student2 = student1.clone();
        System.out.println("student1(" + student1 + "): " + student1.getName());
        System.out.println("student2(" + student2 + "): " + student2.getName());
        System.out.println("student1 == student2: " + (student1 == student2));

        student2.setName("李四");
        System.out.println("student1(" + student1 + "): " + student1.getName());
        System.out.println("student2(" + student2 + "): " + student2.getName());
        System.out.println("student1 == student2: " + (student1 == student2));
    }
}
