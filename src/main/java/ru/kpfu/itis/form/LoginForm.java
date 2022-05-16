package ru.kpfu.itis.form;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class LoginForm {

    private String login;
    private String password;

}
