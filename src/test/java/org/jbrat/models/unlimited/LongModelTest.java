package org.jbrat.models.unlimited;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongModelTest {
    private LongModel longModel;
    @Before
    public void setUp() throws Exception {
        longModel = new LongModel();
    }

    @Test
    public void testGetSet() throws Exception {
        longModel.set("test",Long.MAX_VALUE);
        Assert.assertEquals(longModel.get("test"),Long.valueOf(Long.MAX_VALUE));
        longModel.set("test",Long.MIN_VALUE);
        Assert.assertEquals(longModel.get("test"),Long.valueOf(Long.MIN_VALUE));
    }
}
