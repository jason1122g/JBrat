package org.jbrat.files.data.abstracts;


public interface JModelAttribute extends NamePackager{
    public boolean isPersistant ();

    public void    setPersistant(boolean needDuplicate);
}