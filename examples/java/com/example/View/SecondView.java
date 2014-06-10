package com.example.View;

import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;

@SuppressWarnings("unused")
public class SecondView implements JView{
    private JFrame mainFrame;
    public SecondView(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }
    @Override
    public void onCreating(JLimitBundle bundle) {
        //BUNDLE OPERATION
        mainFrame.setTitle("SecondView");
    }
}
