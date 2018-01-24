package com.zipcoder.cryptonator_api.tools.json;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 1/23/18.
 */
public class LSONArray<T> implements Iterable<LSON<T>> {
    List<LSON<T>> listdata = new ArrayList<>();

    public LSONArray(String JSONArrayObject) {
        this(JSONUtils.parseArray(JSONArrayObject));
    }

    public LSONArray(List<JSONObject> jsonObjects) {
        listdata.stream().forEach(json -> listdata.add(json));
    }

    public void add(T t) {
        this.add(new LSON<T>(t));
    }

    public void add(LSON<T> t) {
        listdata.add(t);
    }

    public void remove(T t) {
        listdata.add(new LSON<T>(t));
    }

    public void remove(int index) {
        listdata.remove(index);
    }

    public LSON<T> get(int index) {
        return listdata.get(index);
    }

    public void clear() {
        listdata.clear();
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        listdata.stream().forEach(lson -> list.add(lson.get()));
        return list;
    }

    public Stream<LSON<T>> d() {
        return listdata.stream();
    }

    @Override
    public Iterator<LSON<T>> iterator() {
        return listdata.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        listdata.stream().forEach(lson -> sb.append(lson.toString()));
        return sb.toString();
    }
}
