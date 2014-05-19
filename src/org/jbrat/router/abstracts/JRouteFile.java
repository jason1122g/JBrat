package org.jbrat.router.abstracts;


import org.jbrat.models.abstracts.JBundle;
import org.jbrat.views.abstracts.JView;

public interface JRouteFile {
    public JBundle getBundle(String viewName);
    public JView   getView  (String viewName);
}
