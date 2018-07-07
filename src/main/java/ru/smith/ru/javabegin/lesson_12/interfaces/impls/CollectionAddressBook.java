package ru.smith.ru.javabegin.lesson_12.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Data;
import lombok.NonNull;
import ru.smith.ru.javabegin.lesson_12.interfaces.AddressBook;
import ru.smith.ru.javabegin.lesson_12.objects.Person;


@Data
public class CollectionAddressBook implements AddressBook {

    @NonNull
    private ObservableList<Person> personArrayList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personArrayList.add(person);
    }

    @Override
    public void update(Person person, Person person2) {
        this.delete(person);
        this.add(person2);
    }

    @Override
    public void delete(Person person) {
        personArrayList.remove(person);
    }

    public void print(){
        personArrayList.stream().forEach(e -> System.out.println(e));
    }

    public void fillData(){
        for(int i =0; i < 10; i++)
            this.add(new Person("Максим" + i,
                    "Петров","Петрович","+79185296234"));
    }
}
