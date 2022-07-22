package ru.flawden.springcourse.dao;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new BeanPropertyRowMapper<>(Person.class), id).stream().findAny().orElse(null);
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

    public void testMultipleUpdate() {
        List<Person> people = create1000people();
        long before = System.currentTimeMillis();

        for (Person person: people) {
            jdbcTemplate.update("INSERT INTO Person(firstname, surname, age, email) VALUES(?, ?, ?, ?)",
                    person.getFirstname(), person.getSurname(), person.getAge(), person.getEmail());
        }

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));
    }

    private List<Person> create1000people() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            people.add(new Person("Firstname" + i, "Surname" + i, "Email" + i + "@Mail.ru", 30));
        }
        return people;
    }

    public void testBatchUpdate() {

        List<Person> people = create1000people();
        long before = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO Person(firstname, surname, age, email) VALUES(?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, people.get(i).getFirstname());
                ps.setString(2, people.get(i).getSurname());
                ps.setInt(3, people.get(i).getAge());
                ps.setString(4, people.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });

        long after = System.currentTimeMillis();
        System.out.println("Time: " + (after - before));

    }
}
