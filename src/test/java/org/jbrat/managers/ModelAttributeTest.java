package org.jbrat.managers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelAttributeTest {
    private JModelAttribute modelAttribute;
    @Before
    public void setUp() throws Exception {
        modelAttribute = new ModelAttribute();
    }

    @Test
    public void testGetSetName() throws Exception {
        Assert.assertEquals(modelAttribute.getName(), "");
        modelAttribute.setName("test");
        Assert.assertEquals(modelAttribute.getName(),"test");
    }

    @Test
    public void testGetSetPackage() throws Exception {
        Assert.assertEquals(modelAttribute.getPackage(), "");
        modelAttribute.setPackage("test");
        Assert.assertEquals(modelAttribute.getPackage(),"test");
    }

    @Test
    public void testPersistant() throws Exception {
        Assert.assertFalse(modelAttribute.isPersistant());
        modelAttribute.setPersistant(true);
        Assert.assertTrue(modelAttribute.isPersistant());
    }
}
