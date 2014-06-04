package org.jbrat.models.unlimited;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EventModelTest {
    private EventModel eventModel;
    private int value;
    @Before
    public void setUp() throws Exception {
        value = 0;
        eventModel = new EventModel();
        eventModel.set("test",new Runnable() {
            @Override
            public void run() {
                value = 1;
            }
        });
    }
    @Test
    public void testTrigger() throws Exception {
        Assert.assertEquals(value,0);
        eventModel.trigger("test");
        Assert.assertEquals(value,1);
    }
}
