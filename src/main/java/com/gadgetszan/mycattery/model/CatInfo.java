package com.gadgetszan.mycattery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="CatInfo")
@Table(name="cat_info")
public class CatInfo {
    @Id
    @SequenceGenerator(
            name="cat_info_sequence",
            sequenceName="cat_info_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="cat_info_sequence"
    )
    @Column(
            name="id",
            updatable=false
    )
    private long id;

    @ManyToOne
    @JoinColumn(
            name = "owner_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
            name = "owner_cat_info_fk"
    )
    )
    private Owner owner;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;
    @Column(
            name = "color",
            nullable = false
    )
    private String color;
    @Column(
            name = "breed",
            nullable = false
    )
    private String breed;
    @Column(
            name = "dob",
            nullable = false
    )
    private Date dateOfBirth;
    @Column(
            name = "microchip",
            length = 15
    )
    private String microchip;
}
