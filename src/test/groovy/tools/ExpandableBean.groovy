package tools


class ExpandableBean {
    private def storage = [:]

    def getProperty(String name) {
        storage[name]
    }

    void setProperty(String name, value) {
        storage[name] = value
    }
}
