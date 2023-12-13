package com.osfans.trime;

import java.lang.reflect.Method;


public class Utils {

    private static Method mGetStringPropMethod = null;

    public static boolean isBlank(String s){
        return s == null || s.isEmpty();
    }

    public static String getSystemPropString(final String key, final String defaultValue) {
        try {
            if (mGetStringPropMethod == null) {
                mGetStringPropMethod = Class.forName("android.os.SystemProperties")
                        .getMethod("get", String.class, String.class);
            }
            return (String) mGetStringPropMethod.invoke(null, key, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static long calcCost(long begTime){
        long endTime = System.currentTimeMillis();
        return endTime - begTime;
    }
}
