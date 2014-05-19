package org.jbrat.files.abstracts;


import org.jbrat.models.abstracts.JBundle;
import org.jbrat.views.abstracts.JView;

public interface JBTInitiator {
    public JBundle getBundle(String viewName);
    public JView   getView  (String viewName);
}
