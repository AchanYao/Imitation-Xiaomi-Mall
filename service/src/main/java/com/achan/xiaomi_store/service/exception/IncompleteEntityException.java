package com.achan.xiaomi_store.service.exception;

/**
 * 当试图向数据库中写入一个不完整实体时抛出该异常
 */
public class IncompleteEntityException extends StoreException {
    public IncompleteEntityException() {
        super();
    }

    public IncompleteEntityException(Object object) {
        super("不完整实体：" +  object.toString());
    }
}
