package ru.kpfu.itis.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dto.FavouriteTeamDto;
import ru.kpfu.itis.dto.UserDto;
import ru.kpfu.itis.entities.FavouriteTeam;
import ru.kpfu.itis.entities.User;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.FavouritesTeamRepository;
import ru.kpfu.itis.repositories.MatchRepository;
import ru.kpfu.itis.repositories.UserRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    private FavouritesTeamRepository favouritesTeamRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MatchRepository matchRepository;


    @Override
    public User addUser(UserDto userDto) {
        String passwordHash = new BCrypt().hashpw(userDto.getPassword(),BCrypt.gensalt(4));
        User user = User.builder()
                        .first_name(userDto.getFirst_name())
                                .second_name(userDto.getSecond_name())
                                        .login(userDto.getLogin())
                                                .passwordHash(passwordHash)
                                                        .email(userDto.getEmail())
                                                                .build();
        userRepository.save(user);
        return user;
    }

    @Override
    public FavouriteTeam addMatch(FavouriteTeamDto favouriteTeamDto) {
        FavouriteTeam favouriteTeam = FavouriteTeam.builder()
                .team_name(favouriteTeamDto.getTeam_name())
                .stadium(favouriteTeamDto.getStadium())
                .coach(favouriteTeamDto.getCoach())
                .birthday(favouriteTeamDto.getBirthday())
                .build();
        favouritesTeamRepository.save(favouriteTeam);
        return favouriteTeam;
    }

    @Override
    public List<FavouriteTeam> getAllTeams() {
        return favouritesTeamRepository.findAll();
    }

    @Override
    public FavouriteTeam getOldestTeam() {
        return favouritesTeamRepository.findOldestTeam();
    }

    @Override
    public List<FavouriteTeam> getFavouriteTeams(Long id) {
        List<FavouriteTeam> favouriteTeams = new ArrayList<>();

        List<Object[]> results = favouritesTeamRepository.findAllByUserId(id);

        for (Object[] entry: results) {
            FavouriteTeam favouriteTeam = new FavouriteTeam();
            favouriteTeam.setId_team(((BigInteger) entry[0]).longValue());
            favouriteTeam.setTeam_name(String.valueOf(entry[1]));
            favouriteTeam.setStadium(String.valueOf(entry[2]));
            favouriteTeam.setCoach(String.valueOf(entry[3]));
            favouriteTeam.setBirthday((Date)entry[4]);
            favouriteTeams.add(favouriteTeam);
        }

        return favouriteTeams;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long userId, UserDto user) {
        User userUpdate = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        userUpdate.setFirst_name(user.getFirst_name());
        userUpdate.setSecond_name(user.getSecond_name());
        userRepository.save(userUpdate);
        return userUpdate;
    }

    @Override
    public void deleteUser(Long userId) {
        User userDelete = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(userDelete);
    }

    @Override
    public void updatePhoto(String url_photo, Long id) {
        userRepository.setPhoto(url_photo, id);
    }


}
