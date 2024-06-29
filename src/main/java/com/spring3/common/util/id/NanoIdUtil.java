package com.spring3.common.util.id;

import cn.hutool.core.lang.id.NanoId;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author lijiyun
 * @date 2023年01月11日 09:53
 */
public class NanoIdUtil {
    private static final Random RANDOM = new SecureRandom();
    private static final char[] ALPHABET = "_0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int SIZE = 20;

    public static String getId() {
        return NanoId.randomNanoId(RANDOM, ALPHABET, SIZE);
    }
}
