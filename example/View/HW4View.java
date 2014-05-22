package View;

import org.jbrat.models.EventModel;
import org.jbrat.models.StringModel;
import org.jbrat.models.abstracts.DataHandler;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.views.abstracts.JView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HW4View implements JView {

    private StringModel textModel;
    private EventModel eventModel;

    @Override
    public void onCreating(JBundle bundle) {
        textModel  = bundle.getStringModel("text");
        eventModel = bundle.getEventModel("event");

        final JTextArea textArea = new JTextArea();
        textModel.bind("result",new DataHandler<String>(){
            public void handle(String dataNext, String dataPrev){
                textArea.setText(dataNext);
            }
        });

        final JButton okButton = new JButton();
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                eventModel.trigger("ok");
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
