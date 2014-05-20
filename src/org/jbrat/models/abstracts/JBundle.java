package org.jbrat.models.abstracts;

public interface JBundle {
    public JModel<String> getStringModel(String name) ;
    public<T> JModel<T> getModel(String name,Class<T> type);

    void setModel(String name,JModel model);
    void setTrimable(String name, boolean trimStatus);
    void trimModels();
}
