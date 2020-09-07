package com;

import com.service.CouserService;
import com.service.TeacherService;
import com.service.TUdictService;
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

    @Autowired
    private TUdictService _tUdictService;

    @Autowired
    private CouserService _couserService;

    @Autowired
    private TeacherService _teacherService;

    @Test
    public void teacherSave() {
        _teacherService.save();
    }

    @Test
    public void courseSave() {
        _couserService.save();
    }

    @Test
    public void dictDelete() {
        _tUdictService.delete();
    }

    @Test
    public void dictSave() {
        _tUdictService.save();
    }

    @Test
    public void tUserQuery() {
        _tUserService.query();
    }

    @Test
    public void tUserSave() {
        _tUserService.tUserTest();
    }
}
