package com.zipcoder.cryptonator_api.tools.json;

import org.json.simple.JSONObject;

/**
 * Created by leon on 1/23/18.
 */
public class LSON<T> {
    private final T value;
    private final JSONObject jsonObject;

    public LSON(T object) {
        this.value = object;
        this.jsonObject = JSONUtils.parse(object.toString());
    }

    public T get() {
        return value;
    }

    public JSONObject toJSONObject() {
        return jsonObject;
    }

    @Override
    public String toString() {
        return toJSONObject().toJSONString();
    }
}
