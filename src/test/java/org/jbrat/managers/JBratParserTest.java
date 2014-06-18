package org.jbrat.managers;

import org.jbrat.exceptions.AttributeFormatException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class JBratParserTest extends JBratParser{

    @Test
    public void testParseSetting1() throws Exception {
        String setting = JBratFileReader.readResourceFile("/testSetting1.json");
        JSettingAttribute settingAttribute = JBratParser.parseSetting(setting);
        testViewAttrs(settingAttribute.getViewAttributes());
        testCombinerAttrs(settingAttribute.getCombinerAttributes());
        testModelAttrs(settingAttribute.getModelAttributes());
    }

    private void testViewAttrs(JViewAttribute[] viewAttributes) throws Exception{

        Map<String,JViewAttribute> attributeMap = new TreeMap<>();
        for(JViewAttribute viewAttribute : viewAttributes){
            attributeMap.put(viewAttribute.getName(),viewAttribute);
        }

        JViewAttribute viewAttribute1 = attributeMap.get("firstView");
        Assert.assertEquals("src.com.example1.View.FirstView",viewAttribute1.getPackage());
        Assert.assertEquals("firstCombiner",viewAttribute1.getCombinerName());

        JViewAttribute viewAttribute2 = attributeMap.get("secondView");
        Assert.assertEquals("src.com.example1.View.SecondView",viewAttribute2.getPackage());
        Assert.assertEquals("",viewAttribute2.getCombinerName());

    }

    private void testCombinerAttrs(JCombinerAttribute[] combinerAttributes) throws Exception{

        Map<String,JCombinerAttribute> attributeMap = new TreeMap<>();
        for(JCombinerAttribute combinerAttribute : combinerAttributes){
            attributeMap.put(combinerAttribute.getName(),combinerAttribute);
        }

        JCombinerAttribute combinerAttribute1 = attributeMap.get("firstCombiner");
        Assert.assertEquals("src.com.example1.Combiner.FirstCombiner",combinerAttribute1.getPackage());

        Map<String,Boolean> modelPropertyMap = new TreeMap<>();
        String[]  modelNames    = combinerAttribute1.getModelNames();
        boolean[] modelPersists = combinerAttribute1.getModelPersists();
        for(int i=0;i<combinerAttribute1.getModelNames().length;i++){
            modelPropertyMap.put(modelNames[i],modelPersists[i]);
        }
        Assert.assertFalse(modelPropertyMap.get("text"));
        Assert.assertTrue(modelPropertyMap.get("ajax"));


        JCombinerAttribute combinerAttribute2 = attributeMap.get("secondCombiner");
        Assert.assertEquals("src.com.example1.Combiner.FirstCombiner",combinerAttribute2.getPackage());
        Assert.assertNull(combinerAttribute2.getModelNames());
        Assert.assertNull(combinerAttribute2.getModelPersists());
    }

    private void testModelAttrs(JModelAttribute[] modelAttributes) throws Exception{

        Map<String,JModelAttribute> attributeMap = new TreeMap<>();
        for(JModelAttribute modelAttribute : modelAttributes){
            attributeMap.put(modelAttribute.getName(),modelAttribute);
        }

        JModelAttribute modelAttribute1 = attributeMap.get("ajax");
        Assert.assertEquals("src.com.example1.Model.AJAXModel",modelAttribute1.getPackage());

        JModelAttribute modelAttribute2 = attributeMap.get("text");
        Assert.assertEquals("src.com.example1.Model.TextModel",modelAttribute2.getPackage());
    }

    @Test
    public void testParseSetting2() throws Exception{
        String setting = JBratFileReader.readResourceFile("/testSetting2.json");
        JSettingAttribute settingAttribute = JBratParser.parseSetting(setting);
        JViewAttribute[] viewAttributes = settingAttribute.getViewAttributes();

        Map<String,JViewAttribute> viewAttributeMap = new TreeMap<>();
        for(JViewAttribute viewAttribute : viewAttributes){
            viewAttributeMap.put(viewAttribute.getName(),viewAttribute);
        }

        JViewAttribute viewAttribute1 = viewAttributeMap.get("firstView");
        Assert.assertEquals("src.com.example1.View.FirstView",viewAttribute1.getPackage());
        Assert.assertEquals("firstCombiner",viewAttribute1.getCombinerName());

        JViewAttribute viewAttribute2 = viewAttributeMap.get("secondView");
        Assert.assertEquals("src.com.example1.View.SecondView",viewAttribute2.getPackage());

        JViewAttribute viewAttribute3 = viewAttributeMap.get("thirdView");
        Assert.assertEquals("src.com.example1.View.ThirdView",viewAttribute3.getPackage());
        Assert.assertEquals("secondCombiner",viewAttribute3.getCombinerName());

        JViewAttribute viewAttribute4 = viewAttributeMap.get("fourthView");
        Assert.assertEquals("src.com.example1.View.FourthView",viewAttribute4.getPackage());
    }

    @Test
    public void testParseSetting3() throws Exception{
        String setting = JBratFileReader.readResourceFile("/testSetting3.json");
        try{
            JBratParser.parseSetting(setting);
            Assert.fail("should cast AttributeFormatException");
        }catch (AttributeFormatException exception){
            //DO NOTHING
        }
    }

    @Test
    public void testParseSetting4() throws Exception{
        String setting = JBratFileReader.readResourceFile("/testSetting4.json");
        try{
            JBratParser.parseSetting(setting);
            Assert.fail("should cast AttributeFormatException");
        }catch (AttributeFormatException exception){
            //DO NOTHING
        }
    }

    @Test
    public void testParseSetting5() throws Exception{
        String setting = JBratFileReader.readResourceFile("/testSetting5.json");
        try{
            JBratParser.parseSetting(setting);
            Assert.fail("should cast AttributeFormatException");
        }catch (AttributeFormatException exception){
            //DO NOTHING
        }
    }

}
