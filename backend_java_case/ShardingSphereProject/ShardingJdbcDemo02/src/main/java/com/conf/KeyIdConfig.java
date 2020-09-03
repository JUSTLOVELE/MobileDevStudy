package com.conf;

import org.springframework.context.annotation.Configuration;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangzl 2020.09.03
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Configuration
public class KeyIdConfig {

    @Bean("userKeyGenerator")
    public SnowflakeShardingKeyGenerator userKeyGenerator() {
        return new SnowflakeShardingKeyGenerator();
    }

    @Bean("orderKeyGenerator")
    public SnowflakeShardingKeyGenerator orderKeyGenerator() {
        return new SnowflakeShardingKeyGenerator();
    }
}
