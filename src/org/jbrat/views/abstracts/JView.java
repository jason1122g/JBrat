package org.jbrat.views.abstracts;


import org.jbrat.models.abstracts.JLimitBundle;

public interface JView {
    public void onCreating(JLimitBundle bundle, JLimitBundle bundlePrev);
}
