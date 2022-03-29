package repositories.old;

import models.User;

import java.sql.*;
import java.util.List;

public class UsersRepositoryImpl implements UsersRepository {

    private Connection connection;

    //language=sql
    private final String SQL_INSERT_USER = "INSERT INTO users(first_name, second_name, password, email, login) VALUES (?, ?, ?, ?, ?)";
    private final String SQL_FIND_BY_LOGIN = "SELECT *FROM users WHERE login=?";


    public UsersRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) {

        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirst_name());
            preparedStatement.setString(2, user.getSecond_name());
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getLogin());

            preparedStatement.executeUpdate();

            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                user.setId_user(resultSet.getLong("id_user"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByLogin(String login) {
        ResultSet resultSet = null;
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN);
            preparedStatement.setString(1, login);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId_user(resultSet.getLong("id_user"));
                user.setLogin(resultSet.getString("login"));
                user.setPasswordHash(resultSet.getString("password"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setSecond_name(resultSet.getString("second_name"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}




