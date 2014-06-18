package com.example1.View;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.DataHandler;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.limited.LEventModel;
import org.jbrat.models.limited.LStringModel;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("unused")
public class FirstView implements JView {

    private LStringModel textModel;
    private LEventModel  eventModel;
    private JBratManager jBratManager;
    private JFrame mainFrame;

    @Override
    public void onCreating(JLimitBundle bundle) {
        textModel    = bundle.getStringModel ("text");
        eventModel   = bundle.getEventModel  ("event");
        jBratManager = bundle.getJBratManager("main");

        initFrame();
        initTextArea();
        initButton();
        showFrame();
    }

    private void initFrame(){
        mainFrame = new JFrame();
        mainFrame.setTitle(textModel.get("name"));
        mainFrame.setSize(400, 250);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
    }

    private void initTextArea(){
        final JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(180,200));
        textModel.bind("result",new DataHandler<String>(){
            public void handle(String dataNext, String dataPrev){
                textArea.setText(dataNext);
                try {
                    jBratManager.createView("secondView", mainFrame);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        });
        mainFrame.add(textArea);
    }

    private void initButton(){
        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(180,200));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                eventModel.trigger("ok");
            }
        });
        mainFrame.add(okButton);
    }

    private void showFrame(){
        mainFrame.setVisible(true);
    }

}
