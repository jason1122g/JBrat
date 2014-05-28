package org.jbrat.managers;


import org.jbrat.files.data.abstracts.JCombinerAttribute;
import org.jbrat.files.data.abstracts.JModelAttribute;
import org.jbrat.files.data.abstracts.JViewAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class JBratManager{//TODO FINISH THIS MANAGER

    private final static Map<String,JBratManager> jBratManagerMap = new TreeMap<String, JBratManager>();

    private Map<String, JModelAttribute>    modelAttributeMap;
    private Map<String, JViewAttribute>     viewAttributeMap;
    private Map<String, JCombinerAttribute> combinerAttributeMap;

    private JBratManager(){
        modelAttributeMap    = new HashMap<String, JModelAttribute>();
        viewAttributeMap     = new HashMap<String, JViewAttribute>();
        combinerAttributeMap = new HashMap<String, JCombinerAttribute>();
    }

    public void loadAttrModel    (String fileName){
        JModelAttribute modelAttribute = JBratFileReader.readModelAttribute(fileName);
        modelAttributeMap.put( modelAttribute.getName(), modelAttribute);
    }

    public void loadAttrView     (String fileName){
        JViewAttribute viewAttribute   = JBratFileReader.readViewAttribute(fileName);
        viewAttributeMap.put( viewAttribute.getName(), viewAttribute);
    }

    public void loadAttrCombiner (String fileName){
        JCombinerAttribute combinerAttribute = JBratFileReader.readCombinerAttribute(fileName);
        combinerAttributeMap.put( combinerAttribute.getName(), combinerAttribute);
    }

    public void createViewResource (String viewName, Object...objects){
        JViewAttribute     viewAttribute     = prepareViewAttrWithViewName(viewName);
        JCombinerAttribute combinerAttribute = prepareCombinerAttrWithViewAttr(viewAttribute);
        JModelAttribute[]  modelAttributes   = prepareModelAttrsWithCombinerAttr(combinerAttribute);


    }
    private JViewAttribute prepareViewAttrWithViewName(String viewName){
        return viewAttributeMap.get(viewName);
    }
    private JCombinerAttribute prepareCombinerAttrWithViewAttr(JViewAttribute viewAttribute){
        String combinerName = viewAttribute.getCombinerName();
        return combinerAttributeMap.get(combinerName);
    }
    private JModelAttribute[]  prepareModelAttrsWithCombinerAttr (JCombinerAttribute combinerAttribute){
        String[]           modelNames        = combinerAttribute.getModelNames();
        JModelAttribute[]  modelAttributes   = new JModelAttribute[modelNames.length];
        for(int i=0;i<modelAttributes.length;i++){
            modelAttributes[i] = modelAttributeMap.get(modelNames[i]);
        }
        return modelAttributes;
    }



    public static JBratManager createInstance(String name){
        JBratManager jBratManager = new JBratManager();
        jBratManagerMap.put(name,jBratManager);
        return jBratManager;
    }
}
