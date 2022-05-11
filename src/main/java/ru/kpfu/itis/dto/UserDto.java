package ru.kpfu.itis.dto;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String first_name;
    private String second_name;
    private String login;
    private String password;
    private String repassword;
    private String email;
}
