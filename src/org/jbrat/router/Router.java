package org.jbrat.router;

import org.jbrat.models.abstracts.JBundle;
import org.jbrat.models.abstracts.JModel;
import org.jbrat.router.abstracts.JRouteFile;
import org.jbrat.router.data.abstracts.JAttribute;
import org.jbrat.router.data.ControllerAttribute;
import org.jbrat.router.data.ViewAttribute;
import org.jbrat.views.abstracts.JView;



public class Router implements JRouteFile {

    private JAttribute attribute;

    public Router(JAttribute attribute){
        this.attribute = attribute;
    }

    @Override
    public JBundle getBundle(String viewName) {
        //TODO REFLECT INIT BUNDLE FROM ATTRIBUTES AND TRIM



        try{
            ViewAttribute viewAttribute;
            ControllerAttribute controllerAttribute;
            JModel model =(JModel) Class.forName("").newInstance();
        }catch (Exception exception){

        }

        return null;
    }

    @Override
    public JView getView(String viewName) {
        //TODO REFLECT INIT VIEW FROM ATTRIBUTES
        return null;
    }
}
