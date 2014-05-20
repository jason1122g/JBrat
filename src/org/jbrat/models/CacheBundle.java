package org.jbrat.models;


import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;

import java.util.Map;
import java.util.TreeMap;

public class CacheBundle implements JBundle{

    private final Map<String,JModel>  modelModel = new TreeMap<String, JModel>();
    private final Map<String,Boolean> statusModel= new TreeMap<String, Boolean>();

    @Override
    @SuppressWarnings("unchecked")
    public JModel<String> getStringModel(String name) {
        return (JModel<String>) modelModel.get(name) ;
    }

    @Override
    @SuppressWarnings("unchecked")
    public<T> JModel<T> getModel(String name,Class<T> type){
        return (JModel<T>)type.cast(modelModel.get(name)) ;
    }

    @Override
    public void setModel(String name, JModel model) {
        modelModel.put(name, model);
    }

    @Override
    public void setTrimable(String name, boolean trimStatus) {
        statusModel.put(name, trimStatus);
    }

    @Override
    public void trimModels() {
        for(Map.Entry<String,Boolean> entry:statusModel.entrySet()){
            String  name       = entry.getKey();
            Boolean needToTrim = entry.getValue();
            if(needToTrim){
                modelModel.remove(name);
            }
        }
    }
}
