package ru.kpfu.itis.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private MessageSource messages;

    @Autowired
    private LocaleResolver localeResolver;

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
                                        final AuthenticationException exception) throws IOException, ServletException {
        setDefaultFailureUrl("/main?error=true");

        super.onAuthenticationFailure(request, response, exception);

        final Locale locale = localeResolver.resolveLocale(request);

        String errorMessage = messages.getMessage("message.badCredentials", null, locale);

        if (exception.getMessage()
                .equalsIgnoreCase("Пользователь отключен")) {
            errorMessage = messages.getMessage("auth.message.disabled", null, locale);
        } else if (exception.getMessage()
                .equalsIgnoreCase("Срок действия учетной записи пользователя истек")) {
            errorMessage = messages.getMessage("auth.message.expired", null, locale);
        } else if (exception.getMessage()
                .equalsIgnoreCase("Заблокирован")) {
            errorMessage = messages.getMessage("auth.message.blocked", null, locale);
        } else if (exception.getMessage()
                .equalsIgnoreCase("unusual location")) {
            errorMessage = messages.getMessage("auth.message.unusual.location", null, locale);
        }

        request.getSession()
                .setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
    }
}