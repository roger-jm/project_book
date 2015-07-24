package com.jm.java.io;

import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * This is Project project_book
 * Created by jmwmj
 * On 2015/7/24
 * At 11:03
 */
public class SimpleTest {
    Simple simple = null;

    @Before
    public void init(){
        simple = new Simple();
    }

    @Test
    public void testCreateFile() throws Exception {
        String path = simple.createFile();
        System.out.println(path);
    }

    @Test
    public void testFileCreate() throws Exception {
        ClassLoader loader =  Simple.class.getClassLoader();
        System.out.println(loader.getParent());
    }

    @Test
    public void testCreateFileInResourcePath() throws Exception {
        simple.createFileInResourcePath("file2.txt");
        simple.createFileInResourcePath("file2","file.txt");
    }

    @Test
    public void testCreateFileInResourcePath1() throws Exception {
        URL url = SimpleTest.class.getClassLoader().getResource("amber");
        System.out.println(url.getPath());
    }

    @Test
    public void testCleanDir() throws Exception {
        simple.cleanTestFiles();
    }

    @Test
    public void testReadTxt() throws Exception {
        simple.readTxt();

    }

    @Test
    public void testReadBuffer() throws Exception {
        simple.readBuffer();

    }
}