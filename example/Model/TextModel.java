package Model;

import org.jbrat.models.CacheModel;


class TextModel extends CacheModel<String>{
    public TextModel(){
        this.set("name","");
        this.set("type","");
    }
}
