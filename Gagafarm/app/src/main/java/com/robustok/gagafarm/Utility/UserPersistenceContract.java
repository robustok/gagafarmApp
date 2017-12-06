package com.robustok.gagafarm.Utility;

/**
 * Created by Administrator on 2017/9/6.
 * 为存储用户数据提供一致性的协议
 */

public final class UserPersistenceContract {
    private UserPersistenceContract(){};

    public static abstract class UserEntry {
        public static final String TABLE_NAME = "userLogin";

        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_PASSWORD = "password";
    }
}
