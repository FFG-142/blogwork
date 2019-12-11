package com.scs.web.blog.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author jh_wu
 * @ClassName ArticleAddDto
 * @Description TODO
 * @Date 2019/12/5:11:05
 * @Version 1.0
 **/
@Data
public class ArticleAddDto implements Serializable {
    private Long userId;
    private String title;
    private String summary;
    private String content;
    private LocalDateTime createTime;
}
