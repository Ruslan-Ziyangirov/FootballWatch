package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entities.Match;
import ru.kpfu.itis.repositories.MatchRepository;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public List<Match> getAllMatches(){
        return (List<Match>) matchRepository.findAll();
    }

    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id).get();
    }

}
