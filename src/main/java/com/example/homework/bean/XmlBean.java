package com.example.homework.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="XMLObject")
public class XmlBean {

    @Id
    @Column(name = "Id")
    String id;

    @Column(name = "XML")
    String xmlObject;

    @Column(name = "Salary")
    Integer salary;

    @Column(name = "ExtraSalaries")
    Integer extraSalaries;

    @Column(name = "LastName")
    String lastName;

    @Column(name = "FirstName")
    String firstName;
}
