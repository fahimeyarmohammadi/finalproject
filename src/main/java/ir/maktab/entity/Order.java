package ir.maktab.entity;

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
@NamedQueries(
        @NamedQuery(name = "getAllOrders", query = "FROM Order")
)

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double proposedPrice;

    String description;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date preferDate;

    @Enumerated(value = EnumType.STRING)
    ORDERCONDITION ordercondition;

    @OneToOne
    SubService subService;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date doneDate;

    @Embedded
    Address address;

}
