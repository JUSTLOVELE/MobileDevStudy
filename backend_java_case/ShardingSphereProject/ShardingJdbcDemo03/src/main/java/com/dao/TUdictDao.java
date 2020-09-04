package com.dao;

import com.entity.TUdict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Repository
public interface TUdictDao extends JpaRepository<TUdict, Long> {
}
