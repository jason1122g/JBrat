package app

import org.jbrat.launcher.JBrat


class Launcher {
    static void main(String[]args){
        JBrat.getInstance().route("root")
    }
}
