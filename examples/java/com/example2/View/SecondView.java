package com.example2.View;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.limited.LStringModel;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class SecondView implements JView {
    private LStringModel textModel;
    private JBratManager jBratManager;
    private JFrame mainFrame;
    private JPanel secondPanel;

    public SecondView(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void onCreating(JLimitBundle bundle) {
        textModel    = bundle.getStringModel("text");
        jBratManager = bundle.getJBratManager("main");

        initPanel();
        initLabel();
        initButton();
        addComponentsToFrame();
    }

    private void initPanel(){
        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout());
    }

    private void initLabel(){
        JLabel label = new JLabel(textModel.get("secondView-label"));
        secondPanel.add(label);
    }

    private void initButton(){
        JButton nextButton = new JButton(textModel.get("secondView-next"));
        nextButton.setPreferredSize(new Dimension(180, 200));
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    jBratManager.createView("firstView", mainFrame);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        });
        secondPanel.add(nextButton);
    }

    private void addComponentsToFrame(){
        mainFrame.setContentPane(secondPanel);
        mainFrame.revalidate();
    }
}
