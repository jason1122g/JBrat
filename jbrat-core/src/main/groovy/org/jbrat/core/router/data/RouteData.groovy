package org.jbrat.core.router.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bean

@CompileStatic
class RouteData {
    def String path
    def Bean   bean
}
