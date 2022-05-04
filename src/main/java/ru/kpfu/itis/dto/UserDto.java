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
    private String firstName;
    private String secondName;
    private String login;
    private String password;
    private String email;
}
