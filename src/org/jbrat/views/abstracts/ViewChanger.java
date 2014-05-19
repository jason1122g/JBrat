package org.jbrat.views.abstracts;


import org.jbrat.models.abstracts.JBundle;

public abstract class ViewChanger<Type> {

    public void initView(Type element){
        initViewByElement(element);
        JBundle viewBundle = getBundle(element);
        JView   view       = getView  (element);
        view.onCreating(viewBundle);
    }

    protected void initViewByElement(Type element){}

    protected abstract JBundle getBundle (Type element);
    protected abstract JView   getView   (Type element);

}
