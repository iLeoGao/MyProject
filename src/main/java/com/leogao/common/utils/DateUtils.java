package com.leogao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期时间工具类
 * 
 * @author leogao 2018年3月23日 下午3:15:38
 */
// TODO 待完善测试
public class DateUtils {
    private static final Logger                               LOGGER                              = LoggerFactory
            .getLogger(DateUtils.class);

    public static final String                                EN_DATE_PATTERN                     = "dd/MM/yyyy";
    public static final String                                EN_DATETIME_PATTERN                 = "dd/MM/yyyy HH:mm:ss";
    public static final String                                EN_DATETIME_PATTERNSSS              = "dd/MM/yyyy HH:mm:ss SSS";

    public static final String                                ZH_DATE_PATTERN                     = "yyyy/MM/dd";
    public static final String                                ZH_DATETIME_PATTERN                 = "yyyy/MM/dd HH:mm:ss";
    public static final String                                ZH_DATETIME_PATTERNSSS              = "yyyy/MM/dd HH:mm:ss SSS";

    public static final String                                CN_DATE_PATTERN                     = "yyyy-MM-dd";
    public static final String                                CN_DATETIME_PATTERN                 = "yyyy-MM-dd HH:mm:ss";
    public static final String                                CN_DATETIME_PATTERNSSS              = "yyyy-MM-dd HH:mm:ss SSS";

    public static final String                                NOMARK_DATE_PATTERN                 = "yyyyMMdd";
    public static final String                                NOMARK_DATETIME_PATTERN             = "yyyyMMddHHmmss";
    public static final String                                NOMARK_DATETIME_PATTERNSSS          = "yyyyMMddhhmmssSSS";

    public static final String                                YYYY_NIAN_MM_YUE_DD_RI              = "yyyy年MM月dd日";
    public static final String                                YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS     = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String                                YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS_SSS = "yyyy年MM月dd日HH时mm分ss秒SSS毫秒";

    public static final String                                HH_MM_SS                            = "HH:mm:ss";
    public static final String                                HH_MM_SS_SSS                        = "HH:mm:ss SSS";

    public static final String                                INIT_DATE                           = "1970-1-1";
    public static final String                                INIT_DATETIME                       = "1970-1-1 00:00:00";

    public static final String                                ZERO_DATE_PATTERN                   = "yyyyMMdd000000";

    /** 锁对象 */
    private static final Object                               lockObj                             = new Object();

    /** 存放不同的日期模板格式的线程安全Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> threadLocalMap                      = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    //    public static Date parseString(String dateString) {
    //        try {
    //            return org.apache.commons.lang.time.DateUtils.parseDate(dateString,
    //                    new String[] { "yyyyMMddHHmm", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd HH:mm:ss",
    //                            "yyyy-MM-dd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd hh:mm:ss", "yyyyMMdd" });
    //        } catch (Exception exp) {
    //            LOGGER.error(exp.getMessage(), exp);
    //            return null;
    //        }
    //    }

    /** ###### parse 日期类型转换 ###### */
    public static Date parseEnDate(String sDate) {
        return parseThread(sDate, EN_DATE_PATTERN);
    }

    public static Date parseEnHmsDate(String sDate) {
        return parseThread(sDate, EN_DATETIME_PATTERN);
    }

    public static Date parseZhDate(String sDate) {
        return parseThread(sDate, ZH_DATE_PATTERN);
    }

    public static Date parseZhHmsDate(String sDate) {
        return parseThread(sDate, ZH_DATETIME_PATTERN);
    }

    public static Date parseCnDate(String sDate) {
        return parseThread(sDate, CN_DATE_PATTERN);
    }

    public static Date parseCnHmsDate(String sDate) {
        return parseThread(sDate, CN_DATETIME_PATTERN);
    }

    public static Date parseNomDate(String sDate) {
        return parseThread(sDate, NOMARK_DATE_PATTERN);
    }

    public static Date parseNomHmsDate(String sDate) {
        return parseThread(sDate, NOMARK_DATETIME_PATTERN);
    }

    public static Date parseRiDate(String sDate) {
        return parseThread(sDate, YYYY_NIAN_MM_YUE_DD_RI);
    }

    public static Date parseRiHmsDate(String sDate) {
        return parseThread(sDate, YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS);
    }

    public static Date parseZeroDate(String sDate) {
        return parseThread(sDate, ZERO_DATE_PATTERN);
    }

