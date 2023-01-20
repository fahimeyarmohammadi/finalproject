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
        @NamedQuery(name = "getAllOrders", query = "FROM CustomerOrder")
)

public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    Double proposedPrice;

    @Column(nullable = false)
    String description;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date preferDate;

    @Enumerated(value = EnumType.STRING)
    ORDERCONDITION ordercondition;

    @OneToOne
    @Column(nullable = false)
    SubService subService;

    @Temporal(value = TemporalType.TIMESTAMP)
    Date doneDate;

    @Embedded
    @Column(nullable = false)
    Address address;

}
