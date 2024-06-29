package com.spring3.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.spring3.common.context.UserContextHolder;
import com.spring3.common.entity.BaseEntity;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DefaultDBFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
            LocalDateTime current = LocalDateTime.now();
            if (Objects.isNull(baseEntity.getCreateDate())) {
                baseEntity.setCreateDate(current);
            }

            if (Objects.isNull(baseEntity.getUpdateDate())) {
                baseEntity.setUpdateDate(current);
            }

            String userId = UserContextHolder.getUserId();

            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getCreateBy())) {
                baseEntity.setCreateBy(userId);
            }

            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdateBy())) {
                baseEntity.setUpdateBy(userId);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity baseEntity) {
            LocalDateTime current = LocalDateTime.now();

            if (Objects.isNull(baseEntity.getUpdateDate())) {
                baseEntity.setUpdateDate(current);
            }

            String userId = UserContextHolder.getUserId();

            if (Objects.nonNull(userId) && Objects.isNull(baseEntity.getUpdateBy())) {
                baseEntity.setUpdateBy(userId);
            }
        }
    }
}
