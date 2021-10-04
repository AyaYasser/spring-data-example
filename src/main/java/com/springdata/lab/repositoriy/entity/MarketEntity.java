package com.springdata.lab.repositoriy.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Author Aya Yasser Esmail
 * on 03/10/2021
 **/
@Entity
@Data
@Table(name = "market")
public class MarketEntity implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "item")
    private String item;

    @Column(name = "amount")
    private double amount;



}
