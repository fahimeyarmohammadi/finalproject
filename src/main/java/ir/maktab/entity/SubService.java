package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

@NamedQueries(
        @NamedQuery(name = "getAllSubServices",query = "FROM SubService")
)

public class SubService extends BaseService{
    String subName;
    Double basePrice;
    String description;
}
