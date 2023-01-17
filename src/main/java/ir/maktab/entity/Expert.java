package ir.maktab.entity;

import ir.maktab.enums.EXPERTCONDITION;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Expert extends Person{

    @Enumerated(value = EnumType.STRING)
     EXPERTCONDITION expertcondition;

    @OneToMany
    List<SubService> subServiceList=new ArrayList<>();

    @OneToMany
    List<Review>reviewList=new ArrayList<>();

    //image

}
