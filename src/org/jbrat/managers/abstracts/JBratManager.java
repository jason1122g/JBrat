package org.jbrat.managers.abstracts;

import org.jbrat.models.abstracts.JBundle;
import org.jbrat.views.abstracts.JView;


public abstract class JBratManager<Type> {


    public void createView(Type element){
        createViewByElement(element);
        JBundle viewBundle = getBundle(element);
        JView   view       = getView  (element);
        view.onCreating(viewBundle);
    }

    public void deleteView(Type element){
        removeViewByElement(element);
        removeView(element);
    }

    protected void removeViewByElement(Type element){}
    protected void createViewByElement(Type element){}

    protected abstract JBundle getBundle (Type element);
    protected abstract JView   getView   (Type element);
    protected abstract void    removeView(Type element);

}
