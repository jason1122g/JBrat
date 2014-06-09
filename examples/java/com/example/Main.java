package com.example;

import org.jbrat.managers.JBratManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        try {
            mainManager.readSetting("setting.json");
            mainManager.createView("firstView");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
