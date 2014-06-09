package org.jbrat.files.data.abstracts;

public interface JSettingAttribute {
    public String getVersion();
    public JViewAttribute[]     getViewAttributes();
    public JCombinerAttribute[] getCombinerAttributes();
    public JModelAttribute[]    getModelAttributes();

    public void setVersion(String version);
    public void setViewAttributes       (JViewAttribute[] viewAttributes);
    public void setCombinerAttributes   (JCombinerAttribute[] combinerAttributes);
    public void setModelAttributes      (JModelAttribute[] modelAttributes);
}
