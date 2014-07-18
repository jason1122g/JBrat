package org.jbrat.generator

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout
import spock.lang.Shared
import spock.lang.Specification

class ViewGeneratorTest extends Specification {
    @Shared BeanContainer beanContainer = new BeanContainer(new BeanBuilder().build())

    def cleanupSpec(){
        new File("src/main/groovy/app").deleteDir()
    }

    def "generate a controller"(){
        given:
            def generator = new ViewGenerator(beanContainer)
            def filePath  = Layout.sourceLocation +"/"+ beanContainer.layout.viewLocation.replace('.','/')+"/MellowView.groovy"
        when:
            generator.generate("Mellow")
        then:
            new File(filePath).exists()
    }
}
