package com.spring3.common.entity;

import lombok.Data;

@Data
public class LTree {
    private String path;

    public LTree(String path) {
        this.path = path;
    }
}
