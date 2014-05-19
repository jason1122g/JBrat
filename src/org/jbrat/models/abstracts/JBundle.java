package org.jbrat.models.abstracts;

public interface JBundle {
    public JModel<?> getModel(String name);

    void setModel(String name,JModel model);
    void setTrimable(String name, boolean trimStatus);
    void trimModels();
}
