package org.jbrat.core.config

import org.jbrat.core.config.abstracts.ConfigReader
import org.jbrat.core.data.Layout
import org.jbrat.core.tool.PropertiesBuilder

class ResourceConfigReader implements ConfigReader{

    private def appConfigPath = Layout.getConfigLocation() + "/application.properties"

    @Override
    Properties read() {
        return new PropertiesBuilder().fromResource(appConfigPath).build()
    }
}
