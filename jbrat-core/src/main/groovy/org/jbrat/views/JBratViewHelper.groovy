package org.jbrat.views

import groovy.transform.CompileStatic
import org.jbrat.core.JBrat
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
class JBratViewHelper {

    private static JBrat jBrat = JBrat.getInstance()

    static void render(String name,Bean bean) {
        jBrat.render(name,bean)
    }

    static String localeText(String name){
        jBrat.localeText(name)
    }

    static String t(String name){
        localeText(name)
    }

}
