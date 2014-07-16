package org.jbrat.core.tool

class Classer {
    static boolean classExists(String path){
        try{
            Class.forName(path)
        }catch(ClassNotFoundException ignore){
            return false
        }
        return true
    }
}
