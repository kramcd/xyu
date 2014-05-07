package ru.tusur.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.tusur.domain.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * xyu
 * ru.tusur.data
 * by Oleg Alekseev
 * 15.04.14.
 */
public class CityDAO extends JdbcDaoSupport implements DAO<City> {

    private static final String GET_ALL_CITIES = "SELECT c.city_id, c.city_name " +
            "FROM city c";

    private static final String GET_CITY_BY_CODE = "SELECT c.city_id, c.city_name " +
            "FROM city c " +
            "WHERE c.city_id = ?";

    private static final String INSERT_CITY = "INSERT INTO city (city_name) " +
            "VALUES (?)";

    private static final String UPDATE_CITY = "UPDATE city SET city_name = ? " +
            "WHERE city_id = ?";

    private static final String DELETE_CITY = "DELETE FROM city"+
            "WHERE city_name = ?";

    @Override
    @Qualifier("CityDAO")
    public Collection<City> getAll() {
        return getJdbcTemplate().query(GET_ALL_CITIES, new CityRowMapper());
    }

    @Override
    public City getById(int id) {
        return getJdbcTemplate().queryForObject(GET_CITY_BY_CODE, new CityRowMapper(), id);
    }

    @Override
    public void insert(City record) {
        getJdbcTemplate().update(INSERT_CITY, record.getName());
    }

    @Override
    public void save(City record) {
        getJdbcTemplate().update(UPDATE_CITY, record.getName(), record.getCode());
    }

    @Override
    public void remove(City record) {
        getJdbcTemplate().update(DELETE_CITY, record.getName());
    }

    private class CityRowMapper implements RowMapper<City> {
        @Override
        public City mapRow(ResultSet resultSet, int i) throws SQLException {
            City city = new City();
            city.setCode(resultSet.getString(1));
            city.setName(resultSet.getString(2));
            return city;
        }
    }

}
