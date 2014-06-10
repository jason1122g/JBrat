package org.jbrat.models.unlimited;

import org.jbrat.managers.JBratConstants;
import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.JModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheBundleTest {
    private CacheBundle bundle;
    private static JBratManager jBratManager = JBratManager.createInstance("test");
    @Before
    public void setUp() throws Exception {
        JModel<JBratManager> managerJModel = new CacheModel<>();
        managerJModel.set("test",jBratManager);

        bundle = new CacheBundle();
        bundle.setModel(JBratConstants.managerModelName,managerJModel);
    }

    @Test
    public void testGetStringModel() throws Exception {
        Assert.assertNull(bundle.getStringModel("test"));
        StringModel stringModel = new StringModel();
        bundle.setModel("test",stringModel);
        Assert.assertNotNull(bundle.getStringModel("test"));
    }

    @Test
    public void testGetEventModel() throws Exception {
        Assert.assertNull(bundle.getEventModel("test"));
        EventModel eventModel = new EventModel();
        bundle.setModel("test", eventModel);
        Assert.assertNotNull(bundle.getEventModel("test"));
    }

    @Test
    public void testGetBooleanModel() throws Exception {
        Assert.assertNull(bundle.getBooleanModel("test"));
        BooleanModel booleanModel = new BooleanModel();
        bundle.setModel("test", booleanModel);
        Assert.assertNotNull(bundle.getBooleanModel("test"));
    }

    @Test
    public void testGetIntegerModel() throws Exception {
        Assert.assertNull(bundle.getIntegerModel("test"));
        IntegerModel integerModel = new IntegerModel();
        bundle.setModel("test", integerModel);
        Assert.assertNotNull(bundle.getIntegerModel("test"));
    }

    @Test
    public void testGetDoubleModel() throws Exception {
        Assert.assertNull(bundle.getDoubleModel("test"));
        DoubleModel doubleModel = new DoubleModel();
        bundle.setModel("test", doubleModel);
        Assert.assertNotNull(bundle.getDoubleModel("test"));
    }

    @Test
    public void testGetLongModel() throws Exception {
        Assert.assertNull(bundle.getLongModel("test"));
        LongModel longModel = new LongModel();
        bundle.setModel("test", longModel);
        Assert.assertNotNull(bundle.getLongModel("test"));
    }

    @Test
    public void testGetJBratManager() throws Exception {
        Assert.assertNotNull(bundle.getJBratManager("test"));
    }

    @Test
    public void testGetModel() throws Exception {
        Assert.assertNull(bundle.getModel("test"));
        JModel<Assert> assertJModel = new CacheModel<>();
        bundle.setModel("test",assertJModel);
        Assert.assertNotNull(bundle.getModel("test"));
    }
}
