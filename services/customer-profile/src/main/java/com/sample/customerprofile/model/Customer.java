package com.sample.customerprofile.model;

import com.sample.common.utils.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nitisha.khandelwal on 13/05/16.
 */

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "customer")
public class Customer extends AbstractEntity <Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDateTime;
}
