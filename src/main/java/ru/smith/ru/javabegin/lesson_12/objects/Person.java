package ru.smith.ru.javabegin.lesson_12.objects;

import lombok.*;

@Data
public class Person {

    @NonNull
    private String name;

    @NonNull
    private String lastName;

    @NonNull
    private String nameFather;

    @NonNull
    private String phone;
}
