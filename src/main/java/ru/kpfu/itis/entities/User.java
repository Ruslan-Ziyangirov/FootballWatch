package ru.kpfu.itis.entities;


import lombok.*;
import ru.kpfu.itis.enums.Role;

import javax.persistence.*;
import java.util.List;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "login")
    private String login;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "password")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "email")
    private String email;

    @Column(name= "url_photo")
    private String url_photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_team", referencedColumnName = "id_team")}
    )
    private List<FavouriteTeam> favouriteTeams;

}
