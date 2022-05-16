package ru.kpfu.itis.form;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class RequestForm {

    private String firstName;
    private String secondName;
    private String email;

}
