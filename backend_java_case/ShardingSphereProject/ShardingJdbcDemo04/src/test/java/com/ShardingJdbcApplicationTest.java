package com;

import com.service.TUserService;
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
    private TUserService _tUserService;

    @Test
    public void tUserQuery() {
        _tUserService.query();
    }

    @Test
    public void tUserSave() {
        _tUserService.tUserTest();
    }
}
