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
        return getBindableProperty("config")
    }

    void setComponent(Bindable bean){
        this.bean.setProperty("component",bean)
    }

    Bindable getComponent(){
        return getBindableProperty("component")
    }

    void setParam(Bindable param){
        this.bean.setProperty("param",param)
    }

    Bindable getParam(){
        return getBindableProperty("param")
    }

    void setLayout(Layout layout){
        makeSureConfigExist { Bindable bean ->
            getBindableProperty("config").setProperty("layout", layout)
        }
    }

    Layout getLayout(){
        (Layout) getBindableProperty("config")?.getProperty("layout")
    }

    void setLocale(String locale){
        makeSureConfigExist { Bindable bean ->
            getBindableProperty("config").setProperty("locale", locale)
        }
    }

    String getLocale(){
        (String) getBindableProperty("config")?.getProperty("locale")
    }

    private Bindable getBindableProperty(String name){
        (Bindable) this.bean.getProperty(name)
    }

    private void makeSureConfigExist(Closure closure){
        if( ! bean.getProperty("config") ){
            this.bean.setProperty("config", BeanFactory.createEmpty() )
        }
        closure.call(bean)
    }

}
