package ru.kpfu.itis.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.models.Authorization;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.security.details.UserDetailsImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component("customSuccessfulAuthenticationHandler")
public class SuccessfulAuthenticationHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private AuthRepository authRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException, IOException {

        String cookieValue = UUID.randomUUID().toString();

        Cookie cookie = new Cookie("Auth", cookieValue);
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Authorization auth = Authorization.builder()
                .cookieValue(cookieValue)
                .user(userDetails.getUser())
                .build();
        System.out.println("секьюрити заработал");
        authRepository.save(auth);
        redirectStrategy.sendRedirect(request, response, "/profile");
    }
}