package ir.maktab.entity;

import ir.maktab.enums.EXPERTCONDITION;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@NamedQueries(
        @NamedQuery(name = "getAllExperts",query = "FROM Expert"))

public class Expert extends Person{

    @Enumerated(value = EnumType.STRING)
     EXPERTCONDITION expertcondition;

    @ManyToMany(fetch = FetchType.EAGER)
    List<SubService> subServiceList=new ArrayList<>();

    @OneToMany
    List<Review>reviewList=new ArrayList<>();

    int score;

    @Lob
    @Column(name = "IMAGE")
    byte[] expertImage;

}
