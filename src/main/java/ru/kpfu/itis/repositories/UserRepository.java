package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.User;

import java.util.Optional;

@Repository @Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findByLogin(String login);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value="update users set url_photo=:url_photo where id_user=:id_user")
    void setPhoto(@Param("url_photo") String url_photo,
                  @Param("id_user") Long id_user);
}
