package ru.kpfu.itis.services;

import ru.kpfu.itis.models.Match;

import java.util.List;

public interface MatchService {

    List<Match> getAllMatches();
    Match getMatchById(Long id);

}