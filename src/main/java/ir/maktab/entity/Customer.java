package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@NamedQueries(
        @NamedQuery(name = "getAllCustomers", query = "FROM Customer")
)

public class Customer extends Person {

    @OneToMany
    List<CustomerOrder> orderList = new ArrayList<>();

}
