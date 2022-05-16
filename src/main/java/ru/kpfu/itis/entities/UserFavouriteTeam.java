package ru.kpfu.itis.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_favourite_teams")
public class UserFavouriteTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "id_user")
    private Long id_user;

    @Column(name = "id_team")
    private Long id_team;
            
}
