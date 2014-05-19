package org.jbrat.managers;

import org.jbrat.managers.abstracts.JResourceFetcher;
import org.jbrat.models.CacheModel;
import org.jbrat.models.abstracts.JModel;

public class SingletonModelFetcher implements JResourceFetcher<String,JModel> {

    private CacheModel<JModel> modelModel = new CacheModel<JModel>();

    @Override
    public JModel fetchResourceByKey(String stringKey) {
        if(modelModel.contains(stringKey)){
            return getClassWhenExistByKey(stringKey);
        }else{
            return getClassWhenNotExistByKey(stringKey);
        }
    }
    private JModel getClassWhenExistByKey(String stringKey){
        return modelModel.get(stringKey);
    }
    private JModel getClassWhenNotExistByKey(String stringKey){

        JModel model = (JModel) JReflecter.reflectByPackageName(stringKey);

        modelModel.set(stringKey, model);

        return model;
    }


    @Override
    public void pruneResourceByKey(String stringKey) {
        modelModel.remove(stringKey);
    }
}
