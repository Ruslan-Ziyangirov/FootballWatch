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
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_request;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;
}
