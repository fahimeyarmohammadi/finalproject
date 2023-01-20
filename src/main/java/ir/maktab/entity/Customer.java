package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
//import org.apache.maven.surefire.shared.lang3.builder.ToStringExclude;
import javax.persistence.*;
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
