package org.jbrat.router;

import org.jbrat.models.abstracts.JBundle;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.views.abstracts.JView;

import java.awt.*;


class Router implements JRouteFile{

    private JobAttributes attributes;

    public Router(JobAttributes attributes){
        this.attributes = attributes;
    }

    @Override
    public JBundle getBundle(String viewName) {
        //TODO REFLECT INIT BUNDLE FROM ATTRIBUTES
        return null;
    }

    @Override
    public JView getView(String viewName) {
        //TODO REFLECT INIT VIEW FROM ATTRIBUTES
        return null;
    }
}
