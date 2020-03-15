package com.johar.commonlib;

import lombok.*;

/**
 * @ClassName: BaseResultWithPage
 * @Description: TODO
 * @Author: Johar
 * @Date: 2020/3/15 22:25
 * @Version: 1.0
 */
@Getter
@Setter
@ToString(callSuper = true)
public class BaseResultWithPage<T> extends BaseResult<T> {
    private long totalNum;
    private int pageNo;
    private int pageSize;
    public BaseResultWithPage(){
        super();
    }

    public BaseResultWithPage(int code, String message, T data) {
        super(code, message, data);
    }

    public BaseResultWithPage(int code, String message, T data, long totalNum, int pageNo, int pageSize){
        super(code, message, data);
        this.totalNum = totalNum;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
