package ru.kpfu.itis.entities;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "auth")

@Transactional
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "cookie_value")
    private String cookieValue;

}
