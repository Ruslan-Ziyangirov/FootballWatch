package ru.kpfu.itis.form;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
public class MessageForm {
    private String author;
    private String text;
}
