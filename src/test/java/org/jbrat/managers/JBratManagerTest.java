package org.jbrat.managers;

import org.jbrat.exceptions.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class JBratManagerTest {
    private static JBratManager jBratManager = testCreateInstance();

    public static JBratManager testCreateInstance(){
        JBratManager manager = JBratManager.createInstance("JBratManagerTest");
        try{
            JBratManager.createInstance("JBratManagerTest");
            Assert.fail("should cast KeyDuplicateException");
        }catch (KeyDuplicateException exception){

        }
        return manager;
    }

    @Test
    public void testReadSetting() throws Exception {
        testReadSettingSuccess();
        testReadSettingFail1();
        testReadSettingFail2();
    }

    private void testReadSettingSuccess() throws Exception{
        File file = new File(this.getClass().getResource("/testSetting1.json").toURI());
        jBratManager.readSetting(file.toString());
    }

    private void testReadSettingFail1() throws Exception{
        try{
            jBratManager.readSetting("nothing");
            Assert.fail("should cast IOException");
        }catch (IOException exception){

        }
    }

    private void testReadSettingFail2() throws Exception{
        try{
            File file = new File(this.getClass().getResource("/testSetting4.json").toURI());
            jBratManager.readSetting(file.toString());
            Assert.fail("should cast AttributeFormatException");
        }catch (AttributeFormatException exception){

        }
    }

    @Test
    public void testLoadSetting() throws Exception {
        testLoadSettingSuccess();
        testLoadSettingFail();
    }

    private void testLoadSettingSuccess() throws Exception{
        jBratManager.loadSetting(JBratFileReader.readResourceFile("/testSetting2.json"));
    }

    private void testLoadSettingFail() throws Exception{
        try{
            jBratManager.loadSetting(JBratFileReader.readResourceFile("/testSetting4.json"));
            Assert.fail("should cast AttributeFormatException");
        }catch (AttributeFormatException exception){

        }
    }


    @Test
    public void testCreateView() throws Exception {
        testCreateViewSuccess();
        testCreateViewFail1();
        testCreateViewFail2();
        testCreateViewFail3();
    }

    public void testCreateViewSuccess() throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(this.getClass().getResource("/testSetting6.json").toURI());
        jBratManager.readSetting(file.toString());
        jBratManager.createView("testView1",stringBuilder);
        Assert.assertEquals(stringBuilder.toString(),"testModel1testModel1truetruetestView2");
    }

    public void testCreateViewFail1() throws Exception{
        File file = new File(this.getClass().getResource("/testSetting1.json").toURI());
        jBratManager.readSetting(file.toString());
        try{
            jBratManager.createView("thirdView");
            Assert.fail("should cast ViewNotLoadException");
        }catch (ViewNotLoadException exception){

        }
    }

    public void testCreateViewFail2() throws Exception{
        File file = new File(this.getClass().getResource("/testSetting2.json").toURI());
        jBratManager.readSetting(file.toString());
        try{
            jBratManager.createView("fifthView");
            Assert.fail("should cast CombinerNotLoadException");
        }catch (CombinerNotLoadException exception){

        }
    }

    public void testCreateViewFail3() throws Exception{
        File file = new File(this.getClass().getResource("/testSetting7.json").toURI());
        jBratManager.readSetting(file.toString());
        try{
            jBratManager.createView("firstView");
            Assert.fail("should cast ModelNotLoadException");
        }catch (ModelNotLoadException exception){

        }
    }
}
