package by.rabkov.anderson.service.impl;

import by.rabkov.anderson.dao.PersonDao;
import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.service.PersonService;

import java.sql.SQLException;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person findPersonById(int id) throws SQLException {
       return personDao.findPersonById(id);
    }

    @Override
    public List<Person> findAllPerson() throws SQLException {
        List<Person> allPerson = personDao.findAllPerson();
        return allPerson;
    }

    @Override
    public void addPerson(Person person) throws SQLException {
        personDao.addPerson(person);
    }

    @Override
    public void updatePersonById(int id) throws SQLException {
        personDao.updatePersonById(id);
    }

    @Override
    public void deletePersonById(int id) throws SQLException {
        personDao.deletePersonById(id);
    }
}
