package org.jbrat.models.unlimited;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BooleanModelTest {
    private BooleanModel booleanModel;
    @Before
    public void setUp() throws Exception {
        booleanModel = new BooleanModel();
    }

    @Test
    public void testGetSet() throws Exception {
        Assert.assertNull(booleanModel.get("test"));
        booleanModel.set("test",true);
        Assert.assertTrue(booleanModel.get("test"));
        booleanModel.set("test",false);
        Assert.assertFalse(booleanModel.get("test"));
    }
}
