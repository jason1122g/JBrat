package org.jbrat.managers;


import org.jbrat.combiners.JCombiner;
import org.jbrat.exceptions.*;
import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JSettingAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.models.unlimited.CacheBundle;
import org.jbrat.models.unlimited.CacheModel;
import org.jbrat.views.abstracts.JView;

import java.io.IOException;

public final class JBratManager{

    private final static CacheModel<JBratManager> jBratManagerCacheModel = new CacheModel<>();

    private CacheModel<JModelAttribute>    modelAttributeCacheModel;
    private CacheModel<JViewAttribute>     viewAttributeCacheModel ;
    private CacheModel<JCombinerAttribute> combinerAttributeCacheModel;

    private JBratModelFactory modelFactory;

    private JBratManager(){
        modelAttributeCacheModel    = new CacheModel<>();
        viewAttributeCacheModel     = new CacheModel<>();
        combinerAttributeCacheModel = new CacheModel<>();

        modelFactory = new JBratModelFactory();
    }

    public void readSetting(String fileName)  throws IOException,AttributeFormatException{
        loadSetting(JBratFileReader.readFullFile(fileName));
    }

    public void loadSetting(String settingJSON) throws AttributeFormatException{
        JSettingAttribute settingAttribute = JBratParser.parseSetting(settingJSON);
        loadViewSetting(settingAttribute);
        loadCombinerSetting(settingAttribute);
        loadModelSetting(settingAttribute);
    }
    private void loadModelSetting(JSettingAttribute settingAttribute){
        for(JModelAttribute modelAttribute : settingAttribute.getModelAttributes()){
            modelAttributeCacheModel.set(modelAttribute.getName(), modelAttribute);
        }
    }
    private void loadViewSetting(JSettingAttribute settingAttribute){
        for(JViewAttribute viewAttribute : settingAttribute.getViewAttributes()){
            viewAttributeCacheModel.set(viewAttribute.getName(), viewAttribute);
        }
    }
    private void loadCombinerSetting(JSettingAttribute settingAttribute){
        for(JCombinerAttribute combinerAttribute : settingAttribute.getCombinerAttributes()){
            combinerAttributeCacheModel.set(combinerAttribute.getName(), combinerAttribute);
        }
    }


    public void createView(String viewName, Object... objects) throws ReflectiveOperationException{
        JViewAttribute     viewAttribute    ;
        JCombinerAttribute combinerAttribute;
        JModelAttribute[]  modelAttributes  ;
        JBundle bundle = new CacheBundle();

        viewAttribute     = prepareViewAttrWithViewName(viewName);
        if(!viewAttribute.getCombinerName().equals("")){
            combinerAttribute = prepareCombinerAttrWithViewAttr(viewAttribute);
            if(combinerAttribute.getModelNames() != null){
                modelAttributes   = prepareModelAttrsWithCombinerAttr(combinerAttribute);
                buildBundleWithModelAttrs(bundle, modelAttributes);
            }
            buildBundleWithCombinerAttr(bundle, combinerAttribute);
        }
        injectItemIntoBundle(bundle);
        buildView(viewAttribute,bundle,objects);

    }

    private JViewAttribute     prepareViewAttrWithViewName(String viewName){
        if(viewAttributeCacheModel.contains(viewName)){
            return viewAttributeCacheModel.get(viewName);
        }else {
            throw new ViewNotLoadException(viewName);
        }
    }

    private JCombinerAttribute prepareCombinerAttrWithViewAttr(JViewAttribute viewAttribute){
        String combinerName = viewAttribute.getCombinerName();
        if(combinerAttributeCacheModel.contains(combinerName)){
            return combinerAttributeCacheModel.get(combinerName);
        }else{
            throw new CombinerNotLoadException(combinerName);
        }
    }

    private JModelAttribute[]  prepareModelAttrsWithCombinerAttr (JCombinerAttribute combinerAttribute){
        String[]           modelNames       = combinerAttribute.getModelNames();
        boolean[]          modelPersists    = combinerAttribute.getModelPersists();
        JModelAttribute[]  modelAttributes  = new JModelAttribute[modelNames.length];

        for(int i=0;i<modelAttributes.length;i++){
            String  modelName   = modelNames[i];
            boolean modelPersit = modelPersists[i];
            if(modelAttributeCacheModel.contains(modelName)){
                modelAttributes[i] = modelAttributeCacheModel.get(modelName);
                modelAttributes[i].setPersistant(modelPersit);
            }else{
                throw new ModelNotLoadException(modelName);
            }
        }
        return modelAttributes;
    }

    private void buildBundleWithModelAttrs(JBundle bundle, JModelAttribute[] modelAttributes) throws ReflectiveOperationException{
        JModel[] models = prepareModelsWithModelAttrs(modelAttributes);
        for(int i=0;i<modelAttributes.length;i++){
            String modelName = modelAttributes[i].getName();
            JModel model     = models[i];
            bundle.setModel(modelName,model);
        }
    }

    private JModel[] prepareModelsWithModelAttrs(JModelAttribute[] modelAttributes) throws ReflectiveOperationException{
        JModel[] models = new JModel[modelAttributes.length];
        for(int i=0;i<modelAttributes.length;i++){
            String modelPackageName = modelAttributes[i].getPackage();
            if(modelAttributes[i].isPersistant()){
                models[i] = modelFactory.getOldModel(modelPackageName);
            }else{
                models[i] = modelFactory.getNewModel(modelPackageName);
            }
        }
        return models;
    }

    private void buildBundleWithCombinerAttr(JBundle bundle, JCombinerAttribute combinerAttribute) throws ReflectiveOperationException{
        JCombiner combiner = JBratReflecter.reflectCombiner(combinerAttribute.getPackage());
        combiner.onPreparing(bundle);
    }

    private void injectItemIntoBundle(JBundle bundle){
        bundle.setModel(JBratConstants.managerModelName,jBratManagerCacheModel);
    }

    private void buildView(JViewAttribute viewAttribute,JBundle bundle,Object...objects) throws ReflectiveOperationException{
        JView view         = JBratReflecter.reflectView(viewAttribute.getPackage(),objects);
        view.onCreating((JLimitBundle)bundle);
    }


    public static JBratManager createInstance(String name){
        if(jBratManagerCacheModel.contains(name)){
            throw new KeyDuplicateException(name);
        }

        JBratManager jBratManager = new JBratManager();
        jBratManagerCacheModel.set(name, jBratManager);
        return jBratManager;
    }
}
