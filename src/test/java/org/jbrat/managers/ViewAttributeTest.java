package org.jbrat.managers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ViewAttributeTest {
    private JViewAttribute viewAttribute;
    @Before
    public void setUp() throws Exception {
        viewAttribute = new ViewAttribute();
    }

    @Test
    public void testGetSetName() throws Exception {
        Assert.assertEquals(viewAttribute.getName(),"");
        viewAttribute.setName("test");
        Assert.assertEquals(viewAttribute.getName(),"test");
    }

    @Test
    public void testGetSetPackage() throws Exception {
        Assert.assertEquals(viewAttribute.getPackage(),"");
        viewAttribute.setPackage("test");
        Assert.assertEquals(viewAttribute.getPackage(),"test");
    }

    @Test
    public void testGetSetCombinerName() throws Exception {
        Assert.assertEquals(viewAttribute.getCombinerName(),"");
        viewAttribute.setCombinerName("test");
        Assert.assertEquals(viewAttribute.getCombinerName(),"test");
    }
}
