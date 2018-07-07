package ru.smith.ru.javabegin.lesson_12.interfaces;

import ru.smith.ru.javabegin.lesson_12.objects.Person;

public interface AddressBook {
    void add(Person person);
    void update(Person person, Person person2);
    void delete(Person person);
}
