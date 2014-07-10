package org.jbrat.core.data

class BeanContainer {

    private def bean

    BeanContainer(bean){
        this.bean = bean
    }

    void setConfig(bean){
        this.bean.config = bean
    }

    Bean getConfig(){
        return bean?.config
    }

    void setComponent(bean){
        this.bean.component = bean
    }

    Bean getComponent(){
        return bean?.component
    }

    void setParam(param){
        this.bean.param = param
    }

    Bean getParam(){
        return bean?.param
    }

    void setLayout(layout){
        makeSureConfigExist { bean ->
            bean.config.layout = layout
        }
    }

    Layout getLayout(){
        return bean?.config?.layout
    }

    void setLocale(locale){
        makeSureConfigExist { bean ->
            bean.config.locale = locale
        }
    }


    String getLocale(){
        return bean?.config?.locale
    }

    private void makeSureConfigExist(Closure closure){
        if( ! bean.config ){
            this.bean.config = BeanFactory.createEmpty()
        }
        closure.call(bean)
    }

}
