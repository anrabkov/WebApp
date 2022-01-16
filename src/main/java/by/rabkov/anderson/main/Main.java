package by.rabkov.anderson.main;


import by.rabkov.anderson.dao.PersonDao;


import by.rabkov.anderson.dao.impl.PersonDaoImpl;

import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.entity.Quality;



import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws SQLException {


        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person();
//      person.setId(10);
//      person.setName("Ten");
//      List<Quality> qualityList = new ArrayList<>();
//      qualityList.add(new Quality( "dfj"));
//     person.setQualityList(qualityList);



//        System.out.println(personDao.findAllPerson());
        System.out.println(personDao.findPersonById(2).toString());




    }
}
