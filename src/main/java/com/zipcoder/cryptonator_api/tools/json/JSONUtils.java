package com.zipcoder.cryptonator_api.tools.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class JSONUtils {
    public static JSONObject parse(Object jsonObject) {
        try {
            return (JSONObject) new JSONParser().parse(jsonObject.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<JSONObject> parseArray(Object jsonArray) {
        List<JSONObject> listdata = new ArrayList<>();
        JSONArray jArray = new JSONArray();

        try {
            jArray = (JSONArray) jsonArray;
        } catch(Exception cce) {
            jArray = new JSONArray((Collection) jsonArray);
        }

        for (int i = 0; i < jArray.length(); i++) {
            try {
                String jsonString = jArray.getString(i);
                System.out.println(jsonString);
                JSONObject jsonObject = JSONUtils.parse(jsonString);
                listdata.add(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return listdata;
    }

    public static String toString(Object o) {
        try {
            return new ObjectMapper().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
