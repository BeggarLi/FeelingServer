package com.li.feeling.util;

import org.springframework.lang.Nullable;

/**
 * description:
 */
public class StringUtil {

    public static boolean isEmpty(@Nullable String str) {
        return str == null || str.isEmpty();
    }
}
