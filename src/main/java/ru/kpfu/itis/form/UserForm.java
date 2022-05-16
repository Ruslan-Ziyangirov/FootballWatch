package ru.kpfu.itis.form;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class UserForm {
    private String first_name;
    private String second_name;
    private String login;
    private String password;
    private String repassword;
    private String email;
}
