package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.JBrat

@CompileStatic
class JBratViewHelper {

    private static JBrat jBrat = JBrat.getInstance()

    static void render(name, bean) {
        jBrat.render(name,bean)
    }

    static void localeText(stringName){
        jBrat.localeText(stringName)
    }

    static void t(stringName){
        localeText(stringName)
    }

}
