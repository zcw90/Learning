package com.zcw.taskdemo;

/**
 * Created by 朱城委 on 2019/pic2/27.<br><br>
 */
public class TestString {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        strJoint1();
        System.out.println("time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        strJoint2();
        System.out.println("time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        strJoint3();
        System.out.println("time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        strJoint4();
        System.out.println("time: " + (System.currentTimeMillis() - start));
    }

    private static void strJoint1() {
        String str = "AAA";

        for(int i = 0; i < 50000; i++) {
            str += "BBB";
        }
    }

    private static void strJoint2() {
        String str = "AAA";

        for(int i = 0; i < 50000; i++) {
            str.concat("BBB");
        }
    }

    private static void strJoint3() {
        StringBuilder builder = new StringBuilder("AAA");
        for(int i = 0; i < 50000; i++) {
            builder.append("BBB");
        }
    }

    private static void strJoint4() {
        StringBuffer builder = new StringBuffer("AAA");
        for(int i = 0; i < 50000; i++) {
            builder.append("BBB");
        }
    }
}
