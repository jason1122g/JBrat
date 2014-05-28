package org.jbrat.models.unlimited;

import org.jbrat.models.abstracts.JModel;
import org.jbrat.models.limited.LCacheModel;

import java.util.HashMap;
import java.util.Map;

public class CacheModel<Type> extends JModel<Type> implements LCacheModel<Type>{

    private final Map<String,Type> dataMap ;

    public CacheModel(){
        dataMap = new HashMap<String, Type>();
    }

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
