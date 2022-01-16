package by.rabkov.anderson.dao.impl;

import by.rabkov.anderson.dao.QualityDao;
import by.rabkov.anderson.entity.Quality;
import by.rabkov.anderson.sessionFactory.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.sql.SQLException;
import java.util.List;


public class QualityDaoImpl implements QualityDao {

     private final SessionFactory sessionFactory;

     public QualityDaoImpl(){
         sessionFactory = SessionFactoryHolder.getSessionFactory();
     }

    @Override
    public Quality findQualityById(int id)   {
         Session session = sessionFactory.openSession();
         Quality quality = session.get(Quality.class, id);
         session.close();
         return quality;
    }

    @Override
    public List<Quality> findAllQuality() throws SQLException {
        List<Quality> qualityList = (List<Quality>) SessionFactoryHolder
                .getSessionFactory()
                .openSession()
                .createQuery("From Quality")
                .list();
        return qualityList;
    }

    @Override
    public void addQuality(Quality quality) throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(quality);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateQualityById(int  id) throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Quality quality = (Quality) session.get(Quality.class, id);
        quality.setName("OtherName");
        session.update(quality);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteQualityById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Quality quality = (Quality) session.get(Quality.class, id);
    }
}
