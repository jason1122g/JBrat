package com.example.Model;

import org.jbrat.models.unlimited.StringModel;

public class AJAXModel extends StringModel {

    @Override
    protected String getter(String name) {
        return null; //DO AJAX
    }

    @Override
    protected void setter(String name, String data) {
        //DO AJAX
    }
}
