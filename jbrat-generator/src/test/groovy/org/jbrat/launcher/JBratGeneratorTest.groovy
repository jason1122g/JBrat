package org.jbrat.launcher

import spock.lang.Specification

class JBratGeneratorTest extends Specification {

    def cleanupSpec(){
        new File("src/main/groovy/app").deleteDir()
    }

    def "generate view"(){
        when:
            JBratGenerator.main(["view","Gundam"] as String[])
        then:
            new File("src/main/groovy/app/controller/GundamController.groovy").exists()
            new File("src/main/groovy/app/view/GundamView.groovy"    ).exists()
            new File("src/main/groovy/app/helper/GundamHelper.groovy").exists()
    }

    def "generate view with dir prefix"(){
        when:
            JBratGenerator.main(["view","other.Gundam"] as String[])
        then:
            new File("src/main/groovy/app/controller/other/GundamController.groovy").exists()
            new File("src/main/groovy/app/view/other/GundamView.groovy"    ).exists()
            new File("src/main/groovy/app/helper/other/GundamHelper.groovy").exists()
    }

    def "throw exception if application.properties is not in class path"(){
        //TODO TOO HARD TO TEST
    }

}
