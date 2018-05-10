package com.leogao.any.common;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ZhengZeTest {

    // 网络正确
    public static final String valueRegex_1 = "^[1-9]\\d*(\\.\\d*[1-9])?|0\\.\\d*[1-9]$";
    // 带errorCode
    public static final String valueRegex_2 = "^-[0-9]\\d*\\.\\d*|-0\\.?\\d*|-?0\\.?0*$";
    // 不带errorCode
    public static final String valueRegex_3 = "^-[1-9]\\d*\\.\\d*|-0\\.\\d*[1-9]\\d*$";
    public static final String valueRegex   = "1";

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test0() {
        String value = "0";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(false, value.matches(valueRegex_1));
        assertEquals(true, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test0Pot00() {
        String value = "0.00";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(false, value.matches(valueRegex_1));
        assertEquals(true, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test0Pot001() {
        String value = "0.001";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(true, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test0Pot01() {
        String value = "0.01";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(true, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test0Pot1() {
        String value = "0.1";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(true, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test1() {
        String value = "1";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(true, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void test999999999() {
        String value = "999999999";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(true, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void testUnder0Pot01() {
        String value = "-0.01";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(false, value.matches(valueRegex_1));
        assertEquals(true, value.matches(valueRegex_2));
        assertEquals(true, value.matches(valueRegex_3));
    }

    @Test
    public void testUnder1() {
        String value = "-1";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(false, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void testString() {
        String value = "a";
        assertEquals(true, value.matches(valueRegex));
        assertEquals(false, value.matches(valueRegex_1));
        assertEquals(false, value.matches(valueRegex_2));
        assertEquals(false, value.matches(valueRegex_3));
    }

    @Test
    public void testValueMatchesValueRegex() {
        String valueRegex = valueRegex_1;
        // 正确
        assertEquals(true, "1".matches(valueRegex));
        assertEquals(true, "0.1".matches(valueRegex));
        assertEquals(true, "0.01".matches(valueRegex));
        assertEquals(true, "0.001".matches(valueRegex));
        // 错误
        assertEquals(false, "0".matches(valueRegex));
        assertEquals(false, "0.00".matches(valueRegex));
        assertEquals(false, "-1".matches(valueRegex));
        assertEquals(false, "-0.01".matches(valueRegex));
    }

    @Test
    public void testValueMatchesValueRegex2() {
        String valueRegex = valueRegex_2;
        // 正确
        assertEquals(true, "1".matches(valueRegex));
        assertEquals(true, "0.1".matches(valueRegex));
        assertEquals(true, "0.01".matches(valueRegex));
        assertEquals(true, "0.001".matches(valueRegex));
        // 错误
        assertEquals(true, "0".matches(valueRegex));
        assertEquals(true, "0.00".matches(valueRegex));
        assertEquals(false, "-1".matches(valueRegex));
        assertEquals(false, "-0.01".matches(valueRegex));
    }

    @Test
    public void testValueMatchesValueRegex3() {
        String valueRegex = valueRegex_3;
        // 正确
        assertEquals(true, "1".matches(valueRegex));
        assertEquals(true, "0.1".matches(valueRegex));
        assertEquals(true, "0.01".matches(valueRegex));
        assertEquals(true, "0.001".matches(valueRegex));
        // 错误
        assertEquals(false, "0".matches(valueRegex));
        assertEquals(false, "0.00".matches(valueRegex));
        assertEquals(false, "-1".matches(valueRegex));
        assertEquals(false, "-0.01".matches(valueRegex));
    }

}
