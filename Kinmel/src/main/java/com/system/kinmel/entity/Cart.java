package com.system.kinmel.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "cart")
public class Cart {

    @Id
    @SequenceGenerator(name = "cms_user_seq_gen", sequenceName = "cms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_productId"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_userId"))
    private User user;

    @Column
    private Integer quantity;

    @Column(columnDefinition = "varchar(255) default 'Added'")
    private String status;

    @Column
    private String billingAddress;

    @Column
    private String billingApartment;

    @Column
    private String billingCompany_name;

    @Column
    private String billingEmail;

    @Column
    private String billingFirstName;

    @Column
    private String billingLastName;

    @Column
    private String billingPhone;

    @Column
    private String billingPostal;

    @Column
    private String billingState;

    @Column
    private String billingTown;

    @Column
    private String notes;

    @Column
    private String shippingAddress;

    @Column
    private String shippingApartment;

    @Column
    private String shippingCompany_name;

    @Column
    private String shippingEmail;

    @Column
    private String shippingFirstName;

    @Column
    private String shippingLastName;

    @Column
    private String shippingPhone;

    @Column
    private String shippingPostal;

    @Column
    private String shippingState;

    @Column
    private String shippingTown;
}
