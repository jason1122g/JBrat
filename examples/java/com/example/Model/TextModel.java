package com.example.Model;

import org.jbrat.models.unlimited.StringModel;

@SuppressWarnings("unused")
public class TextModel extends StringModel{
    public TextModel(){
        this.set("name","exampleName");
        this.set("type","exampleType");
    }
}
