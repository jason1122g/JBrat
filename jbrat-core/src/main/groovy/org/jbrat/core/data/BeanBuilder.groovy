package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable


@CompileStatic
class BeanBuilder {

    private Bindable      bean = BeanFactory.createEmpty()
    private BeanContainer beanContainer = new BeanContainer(bean)

    BeanBuilder(){
        beanContainer.setLayout(new  Layout.Builder().build())
        beanContainer.setLocale("enUS")
    }

    BeanBuilder setLayout(Layout layout){
        beanContainer.setLayout(layout)
        return this
    }

    BeanBuilder setLocale(String locale){
        beanContainer.setLocale(locale)
        return this
    }

    Bindable build(){
        return bean
    }

}
