package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Duration;
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

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date offerDate;

    Double offerPrice;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date startWork;

    @OneToOne
    Order order;

    @OneToOne
    Expert expert;

    Duration duration;
}
