package org.jbrat.core.router

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.router.filter.ControllerFilter
import spock.lang.Specification


class RouterCombineTest extends Specification{

    def "controllerRouter >> controllerFilter >> viewRouter"(){
        given:
            def bean = new BeanBuilder().build()
            def container = new BeanContainer(bean)
            def router = new ControllerRouter(container)
        and:
            router >> new ControllerFilter() >> new ViewRouter(container)
        when:
            def resultBean = router.route("other.runTask1")
            def resultContainer = new BeanContainer(resultBean)
        then:
            resultBean.className == "runTask1View"
            resultContainer.getConfig() == null
            resultContainer.getParam()  == null
    }
}
