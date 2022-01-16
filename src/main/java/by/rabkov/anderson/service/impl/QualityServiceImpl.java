package by.rabkov.anderson.service.impl;

import by.rabkov.anderson.dao.QualityDao;
import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.entity.Quality;
import by.rabkov.anderson.service.QualityService;

import java.sql.SQLException;
import java.util.List;

public class QualityServiceImpl implements QualityService {

    private QualityDao qualityDao;

    public QualityServiceImpl(QualityDao qualityDao) {
        this.qualityDao = qualityDao;
    }

    @Override
    public Quality findQualityById(int id) throws SQLException {
       return qualityDao.findQualityById(id);
    }

    @Override
    public List<Quality> findAllQuality() throws SQLException {
        return qualityDao.findAllQuality();
    }

    @Override
    public void addQuality(Quality quality) throws SQLException {
        qualityDao.addQuality(quality);
    }

    @Override
    public void updateQualityById(int id) throws SQLException {
        qualityDao.updateQualityById(id);
    }

    @Override
    public void deleteQualityById(int id) throws SQLException {
        qualityDao.deleteQualityById(id);

    }
}
