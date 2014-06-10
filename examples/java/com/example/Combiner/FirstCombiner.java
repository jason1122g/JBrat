package com.example.Combiner;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.unlimited.EventModel;
import org.jbrat.models.unlimited.StringModel;

@SuppressWarnings("unused")
public class FirstCombiner implements JCombiner {
    @Override
    public void onPreparing(JBundle bundle) {
        final StringModel ajaxModel   = bundle.getStringModel("ajax");
        final StringModel textModel   = bundle.getStringModel("text");
        final EventModel eventModel   = new EventModel();

        eventModel.set("ok",new Runnable() {
            @Override
            public void run() {
                String type = textModel.get("type");
                String name = textModel.get("name");
                String result = String.format("Type:%s->Name:%s", type, name);

                textModel.set("result", result);
                ajaxModel.set("result", result);
            }
        });

        bundle.setModel("event",eventModel);
    }
}
