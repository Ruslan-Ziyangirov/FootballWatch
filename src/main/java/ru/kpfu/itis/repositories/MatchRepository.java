package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.Match;

@Repository
@Transactional
public interface MatchRepository extends JpaRepository<Match, Long> {

}
