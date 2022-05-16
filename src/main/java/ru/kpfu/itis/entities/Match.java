package ru.kpfu.itis.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_match;

    @Column(name = "first_team")
    private String first_team;

    @Column(name = "second_team")
    private String second_team;

    @Column(name = "time")
    private String time;

    @Column(name = "reference")
    private String reference;

    @Override
    public String toString() {
        return "Матч: \n" +
                first_team + '\'' +
                "- " + second_team + '\'' +
                " в " + time + ".\n" + '\'' +
                " Данный матч можно посмотреть по данной ссылке: " + reference + '\''+'\n' ;
    }

}
