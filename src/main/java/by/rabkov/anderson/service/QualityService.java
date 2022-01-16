package by.rabkov.anderson.service;

import by.rabkov.anderson.entity.Person;
import by.rabkov.anderson.entity.Quality;

import java.sql.SQLException;
import java.util.List;

public interface QualityService {

    Quality findQualityById(int id) throws SQLException;
    List<Quality> findAllQuality() throws SQLException;
    void addQuality(Quality quality) throws SQLException;
    void updateQualityById(int id) throws SQLException;
    void deleteQualityById(int id) throws SQLException;
}

