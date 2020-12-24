package com.qw.boot.examples.idempotent.util;

import java.lang.reflect.Method;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/23 6:10 下午
 * <br> Copyright (c) 2020/12/23 ZiYun Tech.
 */
@Component
public class IdempotentKeyUtil {
    /**
     * 对接口的参数进行处理生成固定key
     *
     * @param method
     * @param custArgsIndex
     * @param args
     * @return
     */
    public static String generate(Method method, int[] custArgsIndex, Object... args) {
        String stringBuilder = getKeyOriginalString(method, custArgsIndex, args);
        //进行md5等长加密
        return md5(stringBuilder.toString());
    }

    /**
     * 原生的key字符串。
     *
     * @param method
     * @param custArgsIndex
     * @param args
     * @return
     */
    public static String getKeyOriginalString(Method method, int[] custArgsIndex, Object[] args) {
        StringBuilder stringBuilder = new StringBuilder(method.toString());
        int i = 0;
        for (Object arg : args) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                /* ServletRequest不能序列化，从入参里排除，否则报异常：java.lang.IllegalStateException: It is illegal to call this method if the current request is not in asynchronous mode (i.e. isAsyncStarted() returns false)
                ServletResponse不能序列化 从入参里排除，否则报异常：java.lang.IllegalStateException: getOutputStream() has already been called for this response */
                continue;
            }

            if (isIncludeArgIndex(custArgsIndex, i)) {
//                System.out.println("arg---------->"+arg);
                stringBuilder.append(toString(arg));
            }
            i++;
        }
        return stringBuilder.toString();
    }

    /**
     * 判断当前参数是否包含在注解中的自定义序列当中。
     *
     * @param custArgsIndex
     * @param i
     * @return
     */
    private static boolean isIncludeArgIndex(int[] custArgsIndex, int i) {
        //如果没自定义作为key的参数index序号，直接返回true，意味加入到生成key的序列
        if (custArgsIndex.length == 0) {
            return true;
        }

        boolean includeIndex = false;
        for (int argsIndex : custArgsIndex) {
            if (argsIndex == i) {
                includeIndex = true;
                break;
            }
        }
        return includeIndex;
    }

    /**
     * 使用jsonObject对数据进行toString,(保持数据一致性)
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "-";
        }
        return JSON.toJSONString(obj);
    }

    /**
     * 对数据进行MD5等长加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //选择MD5作为加密方式
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(str.getBytes());
            byte b[] = mDigest.digest();
            int j = 0;
            for (int i = 0, max = b.length; i < max; i++) {
                j = b[i];
                if (j < 0) {
                    i += 256;
                } else if (j < 16) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(Integer.toHexString(j));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}