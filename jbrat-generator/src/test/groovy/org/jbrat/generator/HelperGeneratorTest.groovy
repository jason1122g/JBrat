package org.jbrat.generator

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout
import spock.lang.Shared
import spock.lang.Specification

class HelperGeneratorTest extends Specification {

    @Shared BeanContainer beanContainer = new BeanContainer(new BeanBuilder().build())

    def cleanupSpec(){
        new File("src/main/groovy/app").deleteDir()
    }

    def "generate a controller"(){
        given:
            def generator = new HelperGenerator(beanContainer)
            def filePath  = Layout.sourceLocation +"/"+ beanContainer.layout.helperLocation.replace('.','/')+"/MellowHelper.groovy"
        when:
            generator.generate("Mellow")
        then:
            new File(filePath).exists()
    }
}
