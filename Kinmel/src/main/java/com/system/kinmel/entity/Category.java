package com.system.kinmel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "kinMel_user_seq_gen", sequenceName = "kinMel_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "kinMel_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String categoryName;
}
