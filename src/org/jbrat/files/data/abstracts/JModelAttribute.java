package org.jbrat.files.data.abstracts;


public interface JModelAttribute extends NamePackager{
    public boolean isTrimable();
    public boolean isDuplicatable();

    public void setTrimable(boolean needTrim);
    public void setDuplicatable(boolean needDuplicate);
}
