package com.leogao.any.common;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Date;
import java.util.Enumeration;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MacAddressTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MacAddressTest.class);

    public static void main(String[] args) throws Exception {
        String msTime = FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        System.out.println("msTime: " + msTime);

        String macAddress = getMacAddress();
        System.out.println("macAddress: " + macAddress);
    }

    private static String getMacAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            if (null == networkInterface) {
                continue;
            }
            byte[] macBytes = networkInterface.getHardwareAddress();
            if (networkInterface.isUp() && !networkInterface.isLoopback() && null != macBytes && macBytes.length == 6) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0, nLen = macBytes.length; i < nLen; i++) {
                    byte b = macBytes[i];
                    sb.append(Integer.toHexString((b & 240) >> 4));
                    sb.append(Integer.toHexString(b & 15));
                    if (i < nLen - 1) {
                        sb.append("-");
                    }
                }
                return sb.toString().toUpperCase();
            }
        }
        return null;
    }
}
