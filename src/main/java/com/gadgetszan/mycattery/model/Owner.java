package com.gadgetszan.mycattery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="Owner")
@Table(name="owner")
public class Owner {
    @Id
    @SequenceGenerator(
            name="owner_sequence",
            sequenceName="owner_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="owner_sequence"
    )
    @Column(
            name="id",
            updatable=false
    )
    private Long id;

    @Column(
            name="first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name="last_name",
            nullable = false
    )
    private String lastName;
    @Column(
            name="middle_name",
            nullable = false
    )
    private String middleName;
    @Column(
            name="address",
            nullable = false
    )
    private String address;
    @Column(
            name="contact_no",
            nullable = false
    )
    private String contactNo;

}
