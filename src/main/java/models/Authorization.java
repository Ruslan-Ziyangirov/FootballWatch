package models;

import lombok.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Authorization {

    private Long id;
    private User user;
    private String cookieValue;

}
