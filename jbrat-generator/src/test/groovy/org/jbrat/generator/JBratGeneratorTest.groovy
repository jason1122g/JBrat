package org.jbrat.generator

import spock.lang.Shared
import spock.lang.Specification

class JBratGeneratorTest extends Specification {

    @Shared boolean isAppDirNeedDelete = true
    def setupSpec(){
        def dir = new File("src/main/groovy/app")
        if(dir.exists()){
            isAppDirNeedDelete = false
        }
        new File("src/main/groovy/app/controller").mkdirs()
        new File("src/main/groovy/app/view").mkdir()
        new File("src/main/groovy/app/helper").mkdir()
    }

    def cleanupSpec(){
        if(isAppDirNeedDelete){
            new File("src/main/groovy/app").deleteDir()
        }else{
            new File("src/main/groovy/app/controller/HelloController.groovy").delete()
            new File("src/main/groovy/app/view/HelloView.groovy"    ).delete()
            new File("src/main/groovy/app/helper/HelloHelper.groovy").delete()
        }
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
