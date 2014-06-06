package com.example;

import org.jbrat.managers.JBratManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        try {
            mainManager.loadAttrModel   ("model.json");
            mainManager.loadAttrView    ("view.json");
            mainManager.loadAttrCombiner("combiner.json");
            mainManager.createViewResource("firstView");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
