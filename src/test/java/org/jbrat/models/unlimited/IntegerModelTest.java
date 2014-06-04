package org.jbrat.models.unlimited;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegerModelTest {
    private IntegerModel integerModel;
    @Before
    public void setUp() throws Exception {
        integerModel = new IntegerModel();
    }

    @Test
    public void testGetSet() throws Exception {
        integerModel.set("test",123);
        Assert.assertEquals(integerModel.get("test"), Integer.valueOf(123));
        integerModel.set("test",-456);
        Assert.assertEquals(integerModel.get("test"), Integer.valueOf(-456));
    }
}
