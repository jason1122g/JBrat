package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.JBrat
import org.jbrat.core.data.Bean

@CompileStatic
class JBratViewHelper {

    private static JBrat jBrat = JBrat.getInstance()

    static void render(String name,Bean bean) {
        jBrat.render(name,bean)
    }

    static void localeText(String name){
        jBrat.localeText(name)
    }

    static void t(String name){
        localeText(name)
    }

}
