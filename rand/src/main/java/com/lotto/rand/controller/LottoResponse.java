package com.lotto.rand.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LottoResponse {
    private String key;
    private String winner;
    private int count;
    public LottoResponse() {

    }
}
