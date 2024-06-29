package com.spring3.common.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "分页信息")
@Data
public class Pagination implements Serializable {

    @Schema(description = "每页条数", required = true)
    private Long pageSize;

    @Schema(description = "当前页数", required = true)
    private Long current;

    @Schema(description = "总条数", required = true)
    private Long total;

    @Schema(description = "总页数", required = true)
    private Long totalPage;
}
