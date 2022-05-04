package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    User findByLogin(String login);
}
