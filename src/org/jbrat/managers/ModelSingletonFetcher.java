package org.jbrat.managers;

import org.jbrat.models.abstracts.JModel;
import org.jbrat.models.unlimited.CacheModel;

public class ModelSingletonFetcher extends JModel<JModel> {

    private final CacheModel<JModel> modelModel = new CacheModel<JModel>();

    @Override
    protected JModel getter(String name) {
        if(modelModel.contains(name)){
            return getClassWhenExistByKey(name);
        }else{
            return getClassWhenNotExistByKey(name);
        }
    }
    private JModel getClassWhenExistByKey(String stringKey){
        return modelModel.get(stringKey);
    }
    private JModel getClassWhenNotExistByKey(String stringKey){
        JModel model = Reflecter.reflectModel(stringKey);
        modelModel.set(stringKey, model);
        return model;
    }


    @Override
    protected void setter(String name, JModel data) {
        modelModel.remove(name);
    }

}
