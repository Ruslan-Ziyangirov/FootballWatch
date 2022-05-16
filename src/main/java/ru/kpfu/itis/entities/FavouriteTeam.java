package ru.kpfu.itis.entities;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "favourite_teams")
public class FavouriteTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_team;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "stadium")
    private String stadium;

    @Column(name = "coach")
    private String coach;

    @Column(name = "birthday")
    private Date birthday;

}
