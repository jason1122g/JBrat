package View;

import org.jbrat.models.abstracts.DataHandler;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HW4View implements JView {
    @Override
    @SuppressWarnings("unchecked")
    public void onCreating(JBundle bundle) {
        final JModel<String>   textModel  = (JModel<String>)  bundle.get("text");
        final JModel<Runnable> eventModel = (JModel<Runnable>)bundle.get("event");

        final JTextArea textArea = new JTextArea();
        textModel.bind("result",new DataHandler<String>(){
            public void handle(String data){
                textArea.setText(data);
            }
        });

        final JButton okButton = new JButton();
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                eventModel.get("ok").run();
            }
        });

        JFrame mainFrame = new JFrame();
        mainFrame.setTitle(textModel.get("name"));
        mainFrame.setSize(300,400);
        mainFrame.setVisible(true);

        mainFrame.add(textArea);
        mainFrame.add(okButton);
    }
}
