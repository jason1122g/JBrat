package com.example;

import org.jbrat.managers.JBratManager;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        try {
            File file = new File(Main.class.getResource("/setting.json").toURI());
            mainManager.readSetting(file.toString());
            mainManager.createView("firstView");
        } catch (ReflectiveOperationException | IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
