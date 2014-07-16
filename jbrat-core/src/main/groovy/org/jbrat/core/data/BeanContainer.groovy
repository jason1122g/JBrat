package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
class BeanContainer {

    private Bean bean

    BeanContainer(Bean bean){
        this.bean = bean
    }

    void setConfig(Bean bean){
        this.bean.setProperty("config",bean)
    }

    Bean getConfig(){
        return getBeanProperty("config")
    }

    void setComponent(Bean bean){
        this.bean.setProperty("component",bean)
    }

    Bean getComponent(){
        return getBeanProperty("component")
    }

    void setParam(Bean param){
        this.bean.setProperty("param",param)
    }

    Bean getParam(){
        return getBeanProperty("param")
    }

    void setLayout(Layout layout){
        makeSureConfigExist {
            getBeanProperty("config").setProperty("layout", layout)
        }
    }

    Layout getLayout(){
        (Layout) getBeanProperty("config")?.getProperty("layout")
    }

    void setLocale(String locale){
        makeSureConfigExist {
            getBeanProperty("config").setProperty("locale", locale)
        }
    }

    String getLocale(){
        (String) getBeanProperty("config")?.getProperty("locale")
    }

    private Bean getBeanProperty(String name){
        (Bean) this.bean.getProperty(name)
    }

    private void makeSureConfigExist(Closure closure){
        if(!bean.getProperty("config")){
            bean.setProperty("config", BeanFactory.createEmpty() )
        }
        closure.call(bean)
    }

}
