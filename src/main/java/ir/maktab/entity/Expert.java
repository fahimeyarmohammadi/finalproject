package ir.maktab.entity;

import ir.maktab.enums.EXPERTCONDITION;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@NamedQueries(
        @NamedQuery(name = "getAllExperts", query = "FROM Expert"))

public class Expert extends Person {

    @Enumerated(value = EnumType.STRING)
    EXPERTCONDITION expertcondition;

    @ManyToMany

    List<SubService> subServiceList = new ArrayList<>();

    @OneToMany
    List<Review> reviewList = new ArrayList<>();

    int score;

    @Lob
    byte[] expertImage;

}
