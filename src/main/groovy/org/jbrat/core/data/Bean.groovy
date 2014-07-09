package org.jbrat.core.data


class Bean { //TODO FINISH AND TEST THIS

    private def storage = [:]

    def getProperty(String name) {
        storage[name]
    }

    void setProperty(String name, value) {
        storage[name] = value
    }

}
