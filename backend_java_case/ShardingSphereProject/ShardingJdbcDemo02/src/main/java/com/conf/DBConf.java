package com.conf;

import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.StandardShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/**
 * @author yangzl 2020.09.03
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

//    @Value(("${spring.datasource.druid.filters}"))
//    private String filters;

    @Bean("dataSource")
    public DataSource dataSource() {
        try {
            DruidDataSource dataSource0 = new DruidDataSource();
            dataSource0.setDriverClassName(this.driverClassName0);
            dataSource0.setUrl(this.url0);
            dataSource0.setUsername(this.username0);
            dataSource0.setPassword(this.password0);
            //dataSource0.setFilters(this.filters);

            DruidDataSource dataSource1 = new DruidDataSource();
            dataSource1.setDriverClassName(this.driverClassName1);
            dataSource1.setUrl(this.url1);
            dataSource1.setUsername(this.username1);
            dataSource1.setPassword(this.password1);
            //dataSource1.setFilters(this.filters);

            //分库设置
            Map<String, DataSource> dataSourceMap = new HashMap<>(2);
            //添加两个数据库database0和database1
            dataSourceMap.put("m1", dataSource0);
            dataSourceMap.put("m2", dataSource1);

            // 配置表规则
            TableRuleConfiguration userRuleConfiguration = new TableRuleConfiguration("course", "m$->{1..2}.course_$->{1..2}");
            // 行表达式分表规则
            userRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("cid", "course_$->{cid % 2 + 1}"));
            // 行表达式分库规则
            userRuleConfiguration.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "m$->{user_id % 2 + 1}"));
            // Sharding全局配置
            ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
            shardingRuleConfiguration.getTableRuleConfigs().add(userRuleConfiguration);
            // 创建数据源
            DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration, new Properties());
            return dataSource;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
