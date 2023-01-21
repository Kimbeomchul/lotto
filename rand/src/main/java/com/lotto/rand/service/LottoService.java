package com.lotto.rand.service;

import com.lotto.rand.controller.LottoResponse;
import com.lotto.rand.entity.LottoEntity;
import com.lotto.rand.entity.LottoEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class LottoService {

    private final LottoEntityRepository lottoEntityRepository;

    @Transactional(readOnly = true)
    public LottoResponse lotto(){
        Random random = new Random();
        List<LottoEntity> all = lottoEntityRepository.findAll();
        LottoResponse lr = new LottoResponse();
        int max = 1000000;
        int min = 100000;
        int count = 0;
        while(true){
            boolean flag = true;
            int firstNumber = random.nextInt((max - min) + 1) + min;
            String SecondNumber = String.valueOf(firstNumber);

            for(int i=0; i<all.size(); i++){
                char[] cvWinner = all.get(i).getWinner().toCharArray();
                char[] cvBonus = all.get(i).getBonus().toCharArray();
                char[] cvNumber = SecondNumber.toCharArray();
                Arrays.sort(cvWinner);
                Arrays.sort(cvBonus);
                Arrays.sort(cvNumber);

                if(cvNumber.equals(cvBonus) || cvNumber.equals(cvBonus)){
                    flag = false;
                }
                log.info("cvWinner = {}", cvWinner);
                log.info("cvBonus = {}", cvBonus);
                log.info("cvNumber = {}", cvNumber);

                for(int j=0; j<cvNumber.length; j++){
                    if(this.countChar(String.valueOf(cvNumber), cvNumber[j]) > 3){
                        flag = false;
                    }
                }
            }
            count++;
            log.info("############## counter = {}", count);


            if(flag){
                lr.setWinner(String.valueOf(firstNumber));
                lr.setKey(String.valueOf(random.nextInt(6)));
                lr.setCount(count);
                return lr;
            }
            return lr;
        }
    }

    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

}
