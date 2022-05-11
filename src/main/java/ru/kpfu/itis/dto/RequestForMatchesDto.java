package ru.kpfu.itis.dto;
import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestForMatchesDto {

    private String firstName;
    private String secondName;
    private String email;

}
