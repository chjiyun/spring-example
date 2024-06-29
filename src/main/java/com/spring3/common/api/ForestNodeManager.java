package com.spring3.common.api;


import com.spring3.common.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 森林管理类
 */
public class ForestNodeManager<T extends INode> {

    /**
     * 森林的所有节点
     */
    private List<T> list;

    /**
     * 森林的父节点ID
     */
    private List<String> parentIds = new ArrayList<>();

    public ForestNodeManager(List<T> items) {
        list = items;
    }

    /**
     * 根据节点ID获取一个节点
     *
     * @param id 节点ID
     * @return 对应的节点对象
     */
    public INode getTreeNodeAT(String id) {
        for (INode forestNode : list) {
            if (forestNode.getId().equals(id)) {
                return forestNode;
            }
        }
        return null;
    }

    /**
     * 增加父节点ID
     *
     */
    public void addParentId(String parentId) {
        parentIds.add(parentId);
    }

    /**
     * 获取树的根节点(一个森林对应多颗树)
     *
     * @return 树的根节点集合
     */
    public List<T> getRoot() {
        List<T> roots = new ArrayList<>();
        for (T forestNode : list) {
            if (Constant.TREE_ROOT_ID.equals(forestNode.getParentId()) || parentIds.contains(forestNode.getId())) {
                roots.add(forestNode);
            }
        }
        return roots;
    }

}
