package org.jbrat.models;

import org.jbrat.models.abstracts.JModel;

import java.util.HashMap;
import java.util.Map;

public class CacheModel<Type> extends JModel<Type> {

    private Map<String,Type> dataMap = new HashMap<String, Type>();

    @Override
    protected Type getter(String name) {
        return dataMap.get(name);
    }

    @Override
    protected void setter(String name, Type data) {
        dataMap.put(name,data);
    }

    public void remove(String name){
        dataMap.remove(name);
    }

    public boolean contains(String name){
        return  dataMap.containsKey(name);
    }
}
