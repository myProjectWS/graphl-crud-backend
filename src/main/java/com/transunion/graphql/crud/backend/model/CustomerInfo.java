package com.transunion.graphql.crud.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customerInfo")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfo {

    @Id
    private Integer id;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "latestScore", nullable = false)
    private int latestScore;

}
