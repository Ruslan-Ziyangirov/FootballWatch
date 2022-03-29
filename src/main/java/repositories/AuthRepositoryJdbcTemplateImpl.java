package repositories;

import models.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Repository("authRepositoryJdbcTemplateImpl")
public class AuthRepositoryJdbcTemplateImpl implements AuthRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Authorization> authorizationRowMapper = ((resultSet, rowNum) -> {
        return Authorization.builder()
                .id(resultSet.getLong("id"))
                .cookieValue(resultSet.getString("cookie_value"))
                .build();
    });

    //language=sql
    private final String SQL_INSERT_COOKIE = "INSERT INTO \"authorization\" (id_user,cookie_value) VALUES (?, ?)";
    private final String SQL_FIND_BY_COOKIE = "SELECT *FROM \"authorization\" WHERE cookie_value=?";

    public AuthRepositoryJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Object> findByCookie(String cookieValue) {
        Authorization authorization;
        try {
            authorization = jdbcTemplate.queryForObject(SQL_FIND_BY_COOKIE, authorizationRowMapper, cookieValue);
        } catch (DataAccessException ex) {
            return Optional.empty();
        }
        return Optional.of(authorization);
    }

    @Override
    public Authorization save(Authorization authorization) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COOKIE, new String[]{"id"});

            statement.setLong(1,authorization.getUser().getId_user());
            statement.setString(2, authorization.getCookieValue());

            return statement;

        }, keyHolder);

        System.out.println("Мне не выбраться...");

        authorization.setId(keyHolder.getKey().longValue());

        return authorization;
    }

    @Override
    public List<Authorization> findAll() {
        return null;
    }
}
