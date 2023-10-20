package com.bupt.eights.utils;

import cn.hutool.core.util.StrUtil;

public class RegexUtils {
    /** 是否是无效手机号
     *
     */
    public static boolean isPhoneInvalid(String phone){
        return mismatch(phone,RegexPattern.PHONE_REGEX);
    }

    public static boolean mismatch(String phone, String regex){
        if(StrUtil.isBlank(phone)){
            return true;
        }
        return !phone.matches(regex);
    }

}
