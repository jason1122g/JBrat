package com.example2;

import org.jbrat.managers.JBratManager;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Launcher {
    public static void main(String[] args){
        JBratManager manager = JBratManager.createInstance("main");
        try {
            File file = new File(Launcher.class.getResource("/setting2.json").toURI());
            manager.readSetting(file.toString());
            manager.createView("mainView");
        } catch (IOException | ReflectiveOperationException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
