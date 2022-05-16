package ru.kpfu.itis.form;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class RequestForMatchesForm {
    private String firstName;
    private String secondName;
    private String email;
}
