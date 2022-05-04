//package ru.kpfu.itis.services.repositories.old;
//
//import ru.kpfu.itis.services.models.Authorization;
//
//import java.sql.*;
//import java.util.List;
//
//public class AuthRepositoryImpl implements AuthRepository {
//
//    private Connection connection;
//
//    //language=sql
//    private final String SQL_INSERT_COOKIE = "INSERT INTO \"authorization\" (id_user,cookie_value) VALUES (?, ?)";
//    private final String SQL_FIND_BY_COOKIE = "SELECT *FROM \"authorization\" WHERE cookie_value=?";
//
//    public AuthRepositoryImpl(Connection connection) {
//        this.connection = connection;
//    }
//
//
//
//    @Override
//    public Authorization save(Authorization authorization) {
//
//        ResultSet resultSet = null;
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_COOKIE, PreparedStatement.RETURN_GENERATED_KEYS);
//            preparedStatement.setLong(1,authorization.getUser().getId_user());
//            preparedStatement.setString(2, authorization.getCookieValue());
//
//            System.out.println("Дошел до executeQuery()");
//
//            preparedStatement.executeUpdate();
//
//            resultSet = preparedStatement.getGeneratedKeys();
//
//            if (resultSet.next()) {
//                authorization.setId(resultSet.getLong("id"));
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return authorization;
//
//    }
//
//    @Override
//    public List<Authorization> findAll() {
//        return null;
//    }
//
//
//    @Override
//    public Authorization findByCookie(String cookieValue) {
//
//        ResultSet resultSet = null;
//        Authorization authorization = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_COOKIE);
//            preparedStatement.setString(1,cookieValue);
//
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                authorization = new Authorization();
//                authorization.setId(resultSet.getLong("id"));
//
//                authorization.setCookieValue(resultSet.getString("cookie_value"));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return authorization;
//    }
//}
