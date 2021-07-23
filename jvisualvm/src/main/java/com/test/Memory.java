package com.test;

import sun.misc.GC;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Memory {
    public static Map staticMap = new HashMap();
    public Map normalMap = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        Memory memory = new Memory();
        while(true){
            Thread.sleep(5000);
            for (int i = 0; i < 5000; i++) {
                HashMap<Object, Object> methodMap = new HashMap<>();
            }
        }
    }
    /*GC (Allocation Failure) [PSYoungGen: 5632K->496K(6144K)] 5632K->1160K(19968K), 0.0013353 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6128K->504K(6144K)] 6792K->1880K(19968K), 0.0016616 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6136K->512K(6144K)] 7512K->2344K(19968K), 0.0014097 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6144K->512K(6144K)] 7976K->2384K(19968K), 0.0013691 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6144K->512K(6144K)] 8016K->2432K(19968K), 0.0013729 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6144K->576K(7168K)] 8064K->2504K(20992K), 0.0014530 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 6208K->320K(7168K)] 8136K->2584K(20992K), 0.0015943 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
            [GC (Allocation Failure) [PSYoungGen: 5478K->511K(6144K)] 17766K->13732K(19968K), 0.0016107 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

            5478K->511K(6144K)：
    中括号 “[ ]” 内的数值，表示 “
    sun.misc.GC 前该区域（此处代表新生代）已使用内存 -> GC 后该区域已使用内存（该区域内存总量）”。

            17766K->13732K(19968K)：
    中括号 “[ ]” 后面的数值，表示 “GC 前堆区已使用内存 -> GC 后堆区已使用内存（堆区内存总量）”。

            0.0016107 secs]：
    本次 GC 耗时，单位为秒。

            [Times: user=0.00 sys=0.00, real=0.00 secs]：
    分别表示：用户态耗时、内核态耗时、总耗时。*/
}
