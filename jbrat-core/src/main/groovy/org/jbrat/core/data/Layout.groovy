package org.jbrat.core.data

import groovy.transform.CompileStatic

@CompileStatic
class Layout {

    private String controllerLocation = "app.controller"
    private String modelLocation      = "app.model"
    private String viewLocation       = "app.view"
    private String handlerLocation    = "app.handler"
    private String helperLocation     = "app.helper"

    static final String sourceLocation = "src/main/groovy"
    static final String resourceBase   = "/jbrat"
    static final String configLocation = "${resourceBase}/config"
    private String routesLocation      = "${resourceBase}/config"
    private String localesLocation     = "${resourceBase}/config/locales"

    private String libLocation        = "${resourceBase}/lib"
    private String venderLocation     = "${resourceBase}/vender"
    private String logLocation        = "logs"

    public Layout(Builder builder){
        builder.map.each {String key,String value->
            if(value != null){
                this.setProperty(key,value)
            }
        }
    }

    static String getResourceBase(){
        return resourceBase
    }

    String getControllerLocation() {
        return controllerLocation
    }

    String getModelLocation() {
        return modelLocation
    }

    String getViewLocation() {
        return viewLocation
    }

    String getHandlerLocation() {
        return handlerLocation
    }

    String getHelperLocation() {
        return helperLocation
    }

    String getRoutesLocation() {
        return routesLocation
    }

    String getLocalesLocation() {
        return localesLocation
    }

    String getLibLocation() {
        return libLocation
    }

    String getVenderLocation() {
        return venderLocation
    }

    String getLogLocation() {
        return logLocation
    }

    public static class Builder{

        private Map map = [:]

        Layout build(){
            return new Layout(this)
        }

        Builder setControllerLocation(String controllerLocation) {
            map["controllerLocation"] = controllerLocation
            return this
        }

        Builder setModelLocation(String modelLocation) {
            map["modelLocation"] = modelLocation
            return this
        }

        Builder setViewLocation(String viewLocation) {
            map["viewLocation"] = viewLocation
            return this
        }

        Builder setHandlerLocation(String handlerLocation) {
            map["handlerLocation"]  = handlerLocation
            return this
        }

        Builder setHelperLocation(String helperLocation) {
            map["helperLocation"] = helperLocation
            return this
        }

        Builder setRoutesLocation(String routesLocation) {
            map["routesLocation"] = routesLocation
            return this
        }

        Builder setLocalesLocation(String localesLocation) {
            map["localesLocation"] = localesLocation
            return this
        }

        Builder setLibLocation(String libLocation) {
            map["libLocation"] = libLocation
            return this
        }

        Builder setVenderLocation(String venderLocation) {
            map["venderLocation"] = venderLocation
            return this
        }

        Builder setLogLocation(String logLocation) {
            map["logLocation"] = logLocation
            return this
        }
    }
}
