package com.nero.instrument.agent.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;


public class ASMUtil {
    public static byte[] hack(String className) {
        byte[] result = new byte[0];
        try {
            ClassReader classReader = new ClassReader(className);
            ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassVisitor visitor = new MyVisitor(writer);
            classReader.accept(visitor, ClassReader.EXPAND_FRAMES);

            result = writer.toByteArray();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
