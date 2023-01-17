package ir.maktab.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@MappedSuperclass
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long credit;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String familyName;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    Date date;
}
