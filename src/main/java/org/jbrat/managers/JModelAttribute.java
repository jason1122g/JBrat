package org.jbrat.managers;


interface JModelAttribute extends NamePackagGetSet {
    public boolean isPersistant ();
    public void    setPersistant(boolean needDuplicate);
}