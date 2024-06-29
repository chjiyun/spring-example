package com.spring3.common.api;

import com.spring3.common.constant.Constant;

import java.util.List;

public class ForestNodeMerger {

    public static <T extends INode> List<T> merge(List<T> items) {
        ForestNodeManager<T> forestNodeManager = new ForestNodeManager<>(items);
        items.forEach(forestNode -> {
            if (!Constant.TREE_ROOT_ID.equals(forestNode.getParentId())) {
                INode node = forestNodeManager.getTreeNodeAT(forestNode.getParentId());
                if (node != null) {
                    node.getChildren().add(forestNode);
                } else {
                    forestNodeManager.addParentId(forestNode.getId());
                }
            }
        });
        return forestNodeManager.getRoot();
    }

}
