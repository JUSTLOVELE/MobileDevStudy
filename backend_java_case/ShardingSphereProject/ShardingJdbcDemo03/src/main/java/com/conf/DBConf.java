package com.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
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

    @Value("${datasource2.url}")
    private String url2;
    @Value("${datasource2.username}")
    private String username2;
    @Value("${datasource2.password}")
    private String password2;
    @Value("${datasource2.driver-class-name}")
    private String driverClassName2;

    @Bean("dataSource")
    public DataSource dataSource() {

        try {
            // Sharding全局配置
            ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
            //配置t_user
            shardingRuleConfiguration.getTableRuleConfigs().add(confTUserRule());
            //配置Course的水平分布
            shardingRuleConfiguration.getTableRuleConfigs().add(confCourseRule());
            //配置公共字典表
            shardingRuleConfiguration.getTableRuleConfigs().add(confTudictRule());
            //配置teacher表
            shardingRuleConfiguration.getTableRuleConfigs().add(confTeacherRule());
            //如果添加数据则三个库都会添加,如果删除则三个库都会删除
            shardingRuleConfiguration.getBroadcastTables().add("t_udict");
            // 自定义算法
            //shardingRuleConfiguration.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("t_id", "m1"));
            //shardingRuleConfiguration.setDefaultTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("t_id", new TableShardingAlgorithm()));
            // 创建数据源
            Properties props=new Properties();
            props.put("sql.show", "true");
            DataSource dataSource = ShardingDataSourceFactory.createDataSource(confDataSourceMap(), shardingRuleConfiguration, props);
            return dataSource;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private TableRuleConfiguration confTeacherRule() {

        // 配置表规则
        TableRuleConfiguration teacherConf = new TableRuleConfiguration("teacher", "m$->{1..2}.teacher_$->{1..2}");
        // 行表达式分表规则
        teacherConf.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("t_id", new TableShardingAlgorithm()));
        // 行表达式分库规则
        teacherConf.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("t_key", new DatabaseShardingAlgorithm()));
        return teacherConf;
        
    }

    /**
     * 水平分库分表
     * @return
     */
    private TableRuleConfiguration confCourseRule() {
        // 配置表规则
        TableRuleConfiguration courseConfig = new TableRuleConfiguration("course", "m$->{1..2}.course_$->{1..2}");
        // 行表达式分表规则
        courseConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("cid", "course_$->{cid % 2 + 1}"));
        // 行表达式分库规则
        courseConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "m$->{user_id % 2 + 1}"));
        return courseConfig;
    }

    /**
     * 配置公共字典表(每个数据库都有一个t_udict表)
     * @return
     */
    private TableRuleConfiguration confTudictRule() {

        TableRuleConfiguration dictConfig = new TableRuleConfiguration("t_udict");
        dictConfig.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE", "dict_id"));

        return dictConfig;
    }

    /**
     * 配置t_user专库配置(垂直分配)
     * @return
     */
    private TableRuleConfiguration confTUserRule() {
        // 配置表规则: t_user表在m0库中
        TableRuleConfiguration userRuleConfiguration = new TableRuleConfiguration("t_user", "m$->{0}.t_user");
        //配置生成策略
        userRuleConfiguration.setKeyGeneratorConfig(new KeyGeneratorConfiguration("SNOWFLAKE", "user_id"));
        // 行表达式分表规则
        userRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "t_user"));
        // 行表达式分库规则,专库专表不需要下面的配置
        //userRuleConfiguration.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "m$->{user_id % 2 + 1}"));
        return userRuleConfiguration;
    }

    /**
     * 配置数据源
     * @return
     */
    private Map<String, DataSource> confDataSourceMap() {

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

        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setDriverClassName(this.driverClassName2);
        dataSource2.setUrl(this.url2);
        dataSource2.setUsername(this.username2);
        dataSource2.setPassword(this.password2);
        //dataSource2.setFilters(this.filters);

        //分库设置
        Map<String, DataSource> dataSourceMap = new HashMap<>(3);
        //添加两个数据库database0和database1
        dataSourceMap.put("m0", dataSource0);
        dataSourceMap.put("m1", dataSource1);
        dataSourceMap.put("m2", dataSource2);
        return dataSourceMap;
    }
}
