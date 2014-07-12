package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
class BeanContainer {

    private Bindable bean

    BeanContainer(Bindable bean){
        this.bean = bean
    }

    void setConfig(Bindable bean){
        this.bean.setProperty("config",bean)
    }

    Bindable getConfig(){
        return (Bindable) bean.getProperty("config")
    }

    void setComponent(Bindable bean){
        this.bean.setProperty("component",bean)
    }

    Bindable getComponent(){
        return (Bindable) bean.getProperty("component")
    }

    void setParam(Bindable param){
        this.bean.setProperty("param",param)
    }

    Bindable getParam(){
        return (Bindable) bean.getProperty("param")
    }

    void setLayout(Layout layout){
        makeSureConfigExist { Bindable bean ->
            ((Bindable)bean.getProperty("config")).setProperty("layout",layout)
        }
    }

    Layout getLayout(){
        return (Layout) ((Bindable)bean?.getProperty("config"))?.getProperty("layout")
    }

    void setLocale(String locale){
        makeSureConfigExist {Bindable bean ->
            ((Bindable)bean.getProperty("config")).setProperty("locale",locale)
        }
    }


    String getLocale(){
        return (String) ((Bindable)bean?.getProperty("config"))?.getProperty("locale")
    }

    private void makeSureConfigExist(Closure closure){
        if( ! bean.getProperty("config") ){
            this.bean.setProperty("config",BeanFactory.createEmpty())
        }
        closure.call(bean)
    }

}
