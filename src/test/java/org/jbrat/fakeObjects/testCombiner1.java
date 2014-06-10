package org.jbrat.fakeObjects;

import org.jbrat.combiners.JCombiner;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.unlimited.BooleanModel;
import org.jbrat.models.unlimited.EventModel;
import org.jbrat.models.unlimited.StringModel;

@SuppressWarnings("unused")
public class testCombiner1 implements JCombiner {
    @Override
    public void onPreparing(JBundle bundle) {
        final StringModel  stringModel  = bundle.getStringModel ("testModel1");
        final BooleanModel booleanModel = bundle.getBooleanModel("testModel2");

        EventModel eventModel = new EventModel();
        eventModel.set("1",new Runnable() {
            @Override
            public void run() {
                stringModel.set ("2","testModel1");
                booleanModel.set("2",true);
            }
        });
        bundle.setModel("testModel3",eventModel);
    }
}
