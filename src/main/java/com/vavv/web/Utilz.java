package com.vavv.web;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class Utilz implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JWT_SUB = "krUserJwt";
    public static final String JWT_USER_PROP = "userData";
    public static final String JWT_USER_ROLE_PROP = "role";
    public static final String JWT_USER_GUID_PROP = "guid";
    public static final long JWT_EXPIRATION_TIME = 86400000L; // 1 day

    public static final String BAD_CREDENTIALS = "Bad username or password";

    public static final Map<Integer, String> CRON_JOB_PARAM_TYPE_VALS_MAP = new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, "Date");
        }
    };

}
