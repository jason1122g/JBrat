package org.jbrat.models.abstracts;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.limited.*;

public interface JLimitBundle {
    public LEventModel   getEventModel  (String name);
    public LBooleanModel getBooleanModel(String name);
    public LStringModel  getStringModel (String name);
    public LIntegerModel getIntegerModel(String name);
    public LDoubleModel  getDoubleModel (String name);
    public LLongModel    getLongModel   (String name);
    public JBratManager  getJBratManager(String name);

    public<T> JLimitModel<T> getModel(String name);

}
