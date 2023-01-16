package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Temporal(value=TemporalType.DATE)
    Date offerDate;

    Double offerPrice;

    @Temporal(value=TemporalType.DATE)
    Date startWork;

    @ManyToOne
    Order order;
}
