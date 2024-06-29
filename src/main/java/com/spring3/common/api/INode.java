package com.spring3.common.api;

import java.io.Serializable;
import java.util.List;

public interface INode extends Serializable {

    String getId();

    String getParentId();

    List<INode> getChildren();

    default Boolean getHasChildren() {
        return false;
    }

}
