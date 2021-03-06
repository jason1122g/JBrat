package org.jbrat.launcher

import groovy.transform.CompileStatic
import org.jbrat.core.config.AppConfig
import org.jbrat.core.config.FileConfigReader
import org.jbrat.exceptions.ResourceNotFoundError
import org.jbrat.generator.ControllerGenerator
import org.jbrat.generator.HelperGenerator
import org.jbrat.generator.ViewGenerator

@CompileStatic
class JBratGenerator {

    static void main(String[] args){
        if(args.length == 2){
            def type = args[0].toLowerCase()
            def name = args[1]
            switch (type){
                case "view":
                    generateView(name)
                    break
            }
        }
    }

    private static void generateView(String name){
        try{
            def beanContainer = new AppConfig(new FileConfigReader()).asBeanContainer()
            new ControllerGenerator(beanContainer).generate(name)
            new ViewGenerator      (beanContainer).generate(name)
            new HelperGenerator    (beanContainer).generate(name)
        }catch (ResourceNotFoundError e){
            System.out.println(e.getMessage())
        }
    }

}
