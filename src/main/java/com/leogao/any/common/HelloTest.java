package com.leogao.any.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloTest.class);

    @Test
    public void printHello() {
        System.out.println("HelloWorld");
    }

    @Test
    public void callMethod() {
        LOGGER.info("callMethod: ");
        printHello();
    }

    public static void main(String[] args) {
        LOGGER.info("LOGGER 123");
        System.out.println("123");

    }

}
