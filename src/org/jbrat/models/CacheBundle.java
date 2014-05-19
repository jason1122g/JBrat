package org.jbrat.models;


import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;

import java.util.Map;
import java.util.TreeMap;

public class CacheBundle implements JBundle{

    private Map<String,JModel>  modelModel = new TreeMap<String, JModel>();
    private Map<String,Boolean> statusModel= new TreeMap<String, Boolean>();

    @Override
    public JModel getModel(String name) {
        return modelModel.get(name);
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
