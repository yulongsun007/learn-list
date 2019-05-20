package win.yulongsun.demo.spring.core.asm;

import org.junit.Test;
import org.springframework.asm.ClassWriter;
import org.springframework.asm.MethodVisitor;
import org.springframework.asm.Opcodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Sun.YuLong on 2018/4/19.
 */
public class AsmTest {

    @Test
    public void testCreateClass() {
        ClassWriter classWriter = new ClassWriter(0);
        // 创建类
        classWriter.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                "AsmClazz",
                null,
                "java/lang/Object",
                null);
        // 创建构造函数
        MethodVisitor constructMethod = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructMethod.visitCode();
        constructMethod.visitVarInsn(Opcodes.ALOAD, 0);
        constructMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "<init>", "()V");
        constructMethod.visitInsn(Opcodes.RETURN);
        constructMethod.visitMaxs(1, 1);
        constructMethod.visitEnd();

        // 创建code
        MethodVisitor visitMethod = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "say", "()V", null, null);
        visitMethod.visitCode();
        visitMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream");
        visitMethod.visitLdcInsn("I'm a asm class .");
        visitMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        visitMethod.visitInsn(Opcodes.RETURN);
        visitMethod.visitMaxs(2, 2);
        visitMethod.visitEnd();
        //
        //输出到文件
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("AsmCode.class"));
            fileOutputStream.write(classWriter.toByteArray());
            fileOutputStream.close();
            System.out.println("生成结束");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

