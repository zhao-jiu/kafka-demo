package com.zj.study.kafkademo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 赵赳
 * @since 2021/8/10 17:56
 */
@Data
@Accessors(chain = true)
public class User {

    private String id;

    private String username;

    private String state;

}
