package org.jbrat.router.data.abstracts;


public interface JModelAttribute {
    public String getModelName();
    public String getModelPackage();
    public boolean needTrim();
    public boolean needDuplicate();

    public void setModelName(String modelName);
    public void setModelPackage(String modelPackage);
    public void setTrim(boolean needTrim);
    public void setDuplicate(boolean needDuplicate);
}
