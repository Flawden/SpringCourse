package ru.flawden.springcourse.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.flawden.springcourse.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setFirstname(resultSet.getString("firstname"));
        person.setSurname(resultSet.getString("surname"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}
