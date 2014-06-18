package com.example2.View;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.limited.LStringModel;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;

@SuppressWarnings("unused")
public class MainView implements JView{
    private LStringModel textModel;
    private JBratManager jBratManager;
    private JFrame mainFrame;

    @Override
    public void onCreating(JLimitBundle bundle) {
        textModel    = bundle.getStringModel("text");
        jBratManager = bundle.getJBratManager("main");

        initFrame();
        initFirstView();
    }

    private void initFrame(){
        mainFrame = new JFrame();
        mainFrame.setTitle(textModel.get("title"));
        mainFrame.setSize(400, 250);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    private void initFirstView(){
        try {
            jBratManager.createView("firstView",mainFrame);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
