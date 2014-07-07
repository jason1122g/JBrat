package org.jbrat.views

import org.jbrat.core.JBrat


class JBratViewHelper {

    static void render(name, bean) {
        JBrat.render(name,bean)
    }

    static void localeText(stringName){
        JBrat.localeText(stringName)
    }

    static void t(stringName){
        localeText(stringName)
    }
}
