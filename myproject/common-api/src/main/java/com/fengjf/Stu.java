package com.fengjf;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author fengjf
 * @Desc 测试
 **/
@Data
@Accessors(chain = true)
public class Stu implements Serializable {
    private static final long serialVersionUID = 2381168892838143467L;
    private int id;
    private String name;
    private int age;
}
