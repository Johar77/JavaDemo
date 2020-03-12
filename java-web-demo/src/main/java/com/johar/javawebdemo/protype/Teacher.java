package com.johar.javawebdemo.protype;

import com.sun.corba.se.impl.orb.ParserTable;
import lombok.Data;

/**
 * @ClassName: Teacher
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/1/1 18:22
 * @Version: 1.0
 */
@Data
public class Teacher implements Cloneable {
    private String name;

    @Override
    protected Teacher clone() throws CloneNotSupportedException {
        return (Teacher) super.clone();
    }
}
