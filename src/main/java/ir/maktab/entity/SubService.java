package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString

@NamedQueries(
        @NamedQuery(name = "getAllSubServices",query = "FROM SubService")
)

public class SubService extends BaseService{
    String subName;
    Double basePrice;
    String description;
}