    /** ###### format 日期格式化 ###### */
    public static String formatEnDate(Date sDate) {
        return formatThread(sDate, EN_DATE_PATTERN);
    }

    public static String formatEnHmsDate(Date sDate) {
        return formatThread(sDate, EN_DATETIME_PATTERN);
    }

    public static String formatZhDate(Date sDate) {
        return formatThread(sDate, ZH_DATE_PATTERN);
    }

    public static String formatZhHmsDate(Date sDate) {
        return formatThread(sDate, ZH_DATETIME_PATTERN);
    }

    public static String formatCnDate(Date sDate) {
        return formatThread(sDate, CN_DATE_PATTERN);
    }

    public static String formatCnHmsDate(Date sDate) {
        return formatThread(sDate, CN_DATETIME_PATTERN);
    }

    public static String formatNomDate(Date sDate) {
        return formatThread(sDate, NOMARK_DATE_PATTERN);
    }

    public static String formatNomHmsDate(Date sDate) {
        return formatThread(sDate, NOMARK_DATETIME_PATTERN);
    }

    public static String formatRiDate(Date sDate) {
        return formatThread(sDate, YYYY_NIAN_MM_YUE_DD_RI);
    }

    public static String formatRiHmsDate(Date sDate) {
        return formatThread(sDate, YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS);
    }

    public static String formatZeroDate(Date sDate) {
        return formatThread(sDate, ZERO_DATE_PATTERN);
    }

    /**
     * 返回一个ThreadLocal的DateFormat,每个线程只会new一次DateFormat
     * 
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getThreadDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = threadLocalMap.get(pattern);
        // 此处的双重判断和同步是为了防止threadLocalMap这个单例被多次put重复的DateFormat
        if (tl == null) {
            synchronized (lockObj) {
                tl = threadLocalMap.get(pattern);
                // 新增的pattern生成新的DateFormat并放入map
                if (tl == null) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    threadLocalMap.put(pattern, tl);
                }
            }
        }
        return tl.get();
    }

    /**
     * 获取String类型时间<br>
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static String formatThread(Date date, String pattern) {
        if (date == null)
            return null;
        return getThreadDateFormat(pattern).format(date);
    }

    /**
     * 获取Date类型时间<br>
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static Date parseThread(String dateStr, String pattern) {
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                return getThreadDateFormat(pattern).parse(dateStr);
            } catch (ParseException e) {
                LOGGER.warn(e.getMessage(), e);
                return null;
            }
        }
        return null;
    }

    /**
     * 日期转换成字符串
     * 
     * @param date
     * @param formatPattern
     * @return
     */
    public static String dateToString(Date date, String formatPattern) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        return format.format(date);
    }

    /**
     * 字符串转换日期
     * 
     * @param str
     * @return
     */
    public static Date stringToDate(String str, String formatPattern) {
        SimpleDateFormat format = new SimpleDateFormat(formatPattern);
        if (str != null && !str.equals("")) {
            try {
                return format.parse(str);
            } catch (ParseException e) {
                LOGGER.warn("Exception log", e);
            }
        }
        return null;
    }

    /**
     * 计算间隔分钟
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getIntervaLMinute(Date startDate, Date endDate) {
        long startdate = startDate.getTime();
        long enddate = endDate.getTime();
        long interval = enddate - startdate;
        if (interval < 0) {
            interval = -interval;
        }
        int intervalMinute = (int) Math.ceil(interval / (1000.0 * 60));
        if ((enddate - startdate) < 0) {
            intervalMinute = -intervalMinute;
        }
        return intervalMinute;
    }

    /**
     * 根据生日和传入的日期计算改时间的年龄
     * 
     * @param birthDay
     * @param date
     * @return
     */
    public static int getAge(Date birthDay, Date date) {
        int iAge = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int iCurrYear = cal.get(Calendar.YEAR);
        int sCurrMonth = cal.get(Calendar.MONTH);
        int sCurrDay = cal.get(Calendar.DATE);
        cal.setTime(birthDay);
        int iBirthYear = cal.get(Calendar.YEAR);
        int sBirthMonth = cal.get(Calendar.MONTH);
        int sBirthDay = cal.get(Calendar.DATE);
        iAge = iCurrYear - iBirthYear;

        if (sCurrMonth < sBirthMonth || sCurrMonth == sBirthMonth && sCurrDay < sBirthDay) {
            iAge = iAge - 1;
        }
        return iAge;
    }
}
