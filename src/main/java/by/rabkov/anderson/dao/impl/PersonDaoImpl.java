package by.rabkov.anderson.dao.impl;

import by.rabkov.anderson.dao.PersonDao;
import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.sessionFactory.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;


public class PersonDaoImpl implements PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDaoImpl() {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }


    @Override
    public Person findPersonById(int id) throws SQLException {
        Session  session = sessionFactory.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    @Override
    public List<Person> findAllPerson()  throws SQLException{
        List<Person> personList = (List<Person>) SessionFactoryHolder
                .getSessionFactory()
                .openSession()
                .createQuery("From Person").list();

        return personList;
    }

    @Override
    public void addPerson(Person person) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void updatePersonById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Person person = (Person) session.get(Person.class, id);
        person.setName("OtherName");
        session.update(person);
        transaction.commit();
        session.close();
    }

    @Override
    public void deletePersonById(int id ) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        transaction.commit();
        session.close();

    }


}
