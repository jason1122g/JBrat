package org.jbrat.fakeObjects;

import org.jbrat.exceptions.JBratException;
import org.jbrat.models.abstracts.JLimitBundle;
import org.jbrat.views.abstracts.JView;

import java.awt.*;

public class fakeView implements JView {
    public fakeView(Point testPoint){
        testPoint.setLocation(3,4);
    }
    public fakeView(){
        this(new Point(1,2));
    }
    @Override
    public void onCreating(JLimitBundle bundle) {
        throw new JBratException();
    }
}
