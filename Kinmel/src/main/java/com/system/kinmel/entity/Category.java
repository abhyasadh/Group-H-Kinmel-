package com.system.kinmel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @SequenceGenerator(name = "kinmel_category_seq_gen", sequenceName = "kinmel_category_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kinmel_category_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false,name = "category_name")
    private String category_name;

}
