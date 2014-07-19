package org.jbrat.generator

import org.jbrat.core.data.BeanBuilder
import org.jbrat.core.data.BeanContainer
import org.jbrat.core.data.Layout
import spock.lang.Shared
import spock.lang.Specification

class GeneratorsTest extends Specification{

    @Shared BeanContainer beanContainer = new BeanContainer(new BeanBuilder().build())

    def cleanupSpec(){
        new File("src/main/groovy/app").deleteDir()
    }

    def "generate a controller"(){
        given:
            def generator = customGenerator
            def sourceDir = Layout.sourceBase +"/"+ beanContainer.layout.getProperty(location).replace('.','/')
        and:
            def file  = new File(sourceDir + filePath)
        when:
            generator.generate(targetName)
        then:
            file.exists()
        and:
            file.text == new File(getResourceURI(comparedFileName)).text

        where:
            customGenerator                        |location            |filePath                        |targetName     | comparedFileName
            new ControllerGenerator(beanContainer) |"controllerLocation"|"/MellowController.groovy"      | "Mellow"      | "/Mellow_Controller.txt"
            new HelperGenerator    (beanContainer) |"helperLocation"    |"/MellowHelper.groovy"          | "Mellow"      | "/Mellow_Helper.txt"
            new ViewGenerator      (beanContainer) |"viewLocation"      |"/MellowView.groovy"            | "Mellow"      | "/Mellow_View.txt"
            new ControllerGenerator(beanContainer) |"controllerLocation"|"/other/InnerController.groovy" | "other.Inner" | "/other/Inner_Controller.txt"
            new HelperGenerator    (beanContainer) |"helperLocation"    |"/other/InnerHelper.groovy"     | "other.Inner" | "/other/Inner_Helper.txt"
            new ViewGenerator      (beanContainer) |"viewLocation"      |"/other/InnerView.groovy"       | "other.Inner" | "/other/Inner_View.txt"

    }

    private URI getResourceURI(String path){
        return this.class.getResource(path).toURI()
    }
}
