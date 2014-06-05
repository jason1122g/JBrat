import org.jbrat.managers.JBratManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        JBratManager mainManager = JBratManager.createInstance("main");
        try {
            mainManager.loadAttrModel   ("example.attrm");
            mainManager.loadAttrView    ("example.attrv");
            mainManager.loadAttrCombiner("example.attrc");
            mainManager.createViewResource("firstView");
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
