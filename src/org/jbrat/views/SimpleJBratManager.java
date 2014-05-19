package org.jbrat.views;

import org.jbrat.models.CacheModel;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.router.FileSystem;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.views.abstracts.JBratManager;
import org.jbrat.views.abstracts.JView;

public class SimpleJBratManager extends JBratManager<String> {

    private JRouteFile router;
    private JModel<JBratManager> managerModel;

    public SimpleJBratManager(String defaultRoutePath){

        router = FileSystem.readRouteFile(defaultRoutePath);

        initSingletonViewChangerModel();

        initDefaultViewOfNameMainView();
    }
    private void initSingletonViewChangerModel(){
        managerModel = new CacheModel<JBratManager>();
        managerModel.set("Main", this);
    }
    private void initDefaultViewOfNameMainView(){
        this.initView("MainView");
    }

    @Override
    protected JBundle getBundle(String viewName) {
        JBundle bundle = router.getBundle(viewName);
        if(bundle.getModel("JBratManager")==null){
            bundle.setModel("JBratManager", managerModel);
        }
        return bundle;
    }

    @Override
    protected JView getView(String viewName) {
        return router.getView(viewName);
    }

}
