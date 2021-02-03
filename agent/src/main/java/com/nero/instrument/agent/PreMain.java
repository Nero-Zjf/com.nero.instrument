package com.nero.instrument.agent;

import java.lang.instrument.Instrumentation;

public class PreMain {
    /**
     *
     * @param agentArgs agentArgs 是 premain 函数得到的程序参数，随同 “-javaagent”一起传入
     * @param inst Inst 是一个 java.lang.instrument.Instrumentation 的实例，由 JVM 自动传入
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new Transformer());
    }


    /**
     *
     * @param agentArgs agentArgs 是 premain 函数得到的程序参数，随同 “-javaagent”一起传入
     */
    public static void premain(String agentArgs) {
    }
}
