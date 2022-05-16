package ru.kpfu.itis.services;

import ru.kpfu.itis.dto.FavouriteTeamDto;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.entities.FavouriteTeam;
import ru.kpfu.itis.entities.User;

import java.util.List;


public interface UsersService {
    User addUser(UserDto userDto);
    List<User> getAllUsers();
    User updateUser(Long userId, UserDto user);
    void deleteUser(Long userId);
    void updatePhoto(String url_photo, Long id);
//    void requestMessage(RequestForm requestForm);
    List<FavouriteTeam> getFavouriteTeams(Long id);

    FavouriteTeam addMatch(FavouriteTeamDto favouriteTeamDto);

    List<FavouriteTeam> getAllTeams();
    FavouriteTeam getOldestTeam();
}
