package com.example.View;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.DataHandler;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.limited.LEventModel;
import org.jbrat.models.limited.LStringModel;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstView implements JView {

    @Override
    public void onCreating(JLimitBundle bundle) {
        final LStringModel    textModel = bundle.getStringModel ("text");
        final LEventModel    eventModel = bundle.getEventModel  ("event");
        final JBratManager jBratManager = bundle.getJBratManager("main");

        final JFrame mainFrame = new JFrame();
        mainFrame.setTitle(textModel.get("name"));
        mainFrame.setSize(300,400);
        mainFrame.setVisible(true);

        final JTextArea textArea = new JTextArea();
        textModel.bind("result",new DataHandler<String>(){
            public void handle(String dataNext, String dataPrev){
                textArea.setText(dataNext);
                try {
                    jBratManager.createViewResource("secondView",mainFrame);
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        });
        mainFrame.add(textArea);

        final JButton okButton = new JButton();
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                eventModel.trigger("ok");
            }
        });
        mainFrame.add(okButton);

    }

}
