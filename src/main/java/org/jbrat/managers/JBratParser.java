package org.jbrat.managers;

import org.jbrat.exceptions.AttributeFormatException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.LinkedList;

class JBratParser {
    public static JSettingAttribute parseSetting(String setting) throws AttributeFormatException{
        try {
            JSONObject jsonObject = new JSONObject(setting);
            String version = jsonObject.getString("version");
            switch (version){
                case "1.0.0":
                    return parseByVersion100(jsonObject);
                default:
                    throw new AttributeFormatException("version expect error:"+version);
            }
        }catch (JSONException exception){
            throw new AttributeFormatException(exception.getMessage());
        }
    }

    private static JSettingAttribute parseByVersion100(JSONObject jsonObject) throws AttributeFormatException{

        JSONArray jsonSettings = jsonObject.getJSONArray("setting");
        Collection<JViewAttribute>      viewAttributes     = new LinkedList<>();
        Collection<JCombinerAttribute>  combinerAttributes = new LinkedList<>();
        Collection<JModelAttribute>     modelAttributes    = new LinkedList<>();

        for(int i=0;i<jsonSettings.length();i++){
            JSONObject jsonSetting     = (JSONObject) jsonSettings.get(i);
            JSONObject jsonSettingData = jsonSetting.getJSONObject("data");
            String settingType = jsonSetting.getString("type");
            switch (settingType){
                case "view":
                    viewAttributes.addAll(parseViewAttr100(jsonSettingData));
                    break;
                case "combiner":
                    combinerAttributes.addAll(parseCombinerAttr100(jsonSettingData));
                    break;
                case "model":
                    modelAttributes.addAll(parseModelAttr100(jsonSettingData));
                    break;
                default:
                    throw new AttributeFormatException("type expect error:"+settingType);
            }
        }

        return buildSettingWithMVCAttrCollection(modelAttributes, viewAttributes, combinerAttributes);
    }

    private static Collection<JViewAttribute> parseViewAttr100(JSONObject viewSettingData){
        final Collection<JViewAttribute> viewAttributes = new LinkedList<>();
        for(Object keys : viewSettingData.keySet()){
            String name = keys.toString();
            JSONObject viewAttr = viewSettingData.getJSONObject(name);
            JViewAttribute viewAttribute = new ViewAttribute();

            viewAttribute.setName(name);
            viewAttribute.setPackage(viewAttr.getString("package"));
            if(viewAttr.has("combiner")){
                viewAttribute.setCombinerName(viewAttr.getString("combiner"));
            }
            viewAttributes.add(viewAttribute);
        }
        return viewAttributes;
    }

    private static Collection<JCombinerAttribute> parseCombinerAttr100(JSONObject combinerAttrData){
        final Collection<JCombinerAttribute> combinerAttributes = new LinkedList<>();
        for(Object dataKey : combinerAttrData.keySet()){
            String combinerName = dataKey.toString();
            JSONObject combinerAttr = combinerAttrData.getJSONObject(combinerName);
            JCombinerAttribute combinerAttribute = new CombinerAttribute();

            combinerAttribute.setName(combinerName);
            combinerAttribute.setPackage(combinerAttr.getString("package"));
            if(combinerAttr.has("models")){
                JSONObject modelDependencies = combinerAttr.getJSONObject("models");
                for(Object modelKey : modelDependencies.keySet()){
                    String modelName = modelKey.toString();
                    JSONObject modelDependency = modelDependencies.getJSONObject(modelName);
                    combinerAttribute.addModelNamePersist(modelName, modelDependency.getBoolean("persist"));
                }
            }
            combinerAttributes.add(combinerAttribute);
        }
        return combinerAttributes;
    }

    private static Collection<JModelAttribute> parseModelAttr100(JSONObject modelAttrData){

        final Collection<JModelAttribute> modelAttributes = new LinkedList<>();
        for(Object keys : modelAttrData.keySet()){
            String name = keys.toString();
            JSONObject viewAttr = modelAttrData.getJSONObject(name);
            JModelAttribute modelAttribute = new ModelAttribute();

            modelAttribute.setName(name);
            modelAttribute.setPackage(viewAttr.getString("package"));
            modelAttributes.add(modelAttribute);
        }
        return modelAttributes;
    }

    private static JSettingAttribute buildSettingWithMVCAttrCollection(Collection<JModelAttribute> modelAttributes,
                                                                       Collection<JViewAttribute> viewAttributes,
                                                                       Collection<JCombinerAttribute> combinerAttributes){
        JSettingAttribute settingAttribute = new SettingAttribute();
        settingAttribute.setViewAttributes(viewAttributes.toArray(new JViewAttribute[viewAttributes.size()]));
        settingAttribute.setCombinerAttributes(combinerAttributes.toArray(new JCombinerAttribute[combinerAttributes.size()]));
        settingAttribute.setModelAttributes(modelAttributes.toArray(new JModelAttribute[modelAttributes.size()]));
        return settingAttribute;
    }

}
