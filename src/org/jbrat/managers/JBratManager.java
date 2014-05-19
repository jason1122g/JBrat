package org.jbrat.managers;

import org.jbrat.files.FileSystem;
import org.jbrat.files.Initiator;
import org.jbrat.files.abstracts.JBTInitiator;
import org.jbrat.files.data.abstracts.JAttribute;
import org.jbrat.managers.abstracts.JResourceFetcher;
import org.jbrat.models.CacheModel;
import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.views.abstracts.JView;

public class JBratManager extends org.jbrat.managers.abstracts.JBratManager<String> {

    private JBTInitiator initiator;
    private JModel<org.jbrat.managers.abstracts.JBratManager> managerModel;
    private JAttribute attribute;
    private JResourceFetcher<String,JModel> resourceFetcher;

    public JBratManager(String defaultRoutePath){

        attribute       = FileSystem.readAttribute(defaultRoutePath);

        resourceFetcher = new SingletonModelFetcher();

        initiator       = new Initiator(attribute);

        initSingletonViewChangerModel();

        initDefaultViewOfNameMainView();
    }
    private void initSingletonViewChangerModel(){
        managerModel = new CacheModel<org.jbrat.managers.abstracts.JBratManager>();
        managerModel.set("Main", this);
    }
    private void initDefaultViewOfNameMainView(){
        this.createView("MainView");
    }

    @Override
    protected JBundle getBundle(String viewName) {
        JBundle bundle = initiator.getBundle(viewName);
        if(bundle.getModel("JBratManager") == null){
            bundle.setModel("JBratManager", managerModel);
        }
        return bundle;
    }

    @Override
    protected JView getView(String viewName) {
        return initiator.getView(viewName);
    }

    @Override
    protected void removeView(String element) {

    }
}
