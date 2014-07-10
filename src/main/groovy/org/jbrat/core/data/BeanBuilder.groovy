package org.jbrat.core.data


class BeanBuilder {

    private def bean = BeanFactory.createEmpty()
    private def beanContainer = new BeanContainer(bean)

    BeanBuilder(){
        beanContainer.setLayout(new  Layout.Builder().build())
        beanContainer.setLocale("enUS")
    }

    def setLayout(layout){
        beanContainer.setLayout(layout)
        return this
    }

    def setLocale(locale){
        beanContainer.setLocale(locale)
        return this
    }

    def build(){
        return bean
    }

}
