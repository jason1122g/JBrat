package org.jbrat.generator

import spock.lang.Specification

class JBratGeneratorTest extends Specification {

    def setupSpec(){
        new File("src/main/groovy/app/controller").mkdirs()
        new File("src/main/groovy/app/view").mkdir()
        new File("src/main/groovy/app/helper").mkdir()
        FileTool.recursiveCopy("src/source/templates","templates")
    }

    def cleanupSpec(){
        new File("src/main/groovy/app/controller/HelloController.groovy").delete()
        new File("src/main/groovy/app/view/HelloView.groovy"    ).delete()
        new File("src/main/groovy/app/helper/HelloHelper.groovy").delete()
        new File("templates").deleteDir()
    }

    def "generate view will lead to three new files"(){
        when:
            JBratGenerator.main(["view","Hello"] as String[])
        then:
            new File("src/main/groovy/app/controller/HelloController.groovy").exists()
            new File("src/main/groovy/app/view/HelloView.groovy"    ).exists()
            new File("src/main/groovy/app/helper/HelloHelper.groovy").exists()
    }

}
