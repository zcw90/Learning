//package zcw.com.basic.asm;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import jdk.internal.org.objectweb.asm.ClassReader;
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.ClassWriter;
//
///**
// * Created by 朱城委 on 2019/10/29.<br><br>
// */
//public class Generator {
//    public static void main(String[] args) throws IOException {
//        ClassReader classReader = new ClassReader("./lib_java_basic/src/main/java/zcw/com/basic/asm/Base");
//        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
//
//        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
//        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
//        byte[] data = classWriter.toByteArray();
//
//        //输出
//        File file = new File("./lib_java_basic/src/main/java/zcw/com/basic/asm/Base.class");
//        FileOutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(data);
//        outputStream.close();
//        System.out.println("now generator cc success!!!!!");
//    }
//}
