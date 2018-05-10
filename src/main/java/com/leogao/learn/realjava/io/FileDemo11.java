package com.leogao.learn.realjava.io;

import java.io.File;

/**
 * 类package-info.java的实现描述：TODO 类实现描述
 * 
 * @author leogao 2018年4月19日 下午3:44:52
 */
class RealJavaConstants {
    public final static String FILE_PATH_ROOT = "src/com/leogao/learn/realjava/";
}

class IORealJavaConstants extends RealJavaConstants {
    public final static String FILE_PATH_ROOT = "src/com/leogao/learn/realjava/io/";
}

public class FileDemo11 {
    public static void main(String args[]) {
        File my = new File(RealJavaConstants.FILE_PATH_ROOT + "io" + File.separator); // 操作路径
        print(my);
    }

    public static void print(File file) { // 递归调用
        if (file != null) { // 判断对象是否为空
            if (file.isDirectory()) { // 如果是目录
                File f[] = file.listFiles(); // 列出全部的文件
                if (f != null) { // 判断此目录能否列出
                    for (int i = 0; i < f.length; i++) {
                        print(f[i]); // 因为给的路径有可能是目录，所以，继续判断
                    }
                }
            } else {
                System.out.println(file); // 输出路径
            }
        }
    }
};
