package ir.maktab.entity;

import ir.maktab.enums.EXPERTCONDITION;
import ir.maktab.enums.ORDERCONDITION;
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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double proposedPrice;
    String comment;
    @Temporal(value = TemporalType.DATE)
    Date proposedDate;

    @Enumerated(value = EnumType.STRING)
    ORDERCONDITION ordercondition;

}
