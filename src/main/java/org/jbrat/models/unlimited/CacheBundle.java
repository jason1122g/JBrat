package org.jbrat.models.unlimited;


import org.jbrat.managers.JBratConstants;
import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.abstracts.JModel;

import java.util.Map;
import java.util.TreeMap;

public class CacheBundle implements JBundle,JLimitBundle{

    private final Map<String,JModel>  modelModel;

    public CacheBundle(){
        modelModel = new TreeMap<String, JModel>();
    }

    @Override
    public StringModel getStringModel(String name) {
        return (StringModel) modelModel.get(name) ;
    }

    @Override
    public EventModel getEventModel(String name) {
        return (EventModel) modelModel.get(name) ;
    }

    @Override
    public IntegerModel getIntegerModel(String name) {
        return (IntegerModel) modelModel.get(name) ;
    }

    @Override
    public DoubleModel getDoubleModel(String name) {
        return (DoubleModel) modelModel.get(name) ;
    }

    @Override
    public LongModel getLongModel(String name) {
        return (LongModel) modelModel.get(name) ;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JBratManager getJBratManager(String name) {
        String modelName = JBratConstants.managerModelName;
        JModel<JBratManager> jBratModel = (JModel<JBratManager>) modelModel.get(modelName);
        return jBratModel.get(name);
    }

    @Override
    @SuppressWarnings("unchecked")
    public<T> JModel<T> getModel(String name){
        return modelModel.get(name);
    }

    @Override
    public void setModel(String name, JModel model) {
        modelModel.put(name, model);
    }
}