package jpabook.jpashop.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELEVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

//    private String city;
//
//    private String street;
//
//    private String zipcode;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }

}
