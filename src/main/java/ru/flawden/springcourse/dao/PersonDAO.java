package ru.flawden.springcourse.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.flawden.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String URL = "jdbc:postgresql://localhost:5432/SpringCourse";
    private static final String username = "postgres";
    private static final String password = "password";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createPerson(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Person(firstname, surname, age, email) VALUES(?, ?, ?, ?)");
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getSurname());
            statement.setInt(3, person.getAge());
            statement.setString(4, person.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?",new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    public List<Person> peopleList() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    public void updatePerson(Person person, Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Person " +
                    "SET firstname = ?," +
                    "surname = ?," +
                    "age = ?," +
                    "email = ?" +
                    "WHERE id = ?");
            statement.setString(1, person.getFirstname());
            statement.setString(2, person.getSurname());
            statement.setInt(3, person.getAge());
            statement.setString(4, person.getEmail());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Person WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
