package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "MEMBER")
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private String name;

//    private String city;
//
//    private String street;
//
//    private String zipcode;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //연관관계의 주인이 아님
    private List<Order> orders = new ArrayList<Order>();


}
