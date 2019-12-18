package com.zcw.taskdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by 朱城委 on 2019/pic2/28.<br><br>
 */
public class SerializeTest {

    public static void main(String[] args) throws Exception {
        Test test = new Test("AAA", 33);
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("obj.data"));
//        outputStream.writeObject(test);

        Test test1;
        Test test2;
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("obj.data"));
//        test1 = (Test) inputStream.readObject();
        test2 = (Test) inputStream.readObject();
//        System.out.println("test1 = " + test1);
        System.out.println("test2 = " + test2);
    }

    static class Test implements Serializable {
        private String str;
        private int value;

        public Test(String str, int value) {
            this.str = str;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + str + "," + value + "]";
        }
    }
}
