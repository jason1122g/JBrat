package org.jbrat.views;

import org.jbrat.models.CacheModel;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.router.FileSystem;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.views.abstracts.JView;
import org.jbrat.views.abstracts.ViewChanger;

public class SimpleViewChanger extends ViewChanger<String>{

    private JRouteFile router;
    private JModel<ViewChanger> viewChangerModel ;

    public SimpleViewChanger(String defaultRoutePath){

        router = FileSystem.readRouteFile(defaultRoutePath);

        initSingletonViewChangerModel();

        initDefaultViewOfNameMainView();
    }
    private void initSingletonViewChangerModel(){
        viewChangerModel = new CacheModel<ViewChanger>();
        viewChangerModel.set("Main", this);
    }
    private void initDefaultViewOfNameMainView(){
        this.initView("MainView");
    }

    @Override
    protected JBundle getBundle(String viewName) {
        JBundle bundle = router.getBundle(viewName);
        if(bundle.getModel("ViewChanger")==null){
            bundle.setModel("ViewChanger",viewChangerModel);
        }
        return bundle;
    }

    @Override
    protected JView getView(String viewName) {
        return router.getView(viewName);
    }

}
