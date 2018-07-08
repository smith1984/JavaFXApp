package ru.smith.ru.javabegin.lesson_12.objects;

import javafx.beans.property.SimpleStringProperty;
import lombok.*;

@ToString
@EqualsAndHashCode
public class Person {

    private SimpleStringProperty name = new SimpleStringProperty("");

    private SimpleStringProperty lastName = new SimpleStringProperty("");;

    private SimpleStringProperty nameFather = new SimpleStringProperty("");;

    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Person(String name, String lastName, String nameFather, String phone) {
        this.name = new SimpleStringProperty(name);
        this.lastName = new SimpleStringProperty(lastName);
        this.nameFather = new SimpleStringProperty(nameFather);
        this.phone = new SimpleStringProperty(phone);
    }

    public Person() {
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getNameFather() {
        return nameFather.get();
    }

    public void setNameFather(String nameFather) {
        this.nameFather.set(nameFather);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty nameProperty (){
        return name;
    }

    public SimpleStringProperty lastNameProperty (){
        return lastName;
    }

    public SimpleStringProperty nameFatherProperty (){
        return nameFather;
    }

    public SimpleStringProperty phoneProperty (){
        return phone;
    }
}
