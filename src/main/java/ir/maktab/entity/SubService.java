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
@ToString

@NamedQueries(
        {@NamedQuery(name = "getAllSubServices", query = "FROM SubService"), @NamedQuery(name = "getAllSubServicesByBaseServiceName", query = "FROM SubService s where s.baseService.name=:name")}
)

public class SubService{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String subName;
    Double basePrice;
    String description;

    @ManyToOne
    BaseService baseService;

}