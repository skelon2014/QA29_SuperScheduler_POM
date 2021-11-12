package dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class Event {
    String title;
    String type;
    int breaks;
    int ammount;
}
