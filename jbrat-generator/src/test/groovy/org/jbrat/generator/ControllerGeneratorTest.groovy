package org.jbrat.generator

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout
import spock.lang.Shared
import spock.lang.Specification

class ControllerGeneratorTest extends Specification {

    @Shared BeanContainer beanContainer = new BeanContainer(new BeanBuilder().build())

    def cleanupSpec(){
        new File("src/main/groovy/app").deleteDir()
    }

    def "generate a controller"(){
        given:
            def generator = new ControllerGenerator(beanContainer)
            def filePath  = Layout.sourceLocation +"/"+ beanContainer.layout.controllerLocation.replace('.','/')+"/MellowController.groovy"
        when:
            generator.generate("Mellow")
        then:
            new File(filePath).exists()
    }

    def "generate a controller with category name"(){
        given:
            def generator = new ControllerGenerator(beanContainer)
            def filePath  = Layout.sourceLocation +"/"+ beanContainer.layout.controllerLocation.replace('.','/')+"/other/MellowController.groovy"
        when:
            generator.generate("other.Mellow")
        then:
            new File(filePath).exists()
    }
}
