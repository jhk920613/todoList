package com.chklab.logic.util;

import com.google.gson.Gson;

public class GsonUtil {

    private static final Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

}
