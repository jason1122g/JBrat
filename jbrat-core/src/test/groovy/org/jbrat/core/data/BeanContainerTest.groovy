package org.jbrat.core.data

import spock.lang.Specification


class BeanContainerTest extends Specification {

    def "get non-exist property get null"(){
        given:
            def bean = BeanFactory.createEmpty()
            def container = new BeanContainer(bean)
        expect:
            container.getConfig()    == null
            container.getComponent() == null
            container.getParam()     == null
            container.getLayout()    == null
            container.getLocale()    == null
    }

    def "get correct properties from the value you set"(){
        given:
            def bean = BeanFactory.createEmpty()
            def container = new BeanContainer(bean)
        when:
            container.setComponent(BeanFactory.createEmpty())
            container.setParam    (BeanFactory.createEmpty())
            container.setLayout(new Layout.Builder().build())
            container.setLocale("zhTW")
        then:
            container.getComponent() != null
            container.getParam()     != null
            container.getLayout()    != null
            container.getLocale()    == "zhTW"
    }

    def "config property effects layout and locale"(){
        given:
            def bean = BeanFactory.createEmpty()
            def container = new BeanContainer(bean)
        when:
            container.setLayout(new Layout.Builder().build())
            container.setLocale("zhTW")
        and:
            container.setConfig(null)
        then:
            container.getLayout()    == null
            container.getLocale()    == null
    }

}
