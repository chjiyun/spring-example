package com.spring3.common.config.mybatis;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.github.yitter.idgen.YitIdHelper;
import com.spring3.common.util.id.NanoIdUtil;

/**
 * @author chjiyun
 */
public class CustomIdentifierGenerator implements IdentifierGenerator {

    @Override
    public Long nextId(Object entity) {
        return YitIdHelper.nextId();
    }

    @Override
    public String nextUUID(Object entity) {
        return NanoIdUtil.getId();
    }
}
