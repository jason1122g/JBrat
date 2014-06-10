package org.jbrat.managers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SettingAttributeTest {
    private JSettingAttribute settingAttribute;
    @Before
    public void setUp() throws Exception {
        settingAttribute = new SettingAttribute();
    }

    @Test
    public void testGetSetVersion() throws Exception {
        Assert.assertEquals(settingAttribute.getVersion(),"");
        settingAttribute.setVersion("1.0.1");
        Assert.assertEquals(settingAttribute.getVersion(),"1.0.1");
        settingAttribute.setVersion("1.0.2");
        Assert.assertEquals(settingAttribute.getVersion(), "1.0.2");
    }

    @Test
    public void testGetSetViewAttributes() throws Exception {
        Assert.assertNull(settingAttribute.getViewAttributes());
        JViewAttribute[] viewAttributes = new ViewAttribute[2];
        settingAttribute.setViewAttributes(viewAttributes);
        Assert.assertArrayEquals(settingAttribute.getViewAttributes(), viewAttributes);
    }

    @Test
    public void testGetSetCombinerAttributes() throws Exception {
        Assert.assertNull(settingAttribute.getCombinerAttributes());
        JCombinerAttribute[] combinerAttributes = new CombinerAttribute[2];
        settingAttribute.setCombinerAttributes(combinerAttributes);
        Assert.assertArrayEquals(settingAttribute.getCombinerAttributes(),combinerAttributes);
    }

    @Test
    public void testGetSetModelAttributes() throws Exception {
        Assert.assertNull(settingAttribute.getModelAttributes());
        JModelAttribute[] modelAttributes = new ModelAttribute[2];
        settingAttribute.setModelAttributes(modelAttributes);
        Assert.assertArrayEquals(settingAttribute.getModelAttributes(),modelAttributes);
    }
}
