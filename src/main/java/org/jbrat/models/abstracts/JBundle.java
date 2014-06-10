package org.jbrat.models.abstracts;

import org.jbrat.managers.JBratManager;
import org.jbrat.models.unlimited.*;

public interface JBundle {

    public EventModel   getEventModel  (String name);
    public BooleanModel getBooleanModel(String name);
    public StringModel  getStringModel (String name);
    public IntegerModel getIntegerModel(String name);
    public DoubleModel  getDoubleModel (String name);
    public LongModel    getLongModel   (String name);
    public JBratManager getJBratManager(String name);

    public JModel<?> getModel(String name);

    void setModel(String name,JModel model);
}
