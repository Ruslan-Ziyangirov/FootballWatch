package ru.kpfu.itis.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.UserRepository;

import java.util.Optional;

@Service("customUserDetailsImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("имейл "+email);
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        System.out.println("юзер опшион "+userOptional);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new UserDetailsImpl(user);
        } else {
            throw new SecurityException("User with email <" + email + "> not found");
        }
    }
}
