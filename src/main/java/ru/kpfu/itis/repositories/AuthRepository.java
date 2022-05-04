package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Authorization;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Authorization> {
    Optional<Object> findByCookie(String cookieValue);
}
