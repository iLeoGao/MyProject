package com.leogao.learn.realjava.io;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class SystemDemo07 {
    public static void main(String args[]) {
        String str = "hello"; // 声明一个非数字的字符串
        try {
            System.out.println(Integer.parseInt(str)); // 转型
        } catch (Exception e) {
            try {
                System.setOut(new PrintStream(new FileOutputStream(IORealJavaConstants.FILE_PATH_ROOT + "err.log"))); // 输出重定向
            } catch (Exception e1) {

            }
            System.out.println(e);
        }
    }
};
