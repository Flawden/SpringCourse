package ru.flawden.springcourse.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.flawden.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createPerson(Person person) {
        jdbcTemplate.update("INSERT INTO Person(firstname, surname, age, email) VALUES(?, ?, ?, ?)", person.getFirstname(), person.getSurname(), person.getAge(), person.getEmail());
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?",new Object[]{id}, new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public List<Person> peopleList() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void updatePerson(Person person, Integer id) {
        jdbcTemplate.update("UPDATE Person SET firstname = ?, surname = ?, age = ?, email = ? WHERE id = ?", person.getFirstname(), person.getSurname(), person.getAge(), person.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
