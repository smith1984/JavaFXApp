package ru.smith.ru.javabegin.lesson_12.objects;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

    private String name;
    private String lastName;
    private String nameFather;
    private String phone;
}
