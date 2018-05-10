package com.leogao.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckIdCardTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckIdCardTest.class);

    public static void main(String[] args) {
        // 非空
        System.out.println("非空");
        checkIdCardBy18("", true);
        // 不是18位或者15位
        System.out.println("不是18位或者15位");
        checkIdCardBy18("14052200010275", true);
        checkIdCardBy18("1405220001027512", true);
        checkIdCardBy18("1405222000010275671", true);

        /** 15位校验 */
        // 正确
        System.out.println("15位正确");
        checkIdCardBy15("140522000102756", true);

        /** 18位校验 */
        // 正确
        System.out.println("18位正确");
        checkIdCardBy18("140522200001027567", true);
        // 日期不能超过今天
        System.out.println("日期不能超过今天");
        checkIdCardBy18("140522203001027560", true);
        // 月份只能1～12
        System.out.println("月份只能1～12");
        checkIdCardBy18("14052220000132756X", true);
        // 日期只能1～31
        System.out.println("日期只能1～31");
        checkIdCardBy18("140522200001437566", true);
        // 日期只能是实际日期
        System.out.println("日期只能是实际日期");
        checkIdCardBy18("140522200002307560", true);
        // 第1-17位为数字
        System.out.println("第1-17位为数字");
        checkIdCardBy18("1405222000010275x7", true);
        // 第18位验证码不对
        System.out.println("第18位验证码不对");
        checkIdCardBy18("140522200001027561", true);

    }

    private static boolean checkIdCardBy15(String certificateNo, boolean bool) {
        boolean validateResult = new CheckIdCard(certificateNo).validate();
        System.out.println(certificateNo + " is " + validateResult);
        if (validateResult != bool) {
            LOGGER.info("CheckIdCard Logic Wrong!");
        }
        return validateResult != bool;
    }

    private static boolean checkIdCardBy18(String certificateNo, boolean bool) {
        boolean validateResult = new CheckIdCard(certificateNo).validate();
        System.out.println(certificateNo + " is " + validateResult);
        if (validateResult != bool) {
            LOGGER.info("CheckIdCard Logic Wrong!");
        }
        return validateResult != bool;
    }

}
