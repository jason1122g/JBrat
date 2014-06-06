package org.jbrat.managers;

import org.jbrat.combiners.JCombiner;
import org.jbrat.exceptions.JBratException;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class JBratReflecterTest extends JBratReflecter{

    @Test
    public void testReflectExceptions() throws Exception{
        try{
            JBratReflecter.reflectModel("nothing");
            Assert.fail("should cast ClassNotFoundException");
        }catch (ReflectiveOperationException exception){

        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testReflectModel() throws Exception {
        JModel<String> model = (JModel<String>)JBratReflecter.reflectModel("org.jbrat.fakeObjects.fakeModel");
        Assert.assertEquals(model.get("testKey"),"testValue");
    }

    @Test
    public void testReflectCombiner() throws Exception {
        JCombiner combiner = JBratReflecter.reflectCombiner("org.jbrat.fakeObjects.fakeCombiner");
        try{
            combiner.onPreparing(null);
            Assert.fail("should cast JBratException");
        }catch (JBratException exception){

        }
    }

    @Test
    public void testReflectView() throws Exception {
        testDefaultConstructor();
        testPointConstructor();
        testErrorConstructor();
    }
    private void testDefaultConstructor() throws Exception{
        JView view = JBratReflecter.reflectView( "org.jbrat.fakeObjects.fakeView");
        try{
            view.onCreating(null);
            Assert.fail("should cast JBratException");
        }catch (JBratException exception){

        }
    }
    private void testPointConstructor() throws Exception{
        Point point = new Point(1,2);
        JBratReflecter.reflectView("org.jbrat.fakeObjects.fakeView",point);
        Assert.assertEquals(point.getLocation(),new Point(3,4));
    }
    private void testErrorConstructor() throws Exception{
        Integer integer = 1;
        try{
            JBratReflecter.reflectView("org.jbrat.fakeObjects.fakeView",integer);
            Assert.fail("should cast Exception");
        }catch(Exception exception){

        }
    }

}
