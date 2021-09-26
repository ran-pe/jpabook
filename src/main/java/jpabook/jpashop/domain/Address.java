package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Address {
    private String city;

    private String street;

    private String zipcode;

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
