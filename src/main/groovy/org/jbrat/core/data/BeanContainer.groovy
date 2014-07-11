package org.jbrat.core.data

import groovy.transform.CompileStatic

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
        return (Bean) bean.getProperty("config")
    }

    void setComponent(Bean bean){
        this.bean.setProperty("component",bean)
    }

    Bean getComponent(){
        return (Bean) bean.getProperty("component")
    }

    void setParam(Bean param){
        this.bean.setProperty("param",param)
    }

    Bean getParam(){
        return (Bean) bean.getProperty("param")
    }

    void setLayout(Layout layout){
        makeSureConfigExist { Bean bean ->
            ((Bean)bean.getProperty("config")).setProperty("layout",layout)
        }
    }

    Layout getLayout(){
        return (Layout) ((Bean)bean?.getProperty("config"))?.getProperty("layout")
    }

    void setLocale(String locale){
        makeSureConfigExist {Bean bean ->
            ((Bean)bean.getProperty("config")).setProperty("locale",locale)
        }
    }


    String getLocale(){
        return (String) ((Bean)bean?.getProperty("config"))?.getProperty("locale")
    }

    private void makeSureConfigExist(Closure closure){
        if( ! bean.getProperty("config") ){
            this.bean.setProperty("config",BeanFactory.createEmpty())
        }
        closure.call(bean)
    }

}
