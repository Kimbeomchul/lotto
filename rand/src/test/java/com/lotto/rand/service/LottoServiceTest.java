package com.lotto.rand.service;

import com.lotto.rand.controller.LottoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LottoServiceTest {

    @Autowired
    LottoService lottoService;

    @Test
    void test(){
        for(int i=0; i<10000; i++){
            LottoResponse lotto = lottoService.lotto();
            if(lotto.getCount() > 1){
                System.out.println("lotto = " + lotto);
                break;
            }
        }
    }
}