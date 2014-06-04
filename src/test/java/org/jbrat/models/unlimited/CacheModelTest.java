package org.jbrat.models.unlimited;

import org.jbrat.models.abstracts.DataHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheModelTest {
    private CacheModel<String> cacheModel;
    private String testString1;
    private String testString2;
    @Before
    public void setUp() throws Exception {
        cacheModel = new StringModel();
    }

    @Test
    public void testGetSet() throws Exception {
        cacheModel.set("name","123");
        Assert.assertEquals(cacheModel.get("name"),"123");
    }

    @Test
    public void testRemove() throws Exception {
        cacheModel.set("name","123");
        Assert.assertNotNull(cacheModel.get("name"));
        cacheModel.remove("name");
        Assert.assertNull(cacheModel.get("name"));
    }

    @Test
    public void testContains() throws Exception {
        cacheModel.set("name","123");
        Assert.assertTrue(cacheModel.contains("name"));
        Assert.assertFalse(cacheModel.contains("name2"));
    }

    @Test
    public void testBind() throws Exception{
        testString1 = "beforeTest";
        testString2 = "beforeTest";
        cacheModel.bind("name",new DataHandler<String>() {
            @Override
            public void handle(String dataNext, String dataPrev) {
                testString1 = dataNext;
            }
        });
        cacheModel.bind("name",new DataHandler<String>() {
            @Override
            public void handle(String dataNext, String dataPrev) {
                testString2 = dataNext;
            }
        });
        Assert.assertEquals(testString1,"beforeTest");
        Assert.assertEquals(testString2,"beforeTest");
        cacheModel.set("name","Jason");
        Assert.assertEquals(testString1,"Jason");
        cacheModel.set("name","Peter");
        Assert.assertEquals(testString2,"Peter");
    }

    @Test
    public void testUnbind() throws Exception{
        cacheModel.unbind("name",null);
        testString1 = "beforeTest";
        DataHandler<String> handler = new DataHandler<String>() {
            @Override
            public void handle(String dataNext, String dataPrev) {
                testString1 = dataNext;
            }
        };
        cacheModel.bind("name",handler);
        Assert.assertEquals(testString1,"beforeTest");
        cacheModel.unbind("name",handler);
        cacheModel.set("name","Jason");
        Assert.assertEquals(testString1,"beforeTest");
    }
}
