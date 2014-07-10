package org.jbrat.core.data

class Layout {
    private def controllerPosition = "app.controller"
    private def modelPosition      = "app.model"
    private def viewPosition       = "app.view"
    private def handlerPosition    = "app.handler"
    private def helperPosition     = "app.helper"

    private def base = Builder.getResourceBase()

    private def routesPosition     = "${base}/config"
    private def localesPosition    = "${base}/config/locales"
    private def applicationSettingPosition = "${base}/config"

    private def libPosition        = "${base}/lib"
    private def venderPosition     = "${base}/vender"
    private def logPosition        = "${base}/log"

    public Layout(Builder builder){
        builder.map.each { key,value->
            this."$key" = value
        }
    }

    def getControllerPosition() {
        return controllerPosition
    }

    def getModelPosition() {
        return modelPosition
    }

    def getViewPosition() {
        return viewPosition
    }

    def getHandlerPosition() {
        return handlerPosition
    }

    def getHelperPosition() {
        return helperPosition
    }

    def getRoutesPosition() {
        return routesPosition
    }

    def getLocalesPosition() {
        return localesPosition
    }

    def getApplicationSettingPosition() {
        return applicationSettingPosition
    }

    def getLibPosition() {
        return libPosition
    }

    def getVenderPosition() {
        return venderPosition
    }

    def getLogPosition() {
        return logPosition
    }

    public static class Builder{

        private def map = [:]

        Layout build(){
            return new Layout(this)
        }

        def static getResourceBase(){
            return new File(this.getClass().getResource("/jbrat").toURI()).toString()
        }

        def setControllerPosition(controllerPosition) {
            map["controllerPosition"] = controllerPosition
            return this
        }

        def setModelPosition(modelPosition) {
            map["modelPosition"] = modelPosition
            return this
        }

        def setViewPosition(viewPosition) {
            map["viewPosition"] = viewPosition
            return this
        }

        def setHandlerPosition(handlerPosition) {
            map["handlerPosition"]  = handlerPosition
            return this
        }

        def setHelperPosition(helperPosition) {
            map["helperPosition"] = helperPosition
            return this
        }

        def setRoutesPosition(routesPosition) {
            map["routesPosition"] = routesPosition
            return this
        }

        def setLocalesPosition(localesPosition) {
            map["localesPosition"] = localesPosition
            return this
        }

        def setLibPosition(libPosition) {
            map["libPosition"] = libPosition
            return this
        }

        def setVenderPosition(venderPosition) {
            map["venderPosition"] = venderPosition
            return this
        }

        def setLogPosition(logPosition) {
            map["logPosition"] = logPosition
            return this
        }
    }
}
