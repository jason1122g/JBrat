package org.jbrat.managers;


import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;
import org.jbrat.models.unlimited.CacheModel;



public final class JBratManager{//TODO FINISH THIS MANAGER

    private final static CacheModel<JBratManager> jBratManagerCacheModel = new CacheModel<JBratManager>();

    private CacheModel<JModelAttribute>    modelAttributeCacheModel;
    private CacheModel<JViewAttribute>     viewAttributeCacheModel ;
    private CacheModel<JCombinerAttribute> combinerAttributeCacheModel;

    private JBratManager(){
        modelAttributeCacheModel    = new CacheModel<JModelAttribute>();
        viewAttributeCacheModel     = new CacheModel<JViewAttribute>();
        combinerAttributeCacheModel = new CacheModel<JCombinerAttribute>();
    }

    public void loadAttrModel    (String fileName){
        JModelAttribute modelAttribute = JBratFileReader.readModelAttribute(fileName);
        modelAttributeCacheModel.set(modelAttribute.getName(), modelAttribute);
    }

    public void loadAttrView     (String fileName){
        JViewAttribute viewAttribute   = JBratFileReader.readViewAttribute(fileName);
        viewAttributeCacheModel.set(viewAttribute.getName(), viewAttribute);
    }

    public void loadAttrCombiner (String fileName){
        JCombinerAttribute combinerAttribute = JBratFileReader.readCombinerAttribute(fileName);
        combinerAttributeCacheModel.set(combinerAttribute.getName(), combinerAttribute);
    }

    public void createViewResource (String viewName, Object...objects){
        JViewAttribute     viewAttribute     = prepareViewAttrWithViewName(viewName);
        JCombinerAttribute combinerAttribute = prepareCombinerAttrWithViewAttr(viewAttribute);
        JModelAttribute[]  modelAttributes   = prepareModelAttrsWithCombinerAttr(combinerAttribute);


    }
    private JViewAttribute prepareViewAttrWithViewName(String viewName){
        return viewAttributeCacheModel.get(viewName);
    }
    private JCombinerAttribute prepareCombinerAttrWithViewAttr(JViewAttribute viewAttribute){
        String combinerName = viewAttribute.getCombinerName();
        return combinerAttributeCacheModel.get(combinerName);
    }
    private JModelAttribute[]  prepareModelAttrsWithCombinerAttr (JCombinerAttribute combinerAttribute){
        String[]           modelNames        = combinerAttribute.getModelNames();
        JModelAttribute[]  modelAttributes   = new JModelAttribute[modelNames.length];
        for(int i=0;i<modelAttributes.length;i++){
            modelAttributes[i] = modelAttributeCacheModel.get(modelNames[i]);
        }
        return modelAttributes;
    }



    public static JBratManager createInstance(String name){
        JBratManager jBratManager = new JBratManager();
        jBratManagerCacheModel.set(name, jBratManager);
        return jBratManager;
    }
}
