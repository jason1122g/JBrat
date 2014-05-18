package Controller;

import Model.AJAXModel;
import Model.EventModel;
import Model.TextModel;
import org.jbrat.controllers.JController;
import org.jbrat.models.abstracts.JBundle;

public class HW4Controller implements JController {
    @Override
    public void onPreparing(JBundle bundle) {
        final AJAXModel ajaxModel = (AJAXModel) bundle.get("ajax");
        final TextModel textModel = (TextModel) bundle.get("text");

        final EventModel eventModel = (EventModel) bundle.get("event");

        eventModel.set("ok",new Runnable() {
            @Override
            public void run() {
                String type = textModel.get("type");
                String name = textModel.get("name");
                String result = String.format("Type:%s->Name:%s",type,name);

                textModel.set("result",result);
                ajaxModel.set("result",result);
            }
        });
    }
}
