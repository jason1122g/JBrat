package org.jbrat.core.router.data

import groovy.transform.CompileStatic
import org.jbrat.core.data.abstracts.Bindable

@CompileStatic
class RouteData {
    def String   path
    def Bindable bean
}
