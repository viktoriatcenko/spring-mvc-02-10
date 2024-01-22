package ru.maxima.dao;

import org.springframework.stereotype.Component;
import ru.maxima.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PersonDAO {
    // DAO - data access object - доступ к данным объектов

//    private List<Person> people = new ArrayList<>();

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static final Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from person";
            ResultSet resultSet = statement.executeQuery(SQL);


            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                allPeople.add(person);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return allPeople;
    }

    public Person findById(Long id) {
        Person person = null;
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from person where id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getLong("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person) {
        try {

            PreparedStatement preparedStatement
                    = connection.prepareStatement("insert into person(name, age, email) values (?, ?, ?)");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Long id, Person editedPerson) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("update person " +
                    "set name = ?, age = ?, email = ?" +
                    " where id = ?;");
            preparedStatement.setString(1, editedPerson.getName());
            preparedStatement.setInt(2, editedPerson.getAge());
            preparedStatement.setString(3, editedPerson.getEmail());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(Long id) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("delete from person where id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
