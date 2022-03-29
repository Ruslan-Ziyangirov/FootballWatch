package repositories;

import models.Authorization;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Authorization> {
    Optional<Object> findByCookie(String cookieValue);
}
