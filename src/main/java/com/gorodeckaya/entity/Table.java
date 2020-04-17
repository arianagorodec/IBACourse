package com.gorodeckaya.entity;

import java.util.ArrayList;
import java.util.List;

public class Table {
    List<String> fields = new ArrayList<>();
    String name;

    public Table() {
    }

    public Table(List<String> fields, String name) {
        this.fields = fields;
        this.name = name;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addField(String field){
        fields.add(field);
    }
}
