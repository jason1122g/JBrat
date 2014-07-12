package org.jbrat.core.data

import groovy.transform.CompileStatic

@CompileStatic
class Layout {
    private String controllerLocation = "app.controller"
    private String modelLocation = "app.model"
    private String viewLocation = "app.view"
    private String handlerLocation = "app.handler"
    private String helperLocation = "app.helper"

    private String base = Builder.getResourceBase()

    private String routesLocation = "${base}/config"
    private String localesLocation = "${base}/config/locales"
    private String configLocation = "${base}/config"

    private String libLocation = "${base}/lib"
    private String venderLocation = "${base}/vender"
    private String logLocation = "${base}/log"

    public Layout(Builder builder){
        builder.map.each {String key,String value->
            if(value != null){
                this.setProperty(key,value)
            }
        }
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

    String getConfigLocation() {
        return configLocation
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

        static String getResourceBase(){
            return new File(Builder.class.getResource("/jbrat").toURI()).toString()
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
