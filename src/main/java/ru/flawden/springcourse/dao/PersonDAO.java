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
        people.add(new Person(++PEOPLE_COUNT, "Nick", "Tomson", "Nick@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Rick", "Sanchez", "Rick@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Brick", "Stone", "Brick@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Connor", "MaCGregor", "Connor@mail.ru"));
    }

    public void createPerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public List<Person> peopleList() {
        return people;
    }

    public void updatePerson(Person person, Integer id) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setEmail(person.getEmail());
        personToBeUpdated.setFirstname(person.getFirstname());
        personToBeUpdated.setSurname(person.getSurname());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
