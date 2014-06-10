package org.jbrat.fakeObjects;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.models.limited.LBooleanModel;
import org.jbrat.models.limited.LEventModel;
import org.jbrat.models.limited.LStringModel;
import org.jbrat.views.abstracts.JView;

@SuppressWarnings("unused")
public class testView1 implements JView{
    private StringBuilder stringBuilder;
    public testView1(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }
    @Override
    public void onCreating(JLimitBundle bundle) {
        final LStringModel  stringModel  = bundle.getStringModel ("testModel1");
        final LBooleanModel booleanModel = bundle.getBooleanModel("testModel2");
        final LEventModel   eventModel   = bundle.getEventModel("testModel3");
        final JBratManager  jBratManager = bundle.getJBratManager("JBratManagerTest");

        eventModel.trigger("1");
        stringBuilder.append(stringModel.get("1"));
        stringBuilder.append(stringModel.get("2"));
        stringBuilder.append(booleanModel.get("1"));
        stringBuilder.append(booleanModel.get("2"));

        try {
            jBratManager.createView("testView2",stringBuilder);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
