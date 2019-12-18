package com.zcw.taskdemo;

import java.util.Random;

/**
 * Created by 朱城委 on 2019/pic3/pic1.<br><br>
 */
public class EvenDemo {
    public static void main(String[] args) {
        Random random = new Random();

        for(int i = 0; i < 10; i++) {
            int value = random.nextInt(100);
            System.out.println(value + " is even:" + isOdd(value));
        }
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }
}
