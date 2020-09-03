package com.service;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author yangzl 2020.09.03
 * @version 1.00.00
 * @Description:
 * @history:
 */



//@Component
public class DbShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {

        Integer index = preciseShardingValue.getValue() % 2;
        for (String dataSourceName : collection) {
            if (dataSourceName.endsWith(index + "")) {
                return dataSourceName;
            }
        }
        throw new UnsupportedOperationException();
    }
}