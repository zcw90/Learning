//package zcw.com.basic.asm;
//
//import jdk.internal.org.objectweb.asm.ClassVisitor;
//import jdk.internal.org.objectweb.asm.MethodVisitor;
//import jdk.internal.org.objectweb.asm.Opcodes;
//
///**
// * Created by 朱城委 on 2019/10/29.<br><br>
// */
//public class MyClassVisitor extends ClassVisitor implements Opcodes {
//
//    public MyClassVisitor(ClassVisitor cv) {
//        super(ASM5, cv);
//    }
//
//    @Override
//    public void visit(int version, int access, String name, String signature,
//                      String superName, String[] interfaces) {
//        cv.visit(version, access, name, signature, superName, interfaces);
//    }
//
//    @Override
//    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
//        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
//
//        if(!name.equals("<init>") && mv != null) {
//            mv = new MyMethodVisitor(mv);
//        }
//
//        return mv;
//    }
//
//    class MyMethodVisitor extends MethodVisitor implements Opcodes {
//
//        public MyMethodVisitor(MethodVisitor mv) {
//            super(ASM5, mv);
//        }
//
//        @Override
//        public void visitCode() {
//            super.visitCode();
//
//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("start");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        }
//
//        @Override
//        public void visitInsn(int opcode) {
//            if((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
//                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//                mv.visitLdcInsn("end");
//                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            }
//
//            mv.visitInsn(opcode);
//        }
//    }
//}
