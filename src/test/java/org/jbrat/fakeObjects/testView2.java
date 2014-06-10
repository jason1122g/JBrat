package org.jbrat.fakeObjects;

import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.views.abstracts.JView;

@SuppressWarnings("unused")
public class testView2 implements JView {
    private StringBuilder stringBuilder;
    public testView2(StringBuilder stringBuilder){
        this.stringBuilder = stringBuilder;
    }
    @Override
    public void onCreating(JLimitBundle bundle) {
        stringBuilder.append("testView2");
    }
}
