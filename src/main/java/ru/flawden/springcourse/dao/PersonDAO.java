package ru.flawden.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.flawden.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

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
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstname(resultSet.getString("firstname"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                return person;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> peopleList() {
        List<Person> people = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setFirstname(resultSet.getString("firstname"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }

    public void updatePerson(Person person, Integer id) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setEmail(person.getEmail());
        personToBeUpdated.setFirstname(person.getFirstname());
        personToBeUpdated.setSurname(person.getSurname());
        personToBeUpdated.setAge(person.getAge());
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Person " +
                    "SET firstname = ?," +
                    "surname = ?," +
                    "age = ?," +
                    "email = ?" +
                    "WHERE id = ?");
            statement.setString(1, personToBeUpdated.getFirstname());
            statement.setString(2, personToBeUpdated.getSurname());
            statement.setInt(3, personToBeUpdated.getAge());
            statement.setString(4, personToBeUpdated.getEmail());
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
