package org.jbrat.views;

import org.jbrat.models.abstracts.JBundle;
import org.jbrat.views.abstracts.JView;
import org.jbrat.views.abstracts.ViewChanger;

public class SimpleViewChanger extends ViewChanger<String>{

    private static SimpleViewChanger thisPointer;

    @Override
    protected JBundle getBundle(String element) {
        return null;
    }

    @Override
    protected JView getView(String element) {
        return null;
    }

    public static SimpleViewChanger getInstance(){
        if(thisPointer == null){
            thisPointer = new SimpleViewChanger();
        }
        return thisPointer;
    }
}
