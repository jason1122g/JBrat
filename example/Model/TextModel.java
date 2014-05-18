package Model;

import org.jbrat.models.CacheModel;


public class TextModel extends CacheModel<String>{
    public TextModel(){
        this.set("name","");
        this.set("type","");
    }
}
