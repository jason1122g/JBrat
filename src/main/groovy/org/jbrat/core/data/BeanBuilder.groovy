package org.jbrat.core.data

import groovy.transform.CompileStatic


@CompileStatic
class BeanBuilder {

    private Bean bean = BeanFactory.createEmpty()
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

    Bean build(){
        return bean
    }

}
