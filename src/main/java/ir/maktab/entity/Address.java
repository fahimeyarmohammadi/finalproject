package ir.maktab.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@NamedQueries(
        @NamedQuery(name = "getAllAddresses",query = "FROM Address ")
)

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String city;
    private String street;
    private String alley;
    private String houseNumber;

}