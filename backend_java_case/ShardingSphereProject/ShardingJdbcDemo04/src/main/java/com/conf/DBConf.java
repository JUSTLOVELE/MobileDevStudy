package com.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Configuration
public class DBConf {

    @Value("${datasource0.url}")
    private String url0;
    @Value("${datasource0.username}")
    private String username0;
    @Value("${datasource0.password}")
    private String password0;
    @Value("${datasource0.driver-class-name}")
    private String driverClassName0;

    @Value("${datasource1.url}")
    private String url1;
    @Value("${datasource1.username}")
    private String username1;
    @Value("${datasource1.password}")
    private String password1;
    @Value("${datasource1.driver-class-name}")
    private String driverClassName1;

    @Bean("dataSource")
    public DataSource dataSource() {

        try {
            //配置读写分离
            MasterSlaveRuleConfiguration masterSlaveRuleConfiguration = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave01"));
            // 创建数据源
            Properties props=new Properties();
            props.put("sql.show", "true");
            DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(confDataSourceMap(),
                    masterSlaveRuleConfiguration,
                    props);
            return dataSource;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    /**
     * 配置数据源
     * @return
     */
    private Map<String, DataSource> confDataSourceMap() {

        DruidDataSource master = new DruidDataSource();
        master.setDriverClassName(this.driverClassName0);
        master.setUrl(this.url0);
        master.setUsername(this.username0);
        master.setPassword(this.password0);
        //dataSource0.setFilters(this.filters);

        DruidDataSource slave01 = new DruidDataSource();
        slave01.setDriverClassName(this.driverClassName1);
        slave01.setUrl(this.url1);
        slave01.setUsername(this.username1);
        slave01.setPassword(this.password1);
        //dataSource1.setFilters(this.filters);

        //分库设置
        Map<String, DataSource> dataSourceMap = new HashMap<>(3);
        //添加两个数据库database0和database1
        dataSourceMap.put("ds_master", master);
        dataSourceMap.put("ds_slave01", slave01);
        return dataSourceMap;
    }
}
