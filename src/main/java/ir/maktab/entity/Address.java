package ir.maktab.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Setter
@Getter
@Embeddable

public class Address {

    private String city;
    private String street;
    private String alley;
    private String houseNumber;

}
