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
@Table(name="DateDragos")
public class XmlBean {

    @Id
    @Column(name = "Id")
    String id;

    @Column(name = "Period")
    Integer period;

    @Column(name = "Fee")
    Integer fee;

    @Column(name = "Amount")
    Integer amount;

    @Column(name = "LastName")
    String lastName;

    @Column(name = "FirstName")
    String firstName;
}
