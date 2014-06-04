package org.jbrat.managers;


import org.jbrat.combiners.JCombiner;
import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.models.unlimited.CacheBundle;
import org.jbrat.models.unlimited.CacheModel;
import org.jbrat.views.abstracts.JView;



public final class JBratManager{

    private final static CacheModel<JBratManager> jBratManagerCacheModel = new CacheModel<JBratManager>();

    private CacheModel<JModelAttribute>    modelAttributeCacheModel;
    private CacheModel<JViewAttribute>     viewAttributeCacheModel ;
    private CacheModel<JCombinerAttribute> combinerAttributeCacheModel;

    private JBratModelFactory modelFactory;

    private JBratManager(){
        modelAttributeCacheModel    = new CacheModel<JModelAttribute>();
        viewAttributeCacheModel     = new CacheModel<JViewAttribute>();
        combinerAttributeCacheModel = new CacheModel<JCombinerAttribute>();

        modelFactory = new JBratModelFactory();
    }

    public void loadAttrModel    (String fileName){
        JModelAttribute[] modelAttributes = JBratFileReader.readModelAttributes(fileName);
        for(JModelAttribute modelAttribute:modelAttributes){
            modelAttributeCacheModel.set(modelAttribute.getName(), modelAttribute);
        }
    }

    public void loadAttrView     (String fileName){
        JViewAttribute[] viewAttributes   = JBratFileReader.readViewAttributes(fileName);
        for(JViewAttribute viewAttribute:viewAttributes){
            viewAttributeCacheModel.set(viewAttribute.getName(), viewAttribute);
        }
    }

    public void loadAttrCombiner (String fileName){
        JCombinerAttribute[] combinerAttributes = JBratFileReader.readCombinerAttributes(fileName);
        for( JCombinerAttribute combinerAttribute:combinerAttributes){
            combinerAttributeCacheModel.set(combinerAttribute.getName(), combinerAttribute);
        }
    }

    public void createViewResource (String viewName, Object...objects){
        JViewAttribute     viewAttribute     = prepareViewAttrWithViewName(viewName);
        JCombinerAttribute combinerAttribute = prepareCombinerAttrWithViewAttr(viewAttribute);
        JModelAttribute[]  modelAttributes   = prepareModelAttrsWithCombinerAttr(combinerAttribute);

        JBundle bundle = prepareBundleWithJModelAttrs(modelAttributes);

        JCombiner combiner = JBratReflecter.reflectCombiner(combinerAttribute.getPackage());
        combiner.onPreparing(bundle);

        injectItemIntoBundleAfterCombiner(bundle);

        JView view         = JBratReflecter.reflectView(viewAttribute.getPackage(),objects);
        view.onCreating((JLimitBundle)bundle);
    }
    private JViewAttribute     prepareViewAttrWithViewName(String viewName){
        return viewAttributeCacheModel.get(viewName);
    }
    private JCombinerAttribute prepareCombinerAttrWithViewAttr(JViewAttribute viewAttribute){
        String combinerName = viewAttribute.getCombinerName();
        return combinerAttributeCacheModel.get(combinerName);
    }
    private JModelAttribute[]  prepareModelAttrsWithCombinerAttr (JCombinerAttribute combinerAttribute){
        String[]           modelNames       = combinerAttribute.getModelNames();
        JModelAttribute[]  modelAttributes  = new JModelAttribute[modelNames.length];
        for(int i=0;i<modelAttributes.length;i++){
            modelAttributes[i] = modelAttributeCacheModel.get(modelNames[i]);
        }
        return modelAttributes;
    }

    private JBundle  prepareBundleWithJModelAttrs(JModelAttribute[] modelAttributes){
        JModel[] models = prepareModelsWithJModelAttrs(modelAttributes);
        JBundle bundle = new CacheBundle();
        for(int i=0;i<modelAttributes.length;i++){
            String modelName = modelAttributes[i].getName();
            JModel model     = models[i];
            bundle.setModel(modelName,model);
        }
        return bundle;
    }
    private JModel[] prepareModelsWithJModelAttrs(JModelAttribute[] modelAttributes){
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

    private void injectItemIntoBundleAfterCombiner(JBundle bundle){
        bundle.setModel("jbrat",jBratManagerCacheModel);
    }


    public static JBratManager createInstance(String name){
        JBratManager jBratManager = new JBratManager();
        jBratManagerCacheModel.set(name, jBratManager);
        return jBratManager;
    }
}
