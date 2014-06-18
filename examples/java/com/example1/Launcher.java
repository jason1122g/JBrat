package com.example1;

import org.jbrat.managers.JBratManager;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Launcher {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        try {
            File file = new File(Launcher.class.getResource("/setting1.json").toURI());
            mainManager.readSetting(file.toString());
            mainManager.createView("firstView");
        } catch (ReflectiveOperationException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
