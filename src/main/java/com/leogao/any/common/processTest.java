package com.leogao.any.common;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.leogao.common.exception.MyException;

public class processTest {
    static String errorCode = "81";
    static String errorMsg  = "很抱歉，本产品保费金额不可为0或小于0。";

    public static void main(String[] args) throws MyException {

        String valueRegex = "1";
        String valueRegex_2 = "^[0-9]{4}+(.[0-9]{2})?$";
        checkSingleMathes();
        //     checkProcessLogic(valueRegex);
        //   checkProcessLogic(valueRegex_2);
        //checkProcessLogic(ZhengZeTest.valueRegex_1);
    }

    private static void checkSingleMathes() {
        String valueRegex_3 = "^\\d*$";
        String valueRegex_4 = "^[1-9]\\d*(\\.\\d*)?|0\\.[1-9]\\d*|0\\.0*[1-9]\\d*$";
        String valueRegex_5 = "^[1-9]\\d*(\\.\\d*)?|0\\.\\d*[1-9]\\d*$";
        //        singleMatches(valueRegex);
        //        singleMatches(valueRegex_2);
        //        singleMatches(ZhengZeTest.valueRegex_1);
        singleMatches(valueRegex_4);
        singleMatches(valueRegex_5);
    }

    private static void singleMatches(String valueRegex) {
        List<String> keys = Arrays.asList("0", "0.00", "0.001", "0.01", "0.1", "1", "-0.01", "-1", "9999999", "x",
                "51339830", "1.10", "0.10", "0.010");
        System.out.println("Type\t" + "mathes.result");
        for (String key : keys) {
            System.out.print(key + "\t" + key.matches(valueRegex));
            System.out.println();
        }

    }

    private static void checkProcessLogic(String valueRegex) {
        List<String> keys = Arrays.asList("0", "0.00", "0.001", "0.01", "0.1", "1", "-0.01", "-1", "9999999", "x");
        System.out.println("Type\t" + "正-new" + "\t有code" + "\t无code" + "\t反-new" + "\t有code" + "\t无code");
        for (String key : keys) {
            checkAllType(key, valueRegex);
        }
        System.out.println();
    }

    private static void checkAllType(String key, String valueRegex) {
        System.out.print(key + "\t");
        checkZhengZe(key, valueRegex, key, ZhengZeTest.valueRegex_1);
        checkZhengZe(key, valueRegex, key, ZhengZeTest.valueRegex_2);
        checkZhengZe(key, valueRegex, key, ZhengZeTest.valueRegex_3);
        // 互换位置
        checkZhengZe(key, ZhengZeTest.valueRegex_1, key, valueRegex);
        checkZhengZe(key, ZhengZeTest.valueRegex_2, key, valueRegex);
        checkZhengZe(key, ZhengZeTest.valueRegex_3, key, valueRegex);
        System.out.println();
    }

    private static void checkZhengZe(String key, String keyRegex, String value, String valueRegex) {
        //  System.out.print(keyRegex);
        try {
            if (StringUtils.isNotBlank(key)) {
                if (StringUtils.isNotBlank(value) && key.matches(keyRegex)) {
                    //3.4判断值是否符合值正则表达式
                    if (!value.matches(valueRegex)) {
                        throw new MyException(errorCode, errorMsg);
                    }
                }
            }
            System.out.print("✅\t");
        } catch (MyException e) {
            System.out.print("❌\t");
            //  System.out.print("(" + e.getErrorCode() + " " + e.getMessage() + ")\t");
        }

    }
}
