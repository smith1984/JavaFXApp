package ru.smith.jirnitonijfx.listview.model;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty name;

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Person(SimpleStringProperty name) {
        this.name = name;
    }

    public Person(String name){
        this.name = new SimpleStringProperty(name);
    }

    @Override
    public String toString() {
        return name.get();
    }
}
