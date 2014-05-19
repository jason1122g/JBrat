package org.jbrat.views;

import org.jbrat.models.abstracts.JBundle;
import org.jbrat.router.FileSystem;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.views.abstracts.JView;
import org.jbrat.views.abstracts.ViewChanger;

public class SimpleViewChanger extends ViewChanger<String>{

    private String defaultRoutePath;
    private JRouteFile router = FileSystem.readRouteFile(defaultRoutePath);

    public SimpleViewChanger(String defaultRoutePath){
        this.defaultRoutePath = defaultRoutePath;
        //TODO init main view after inject this ViewChanger into model
    }

    @Override
    protected JBundle getBundle(String viewName) {
        return router.getBundle(viewName);
    }

    @Override
    protected JView getView(String viewName) {
        return router.getView(viewName);
    }

}
