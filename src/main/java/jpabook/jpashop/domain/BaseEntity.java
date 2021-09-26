package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 기본 부모 엔티티
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDate;
}
