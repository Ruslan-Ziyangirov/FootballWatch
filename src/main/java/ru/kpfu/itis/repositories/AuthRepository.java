package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.Authorization;

import java.util.Optional;

@Repository @Transactional
public interface AuthRepository extends JpaRepository<Authorization, Long> {
    Optional<Authorization> findByCookieValue(String cookieValue);
}
