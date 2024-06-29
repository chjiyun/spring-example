package com.spring3.common.util.id;

import com.github.yitter.idgen.YitIdHelper;

/**
 * @author lijiyun
 * @date 2024/06/10 19:56
 */
public class SnowIdUtil {

    public static String nextId() {
        long id = YitIdHelper.nextId();
        return String.valueOf(id);
    }
}
