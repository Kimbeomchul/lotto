package com.lotto.rand.controller;

import com.lotto.rand.service.LottoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/lotto")
@RequiredArgsConstructor
public class LottoController {

    private final LottoService lottoService;

    @GetMapping
    public LottoResponse lotto(){
        return lottoService.lotto();
    }

}
