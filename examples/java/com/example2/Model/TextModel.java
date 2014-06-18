package com.example2.Model;

import org.jbrat.models.unlimited.StringModel;

@SuppressWarnings("unused")
public class TextModel extends StringModel{
    public TextModel(){
        this.set("title","FinalProject");

        this.set("firstView-next" ,"NEXT");
        this.set("firstView-label" ,"This is View1");
        this.set("secondView-next","NEXT");
        this.set("secondView-label","This is View2");

        this.set("viewStatus","none");
        this.set("viewStart","Start");
        this.set("viewChange","Changed");
    }
}
