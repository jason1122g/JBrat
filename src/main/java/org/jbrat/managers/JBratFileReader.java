package org.jbrat.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

class JBratFileReader {

    public static String readFullFile(String path) throws IOException{
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while(line != null){
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

            int endDelIndex   = stringBuilder.length();
            int startDelIndex = endDelIndex-System.lineSeparator().length();
            stringBuilder.delete(startDelIndex,endDelIndex);

            return stringBuilder.toString();
        }
    }

    public static String readFullFile(File file) throws IOException{
        return readFullFile(file.toString());
    }

    public static String readResourceFile(String path) throws IOException, URISyntaxException{
        return readFullFile(new File(JBratFileReader.class.getResource(path).toURI()));
    }
}
