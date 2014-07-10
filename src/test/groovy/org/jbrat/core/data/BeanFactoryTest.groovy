package org.jbrat.core.data

import spock.lang.Specification


class BeanFactoryTest extends Specification {
    def "create empty bean"(){
        given:
            def bean = BeanFactory.createEmpty()
            def propertyList = []
        when:
            bean.getProperties().each {key,value->
                propertyList << key
            }
        then : "it has only one property which is itself"
            propertyList.size() == 1
    }
}
