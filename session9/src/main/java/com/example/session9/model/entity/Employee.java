package com.example.session9.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full name")
    private String fullName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
