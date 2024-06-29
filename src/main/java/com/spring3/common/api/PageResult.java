package com.spring3.common.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Schema(description = "分页结果")
public class PageResult<T> implements Serializable {

    @Schema(description = "结果数据", required = true)
    private List<T> list;

    @Schema(description = "分页信息", required = true)
    private Pagination pagination;

    public PageResult() {
    }

    public PageResult(Page<T> page) {
        this.list = page.getRecords();
        this.pagination = new Pagination();
        this.pagination.setCurrent(page.getCurrent());
        this.pagination.setPageSize(page.getSize());
        this.pagination.setTotalPage(page.getPages());
        this.pagination.setTotal(page.getTotal());
    }
}
