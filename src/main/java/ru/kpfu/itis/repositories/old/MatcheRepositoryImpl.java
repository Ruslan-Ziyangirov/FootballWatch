package ru.kpfu.itis.repositories.old;

import ru.kpfu.itis.models.Match;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatcheRepositoryImpl implements MatcheRepository {

    private  Connection connection;

    //language=sql
    private final String SQL_FIND_MATCHES = "SELECT *FROM matches";

    public MatcheRepositoryImpl() {
    }

    public MatcheRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Match save(Match match) {
        return null;
    }



    @Override
    public List<Match> findAll() {

        ArrayList<Match> listOfMatches = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_MATCHES);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                listOfMatches.add(new Match(resultSet.getLong(1),resultSet.getString(2),
                        resultSet.getString(3),resultSet.getString(4), resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfMatches;

    }


}
