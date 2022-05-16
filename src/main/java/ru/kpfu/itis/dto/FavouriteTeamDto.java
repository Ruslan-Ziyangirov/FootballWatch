package ru.kpfu.itis.dto;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;


@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteTeamDto {
    private String team_name;
    private String stadium;
    private String coach;
    private Date birthday;
}
