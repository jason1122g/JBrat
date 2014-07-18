package org.jbrat.generator.abstracts

import org.jbrat.core.data.Layout
import org.jbrat.tool.StringTemplate

import java.util.regex.Matcher

abstract class BasicGenerator implements Generator{

    @Override
    void generate(String name) {
        Matcher uriMatcher = name =~ /^(.+\.)?(\w+)$/
        if(uriMatcher.matches()){
            def categoryPath = uriMatcher.group(1)
            def fileName     = uriMatcher.group(2)

            prepareTemplate( categoryPath==null ? ""  :categoryPath ,fileName)
        }else{
            throw new Exception("Format mismatch:"+name)
        }
    }

    private void prepareTemplate(String categoryPath, String fileName){
        def directoryPath = getComponentPackage() + "/" + categoryPath
        def packagePath   = Layout.sourceLocation + "/" + directoryPath.replace('.','/')
        def filePath = packagePath + fileName + getFileNameSuffix()
        def template = getStringTemplate (fileName)

        def packageSuffix = categoryPath=="" ? "" : "."+categoryPath.substring(0,categoryPath.length()-1)
        template.setProperty("name",fileName)
        template.setProperty("package",packageSuffix)

        new File(packagePath).mkdirs()
        generateFile(filePath,template.toString())
    }

    private static void generateFile(String filePath, String content){
        File file = new File(filePath)
        if(file.exists()){
            System.out.println("File Already Exists:"+ file.getAbsolutePath())
        }else{
            file.write(content)
            System.out.println("Genarate:${filePath}")
        }
    }

    protected abstract String getComponentPackage()
    protected abstract String getFileNameSuffix()
    protected abstract StringTemplate getStringTemplate(String fileName)
}
