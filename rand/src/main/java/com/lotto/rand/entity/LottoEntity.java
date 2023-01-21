package com.lotto.rand.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Entity(name = "lotto")
@Table
@Getter
public class LottoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "key")
    private String key;

    @Setter
    @Column(name = "winner")
    private String winner;

    @Setter
    @Column(name = "bonus")
    private String bonus;

}
