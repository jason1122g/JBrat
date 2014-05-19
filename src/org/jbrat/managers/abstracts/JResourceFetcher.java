package org.jbrat.managers.abstracts;

public interface JResourceFetcher<Key,Value> {
    public Value fetchResourceByKey(Key key);
    public void  pruneResourceByKey(Key key);
}
