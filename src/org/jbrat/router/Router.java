package org.jbrat.router;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.CacheBundle;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.router.data.abstracts.JAttribute;
import org.jbrat.router.data.abstracts.JControllerAttribute;
import org.jbrat.router.data.abstracts.JModelAttribute;
import org.jbrat.router.data.abstracts.JViewAttribute;
import org.jbrat.views.abstracts.JView;

import java.util.HashMap;
import java.util.Map;

public class Router implements JRouteFile {

    private JAttribute attribute;
    private Map<String,JModel> modelMap;

    public Router(JAttribute attribute){
        this.attribute = attribute;
        this.modelMap  = new HashMap<String, JModel>();
    }

    @Override
    public JBundle getBundle(String viewName) {
        //TODO REFLECT INIT BUNDLE FROM ATTRIBUTES AND TRIM

        JBundle bundle;

        bundle = getBundleOfControllerByViewName(viewName);

        JControllerAttribute controllerAttribute = getControllerAttributeByViewName(viewName);
        String controllerPackage = controllerAttribute.getControllerPackage();
        JCombiner controller = (JCombiner) reflectByPackageName(controllerPackage);

        controller.onPreparing(bundle);

        bundle.trimModels();

        return bundle;
    }
    private JBundle getBundleOfControllerByViewName(String viewName){

        JBundle bundle = new CacheBundle();

        for(JModelAttribute modelAttribute : getModelAttributesByViewName(viewName)){

            String modelName    = modelAttribute.getModelName();
            String modelPackage = modelAttribute.getModelPackage();
            boolean isTrimable     = modelAttribute.needTrim();
            boolean isDuplicatable = modelAttribute.needDuplicate();

            JModel model;

            if(isDuplicatable){
                model =(JModel) reflectByPackageName(modelPackage);
            }else{
                if(modelMap.containsKey(modelName)){
                    model = modelMap.get(modelName);
                }else{
                    model =(JModel) reflectByPackageName(modelPackage);
                    modelMap.put(modelName,model);
                }
            }
            bundle.setModel(modelName,model);
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
    private Object reflectByPackageName(String packageName){
        Object object = null;
        try {
            object = Class.forName(packageName).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }


    @Override
    public JView getView(String viewName) {
        return (JView) reflectByPackageName(  getViewPackageByViewName(viewName)  );
    }
    private String getViewPackageByViewName(String viewName){
        JViewAttribute viewAttribute = attribute.getViewAttribute(viewName);
        return viewAttribute.getViewPackage();
    }
}
