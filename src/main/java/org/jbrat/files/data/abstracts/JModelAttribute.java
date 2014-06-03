package org.jbrat.files.data.abstracts;


public interface JModelAttribute extends NamePackagGetSet {
    public boolean isPersistant ();
    public void    setPersistant(boolean needDuplicate);
}