package org.jbrat.core.config

import org.jbrat.core.config.abstracts.ConfigReader
import org.jbrat.core.data.Layout
import org.jbrat.core.tool.PropertiesBuilder
import org.jbrat.exceptions.ResourceNotFoundError

class FileConfigReader implements ConfigReader{

    private def appConfigPath1 = Layout.distBase + Layout.configLocation + "/application.properties"
    private def appConfigPath2 = "src/test/resources"+ Layout.configLocation + "/application.properties"

    @Override
    Properties read() {
        def property
        try{
            property = new PropertiesBuilder().fromFile(appConfigPath1).build()
        }catch (Exception ignore){
            try{
                property = new PropertiesBuilder().fromFile(appConfigPath2).build()
            }catch (Exception ignored){
                throw new ResourceNotFoundError("Cannot find applicaiotn.properties")
            }
        }
        return property
    }

}
