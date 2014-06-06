package org.jbrat.managers;

import org.jbrat.models.abstracts.JModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JBratModelFactoryTest {
    private JBratModelFactory modelFactory;
    @Before
    public void setUp() throws Exception {
        modelFactory = new JBratModelFactory();
    }

    @Test
    public void testGetOldModel() throws Exception {
        testSuccessGetOldModel();
        testFailedGetOldModel();
    }
    private void testSuccessGetOldModel() throws Exception{
        try{
            JModel model1 = modelFactory.getOldModel("org.jbrat.fakeObjects.fakeModel");
            JModel model2 = modelFactory.getOldModel("org.jbrat.fakeObjects.fakeModel");
            Assert.assertEquals(model1,model2);
        }catch(ReflectiveOperationException exception){
            Assert.fail("should not cast exception");
        }
    }
    private void testFailedGetOldModel() throws Exception{
        try{
            modelFactory.getOldModel("org.jbrat.fakeObjects.modelNotExist");
            Assert.fail("should cast ReflectiveOperationException");
        }catch(ReflectiveOperationException exception){

        }
    }


    @Test
    public void testGetNewModel() throws Exception {
        testSuccessGetNewModel();
        testFailedGetNewModel();
    }
    private void testSuccessGetNewModel() throws Exception{
        try{
            modelFactory.getNewModel("org.jbrat.fakeObjects.fakeModel");
        }catch(ReflectiveOperationException exception){
            Assert.fail("should not cast exception");
        }
    }
    private void testFailedGetNewModel() throws Exception{
        try{
            modelFactory.getNewModel("org.jbrat.fakeObjects.modelNotExist");
            Assert.fail("should cast ReflectiveOperationException");
        }catch(ReflectiveOperationException exception){

        }
    }
}
