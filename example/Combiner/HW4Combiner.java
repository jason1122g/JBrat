package Combiner;

import Model.AJAXModel;
import Model.EventModel;
import Model.TextModel;
import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JBundle;

public class HW4Combiner implements JCombiner {
    @Override
    public void onPreparing(JBundle bundle) {
        final AJAXModel ajaxModel = (AJAXModel) bundle.getModel("ajax");
        final TextModel textModel = (TextModel) bundle.getModel("text");

        final EventModel eventModel = (EventModel) bundle.getModel("event");

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
