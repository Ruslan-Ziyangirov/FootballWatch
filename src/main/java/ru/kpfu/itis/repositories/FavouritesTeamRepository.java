package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.entities.FavouriteTeam;
import java.util.List;

@Repository
@Transactional
public interface FavouritesTeamRepository extends JpaRepository<FavouriteTeam, Long> {

    @Transactional
    @Query(nativeQuery = true, value="select ft.id_team, ft.team_name, ft.stadium, ft.coach, ft.birthday from favourite_teams ft inner join\n" +
            "    users_favourite_teams uft on ft.id_team = uft.id_team inner join\n" +
            "        users u on uft.id_user = u.id_user where u.id_user=:id_user")
    List<Object[]>findAllByUserId(@Param("id_user") Long id_user);

    @Transactional
    @Query(nativeQuery = true, value="select ft.id_team, ft.team_name, ft.stadium, ft.coach, ft.birthday from favourite_teams ft where birthday = (select min(birthday) from favourite_teams)")
    FavouriteTeam findOldestTeam();

}
