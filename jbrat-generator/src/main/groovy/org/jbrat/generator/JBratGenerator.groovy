package org.jbrat.generator

import groovy.transform.CompileStatic

@CompileStatic
class JBratGenerator {

    static void main(String[] args){
        if(args.length == 2){
            def type = args[0].toLowerCase()
            def name = args[1]
            switch (type){
                case "view":
                    generateView(name)
                    break
                case "init":
                    generateProject(name)
                    break
            }
        }
    }

    private static void generateView(String name){
        writeTemplate(new JBratTemplate(name,JBratTemplate.CONTROLLER).toString(), name, "Controller")
        writeTemplate(new JBratTemplate(name,JBratTemplate.VIEW      ).toString(), name, "View")
        writeTemplate(new JBratTemplate(name,JBratTemplate.HELPER    ).toString(), name, "Helper")
    }

    private static void writeTemplate(String template,String name,String type){
        def filePath = "src/main/groovy/app/${type.toLowerCase()}/${name}${type.capitalize()}.groovy"
        File file = new File(filePath)
        if(file.exists()){
            System.out.println("File Already Exists:"+ file.getAbsolutePath())
        }else{
            file.write(template)
            System.out.println("Genarate:${filePath}")
        }
    }

    private static void generateProject(String name){
        def targetDir = new File(name)
        def sourceDir = new File("demo")
        if(targetDir.exists()){
            throw new IOException("File Already Exists"+targetDir.getAbsolutePath())
        }else{
            targetDir.mkdir()
            FileTool.recursiveCopy(sourceDir,targetDir)
        }
    }

}
