package com.example.bank.common;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 响应
 */
public class R extends JSONObject implements Serializable {

    public static R success() {
        return success(null);
    }

    public static R success(Object data) {
        R r = new R();
        r.put("result", 0);
        r.put("msg", "");
        r.put("data", data);
        return r;
    }

    public static R failed(String errorMsg) {
        R r = new R();
        r.put("result", 1);
        r.put("msg", errorMsg);
        r.put("data", null);
        return r;
    }

}
