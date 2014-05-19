package org.jbrat.files;

import org.jbrat.combiners.JCombiner;
import org.jbrat.files.abstracts.JBTInitiator;
import org.jbrat.managers.JReflecter;
import org.jbrat.managers.SingletonModelFetcher;
import org.jbrat.managers.abstracts.JResourceFetcher;
import org.jbrat.models.CacheBundle;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.files.data.abstracts.JAttribute;
import org.jbrat.files.data.abstracts.JControllerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;
import org.jbrat.views.abstracts.JView;

public class Initiator implements JBTInitiator {

    private JAttribute attribute;
    private JResourceFetcher<String,JModel> modelFetcher = new SingletonModelFetcher();
    //TODO  REMOVE RESOURCE FETCHER
    public Initiator(JAttribute attribute){
        this.attribute = attribute;
    }

    @Override
    public JBundle getBundle(String viewName) {
        //TODO REFLECT INIT BUNDLE FROM ATTRIBUTES AND TRIM

        String controllerPackage = getControllerAttributeByViewName(viewName).getControllerPackage();

        JCombiner controller =  JReflecter.reflectCombiner(controllerPackage);

        JBundle bundle = getBundleOfControllerByViewName(viewName);

        controller.onPreparing(bundle);

        bundle.trimModels();

        return bundle;
    }
    private JBundle getBundleOfControllerByViewName(String viewName){

        JBundle bundle = new CacheBundle();

        for(JModelAttribute modelAttribute : getModelAttributesByViewName(viewName)){

            String modelName    = modelAttribute.getModelName();
            boolean isTrimable  = modelAttribute.needTrim();

            bundle.setModel   (modelName, getModelByModelAttribute(modelAttribute) );
            bundle.setTrimable(modelName, isTrimable);

        }

        return bundle;
    }
    private JModelAttribute[] getModelAttributesByViewName(String viewName){
        return getControllerAttributeByViewName(viewName).getModelAttributes();
    }
    private JControllerAttribute getControllerAttributeByViewName(String viewName){
        return attribute.getViewAttribute(viewName).getControllerAttribute();
    }
    private JModel getModelByModelAttribute(JModelAttribute modelAttribute){

        JModel model;
        String modelPackage = modelAttribute.getModelPackage();
        boolean isDuplicatable = modelAttribute.needDuplicate();

        if(isDuplicatable){
            model = JReflecter.reflectModel(modelPackage);
        }else{
            model = modelFetcher.fetchResourceByKey(modelPackage);
        }

        return model;
    }


    @Override
    public JView getView(String viewName) {
        return JReflecter.reflectView(getViewPackageByViewName(viewName));
    }
    private String getViewPackageByViewName(String viewName){
        JViewAttribute viewAttribute = attribute.getViewAttribute(viewName);
        return viewAttribute.getViewPackage();
    }
}
