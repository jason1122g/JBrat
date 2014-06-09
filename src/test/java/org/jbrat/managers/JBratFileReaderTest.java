package org.jbrat.managers;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class JBratFileReaderTest extends JBratFileReader{
    @Test
    public void testReadFullFile1() throws Exception {
        String path1 = new File(this.getClass().getResource("/testFile1.txt").toURI()).toString();
        Assert.assertEquals(JBratFileReader.readFullFile(path1),"test content in file1");
        String path2 = new File(this.getClass().getResource("/testFile2.txt").toURI()).toString();
        Assert.assertEquals(JBratFileReader.readFullFile(path2),"test content in file2");
    }

    @Test
    public void testReadFullFile2() throws Exception {
        File file = new File(this.getClass().getResource("/testFile1.txt").toURI());
        Assert.assertEquals(JBratFileReader.readFullFile(file),"test content in file1");
    }

    @Test
    public void testReadResourceFile() throws Exception {
        Assert.assertEquals(JBratFileReader.readResourceFile("/testFile2.txt"),"test content in file2");
    }
}
