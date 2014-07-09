package org.jbrat.core.data.container

import org.jbrat.core.data.JBratBean
import org.jbrat.core.data.Layout


class BeanContainer {

    private def bean

    BeanContainer(bean){
        this.bean = bean
    }

    void setConfig(bean){
        this.bean.config = bean
    }

    JBratBean getConfig(){
        return bean.config
    }

    void setComponent(bean){
        this.bean.component = bean
    }

    JBratBean getComponent(){
        return bean.component
    }

    void setParam(bean){
        this.bean.param = bean
    }

    JBratBean getParam(){
        return bean.param
    }

    void setLayout(bean){
        this.bean.config.layout = bean
    }

    Layout getLayout(){
        return bean.config.layout
    }


    void setLocale(locale){
        this.bean.config.locale = locale
    }


    String getLocale(){
        return bean.config.locale
    }

}
