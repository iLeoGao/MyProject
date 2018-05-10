package com.leogao.any.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
        System.out.println(InetAddress.getByName("www.baidu.com").getHostName());
    }
}
