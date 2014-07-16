package org.jbrat.core.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean


@CompileStatic
class BeanBuilder {

    private Bean bean = BeanFactory.createEmpty()
    private BeanContainer beanContainer = new BeanContainer(bean)

    BeanBuilder(){
        def defaultLayout = new  Layout.Builder().build()
        def defaultLocale = "enUS"
        beanContainer.setLayout(defaultLayout)
        beanContainer.setLocale(defaultLocale)
    }

    BeanBuilder setLayout(Layout layout){
        beanContainer.setLayout(layout)
        return this
    }

    BeanBuilder setLocale(String locale){
        beanContainer.setLocale(locale)
        return this
    }

    Bean build(){
        return bean
    }

}
