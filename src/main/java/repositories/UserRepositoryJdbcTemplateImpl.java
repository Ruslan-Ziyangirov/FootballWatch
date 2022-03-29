package repositories;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Optional;

@Repository("userRepositoryJdbcTemplateImpl")

public class UserRepositoryJdbcTemplateImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = ((resultSet, rowNum) -> {
        return User.builder()
                .id_user(resultSet.getLong("id_user"))
                .second_name(resultSet.getString("second_name"))
                .first_name(resultSet.getString("first_name"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT = "INSERT INTO users(first_name, second_name, password, email, login) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_FIND_BY_ID = "SELECT *FROM users WHERE id_user=?";

    public UserRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <S extends User> S save(S user) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT, new String[]{"id_user"});

            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getSecond_name());
            statement.setString(3, user.getPasswordHash());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getLogin());

            return statement;
        }, keyHolder);

        System.out.println("Мне не выбраться...");

        user.setId_user(keyHolder.getKey().longValue());



        return user;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, id);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public User findByLogin(String login) {
        return null;
    }
}
