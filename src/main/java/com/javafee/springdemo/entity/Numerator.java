package com.javafee.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "numerator")
@Data
public class Numerator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private Integer value;

    @Column(name = "additionDate")
    private Date additionDate;

    @Column(name = "isPalindrome")
    private Boolean isPalindrome;
}



