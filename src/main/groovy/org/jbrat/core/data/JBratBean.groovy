package org.jbrat.core.data


class JBratBean {
    private def storage = [:]

    def getProperty(String name) {
        storage[name]
    }

    void setProperty(String name, value) {
        storage[name] = value
    }
}
