package org.jbrat.managers;

interface JCombinerAttribute extends NamePackagGetSet {
    public String[]  getModelNames();
    public boolean[] getModelPersists();

    public void addModelNamePersist(String modelName,boolean isPersist);
}
