package ru.kpfu.itis.dto;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginDto {
    private String login;
    private String password;
}
