package models;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    private Long id_user;
    private String first_name;
    private String login;
    private String second_name;
    private String passwordHash;
    private String email;


}
