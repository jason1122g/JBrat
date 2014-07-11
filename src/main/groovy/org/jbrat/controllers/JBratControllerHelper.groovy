package org.jbrat.controllers

import groovy.transform.CompileStatic
import org.jbrat.core.JBrat

@CompileStatic
class JBratControllerHelper {

    private static JBrat jBrat = JBrat.getInstance()

    static void route(path) {
        jBrat.route(path)
    }

}
