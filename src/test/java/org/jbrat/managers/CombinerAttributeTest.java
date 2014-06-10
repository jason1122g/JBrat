package org.jbrat.managers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CombinerAttributeTest {
    private JCombinerAttribute combinerAttribute;
    @Before
    public void setUp() throws Exception {
        combinerAttribute = new CombinerAttribute();
    }

    @Test
    public void testGetSetName() throws Exception {
        Assert.assertEquals(combinerAttribute.getName(),"");
        combinerAttribute.setName("test");
        Assert.assertEquals(combinerAttribute.getName(),"test");
    }

    @Test
    public void testGetSetPackage() throws Exception {
        Assert.assertEquals(combinerAttribute.getPackage(),"");
        combinerAttribute.setPackage("test");
        Assert.assertEquals(combinerAttribute.getPackage(),"test");
    }

    @Test
    public void testGetSetModelNames() throws Exception {
        Assert.assertNull(combinerAttribute.getModelNames());

        combinerAttribute.addModelNamePersist("test1",true);
        combinerAttribute.addModelNamePersist("test2", false);
        Assert.assertArrayEquals(combinerAttribute.getModelNames(), new String[]{"test1", "test2"});

        boolean[] modelPersists = combinerAttribute.getModelPersists();
        Assert.assertEquals(modelPersists[0],true);
        Assert.assertEquals(modelPersists[1],false);
    }
}
