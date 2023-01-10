package com.system.kinmel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "checkout")
public class Checkout {
    @Id
    @SequenceGenerator(name = "kinMel_user_seq_gen", sequenceName = "kinMel_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kinMel_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "town")
    private String town;

    @Column(name = "state")
    private String state;

    @Column(name = "postal")
    private String postal;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
}