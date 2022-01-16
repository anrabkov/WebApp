package by.rabkov.anderson.service;

import by.rabkov.anderson.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    Person findPersonById(int id) throws SQLException;
    List<Person> findAllPerson() throws SQLException;
    void addPerson(Person person) throws SQLException;
    void updatePersonById(int id) throws SQLException;
    void deletePersonById(int id) throws SQLException;
}
