package org.jbrat.combiners;


import org.jbrat.managers.abstracts.JBratManager;
import org.jbrat.models.abstracts.JBundle;

public interface JCombiner {
    public void onPreparing(JBundle bundle, JBratManager jbrat);
}
