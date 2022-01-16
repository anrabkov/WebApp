package by.rabkov.anderson.dao;

import by.rabkov.anderson.entity.Quality;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface QualityDao {
    Quality findQualityById(int id) throws SQLException;
    List<Quality> findAllQuality() throws SQLException;
    void addQuality(Quality quality) throws SQLException;
    void updateQualityById(int id) throws SQLException;
    void deleteQualityById(int id) throws SQLException;

}
