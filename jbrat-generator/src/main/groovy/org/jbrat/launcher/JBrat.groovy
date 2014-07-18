package org.jbrat.launcher

import org.jbrat.tool.FileTool

/** TODO TEST AND FINISH THIS*/
class JBrat {
    static void main(String[] args){
        if(args.length >= 2){
            switch (args[0]){
                case "init":
                    generateProject(args[1])
                    break
                case "g":
                    JBratGenerator.main([args[1],args[2]] as String[])
                    break
            }
        }
    }

    private static void generateProject(String name){
        def targetDir = new File(name)
        def sourceDir = new File(this.class.getResource("/demo").toURI())
        if(targetDir.exists()){
            System.out.println("File Already Exists"+targetDir.getAbsolutePath())
        }else{
            targetDir.mkdir()
            FileTool.recursiveCopy(sourceDir,targetDir)
        }
    }
}
