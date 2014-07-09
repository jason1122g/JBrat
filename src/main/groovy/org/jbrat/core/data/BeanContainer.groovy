package org.jbrat.core.data

class BeanContainer { //TODO TEST THIS

    private def bean

    BeanContainer(bean){
        this.bean = bean
    }

    void setConfig(bean){
        this.bean.config = bean
    }

    Bean getConfig(){
        return bean.config
    }

    void setComponent(bean){
        this.bean.component = bean
    }

    Bean getComponent(){
        return bean.component
    }

    void setParam(bean){
        this.bean.param = bean
    }

    Bean getParam(){
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
