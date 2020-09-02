package com;

import com.service.CouserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangzl 2020.08.27
 * @version 1.00.00
 * @Description:
 * @history:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, ShardingJdbcApplicationTest.class})
public class ShardingJdbcApplicationTest {

    @Autowired
    private CouserService _couserService;

    @Test
    public void save() {
        _couserService.save01();
        _couserService.save02();
    }
}
