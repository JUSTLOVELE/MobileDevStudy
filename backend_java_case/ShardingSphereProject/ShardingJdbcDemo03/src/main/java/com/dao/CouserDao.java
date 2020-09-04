package com.dao;

import com.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yangzl 2020.08.27
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Repository
public interface CouserDao extends JpaRepository<Course, Long> {


}
