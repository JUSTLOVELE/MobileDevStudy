package com.service;

import com.dao.TUserDao;
import com.entity.TUser;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TUserService {

    @Autowired
    private TUserDao _tUserDao;

    @Autowired
    private SnowflakeShardingKeyGenerator userKeyGenerator;

    public void query() {

        Optional<TUser> user = _tUserDao.findById(101L);
        System.out.println(user.get().toString());
    }

    public void tUserTest() {

        TUser user = new TUser();
        user.setUserId(101L);
        user.setUserName("lucy");
        user.setUserStatus("a");
        _tUserDao.save(user);
    }
}
