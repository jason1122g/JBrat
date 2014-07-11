package org.jbrat.core.data

import groovy.transform.CompileStatic

@CompileStatic
class Layout {
    private String controllerPosition = "app.controller"
    private String modelPosition      = "app.model"
    private String viewPosition       = "app.view"
    private String handlerPosition    = "app.handler"
    private String helperPosition     = "app.helper"

    private String base = Builder.getResourceBase()

    private String routesPosition     = "${base}/config"
    private String localesPosition    = "${base}/config/locales"
    private String applicationSettingPosition = "${base}/config"

    private String libPosition        = "${base}/lib"
    private String venderPosition     = "${base}/vender"
    private String logPosition        = "${base}/log"

    public Layout(Builder builder){
        builder.map.each {String key,String value->
            this.setProperty(key,value)
        }
    }

    String getControllerPosition() {
        return controllerPosition
    }

    String getModelPosition() {
        return modelPosition
    }

    String getViewPosition() {
        return viewPosition
    }

    String getHandlerPosition() {
        return handlerPosition
    }

    String getHelperPosition() {
        return helperPosition
    }

    String getRoutesPosition() {
        return routesPosition
    }

    String getLocalesPosition() {
        return localesPosition
    }

    String getApplicationSettingPosition() {
        return applicationSettingPosition
    }

    String getLibPosition() {
        return libPosition
    }

    String getVenderPosition() {
        return venderPosition
    }

    String getLogPosition() {
        return logPosition
    }

    public static class Builder{

        private Map map = [:]

        Layout build(){
            return new Layout(this)
        }

        static String getResourceBase(){
            return new File(Builder.class.getResource("/jbrat").toURI()).toString()
        }

        Builder setControllerPosition(String controllerPosition) {
            map["controllerPosition"] = controllerPosition
            return this
        }

        Builder setModelPosition(String modelPosition) {
            map["modelPosition"] = modelPosition
            return this
        }

        Builder setViewPosition(String viewPosition) {
            map["viewPosition"] = viewPosition
            return this
        }

        Builder setHandlerPosition(String handlerPosition) {
            map["handlerPosition"]  = handlerPosition
            return this
        }

        Builder setHelperPosition(String helperPosition) {
            map["helperPosition"] = helperPosition
            return this
        }

        Builder setRoutesPosition(String routesPosition) {
            map["routesPosition"] = routesPosition
            return this
        }

        Builder setLocalesPosition(String localesPosition) {
            map["localesPosition"] = localesPosition
            return this
        }

        Builder setLibPosition(String libPosition) {
            map["libPosition"] = libPosition
            return this
        }

        Builder setVenderPosition(String venderPosition) {
            map["venderPosition"] = venderPosition
            return this
        }

        Builder setLogPosition(String logPosition) {
            map["logPosition"] = logPosition
            return this
        }
    }
}
