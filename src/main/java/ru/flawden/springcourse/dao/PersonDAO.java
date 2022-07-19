package ru.flawden.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.flawden.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT = 0;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Nick", "Tomson"));
        people.add(new Person(++PEOPLE_COUNT, "Rick", "Sanchez"));
        people.add(new Person(++PEOPLE_COUNT, "Brick", "Stone"));
        people.add(new Person(++PEOPLE_COUNT, "Connor", "MaCGregor"));
    }

    public Person person(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public List<Person> peopleList() {
        return people;
    }

}
