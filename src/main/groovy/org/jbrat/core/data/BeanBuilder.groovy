package org.jbrat.core.data


class BeanBuilder {

    private def bean

    BeanBuilder(){
        bean        = BeanFactory.createEmpty()
        bean.config = BeanFactory.createEmpty()
        bean.config.layout = new  Layout.Builder().build()
        bean.config.locale = "enUS"
    }

    def setLayout(layout){
        bean.config.layout = layout
        return this
    }

    def setLocale(locale){
        bean.config.locale = locale
        return this
    }

    def build(){
        return bean
    }

}
