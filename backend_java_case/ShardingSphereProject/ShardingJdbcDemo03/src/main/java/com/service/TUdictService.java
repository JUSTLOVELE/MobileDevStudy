package com.service;

import com.dao.TUdictDao;
import com.entity.TUdict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TUdictService {

    @Autowired
    private TUdictDao _tUdictDao;

    public void delete() {
        _tUdictDao.deleteById(-5123650858252360931L);
    }

    public void save() {

        TUdict dict = new TUdict();
        dict.setDictId(new Random().nextLong());
        dict.setDictStatus("a");
        dict.setDictValue("正常");
        _tUdictDao.save(dict);
    }
}
