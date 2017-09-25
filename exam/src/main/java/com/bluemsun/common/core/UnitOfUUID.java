package com.bluemsun.common.core;

import java.util.UUID;

/**
 * @Description: UUID生成字符串主键
 * @author: Dongsl161
 * @Date: 2017/8/16 14:59
 */
public class UnitOfUUID {

    public static String IdOfUUID() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }


}
