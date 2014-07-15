package demo.src.main.groovy.app

import org.jbrat.core.JBrat


class Launcher {
    static void main(String[]args){
        JBrat.getInstance().route("root")
    }
}
