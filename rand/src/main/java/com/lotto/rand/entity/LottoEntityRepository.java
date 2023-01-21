package com.lotto.rand.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LottoEntityRepository extends JpaRepository<LottoEntity, Long> {

}
