package org.jbrat.models.unlimited;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DoubleModelTest {
    private DoubleModel doubleModel;
    @Before
    public void setUp() throws Exception {
        doubleModel = new DoubleModel();
    }

    @Test
    public void testGetSet() throws Exception {
        doubleModel.set("test",123.456);
        Assert.assertEquals(doubleModel.get("test"), Double.valueOf(123.456));
        doubleModel.set("test",456.789);
        Assert.assertEquals(doubleModel.get("test"), Double.valueOf(456.789));
    }
}
