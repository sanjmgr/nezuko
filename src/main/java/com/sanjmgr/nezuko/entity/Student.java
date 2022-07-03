package com.sanjmgr.nezuko.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    @Transient
    private Integer age;
    private LocalDate dob;
    private String email;

    public Integer getAge() {
        return Period.between(getDob(), LocalDate.now()).getYears();
    }
}
