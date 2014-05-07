package ru.tusur.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import ru.tusur.domain.City;
import ru.tusur.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by kramc_000 on 17.04.14.
 */
public class PersonDAO extends JdbcDaoSupport implements DAO<Person> {

    public static final String GET_ALL_PERSON = "SELECT p.person_id, p.person_name, p.person_age, p.city_id "+
        "FROM person p";

    public static final String GET_BY_CODE_PERSON = "SELECT p.person_id, p.person_name, p.person_age, p.city_id "+
        "FROM person p "+
        "WHERE p.person_id = ?";

    public static final String UPDATE_PERSON = "UPDATE person SET name = ?, age = ? "+
            "WHERE person_id = ?";

    public static final String INSERT_PERSON = "INSERT INTO person (name, age, city_id " +
            "VALUES (?,?,?)";

    public static final String DELETE = "DELETE FROM person " +
            "WHERE person_name = ?";

    @Override
    public Collection<Person> getAll() {
        return getJdbcTemplate().query(GET_ALL_PERSON, new PersonRowMapper());
    }

    @Override
    public Person getById(int id) {
        return getJdbcTemplate().queryForObject(GET_BY_CODE_PERSON, new PersonRowMapper(), id);
    }

    @Override
    public void insert(Person record) {
        getJdbcTemplate().update(INSERT_PERSON, record.getName(), record.getAge(), record.getCity());
    }

    @Override
    public void save(Person record) {
        getJdbcTemplate().update(UPDATE_PERSON, record.getName(),record.getAge(),record.getCity());
    }

    @Override
    public void remove(Person record) {
        getJdbcTemplate().update(DELETE, record.getName());
    }

    public void setCityDao(DAO cityDao) {
        this.cityDao = cityDao;
    }

    @Autowired
    @Qualifier("CityDAO")
    private DAO cityDao;
    private class PersonRowMapper implements RowMapper<Person>{

        @Override

        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setCode(resultSet.getString(1));
            person.setName(resultSet.getString(2));
            person.setAge(resultSet.getInt(3));
            person.setCity((City) cityDao.getById(resultSet.getInt(4)));
            return person;
        }
    }
}
