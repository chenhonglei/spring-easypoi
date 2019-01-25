package com.bai.easypoi.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(CommonConfiguration.class)
public class RedisConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

    public RedisConfiguration() {
        //if(logger.isDebugEnabled()) {
            logger.info("RedisConfiguration.RedisConfiguration......");
        //}
    }
    /*
    @Value("${spring.redis.type}")
    private String redisType;

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.password}")
    private String redisAuth;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Value("${spring.redis.database}")
    private Integer redisDatabase;

    @Value("${spring.redis.timeout}")
    private Integer redisTimeout;

    @Value("${spring.redis.poolsize}")
    private Integer poolSize;

    @Value("${spring.redis.subpoolsize}")
    private Integer subPoolSize;

    private enum RedisType {
        SINGLE("single");

        private String stringValue;

        RedisType(String s) {
            stringValue = s;
        }

        public String getStringValue() {
            return stringValue;
        }
    }

    @Bean(destroyMethod = "shutdown" ,name="redissonClient")
    public RedissonClient redissonClient() {
        Config config = new Config();
        if (StringUtils.isEmpty(redisType) || redisType.equals(RedisType.SINGLE.getStringValue())) {
            String redisUrl = redisHost +":" + redisPort;
            config.useSingleServer().setAddress(redisUrl);
            config.useSingleServer().setDatabase(redisDatabase);
            config.useSingleServer().setTimeout(redisTimeout);
            config.useSingleServer().setConnectTimeout(redisTimeout);
            config.useSingleServer().setSubscriptionConnectionPoolSize(subPoolSize);
            config.useSingleServer().setConnectionPoolSize(poolSize);
            if (StringUtils.isNotEmpty(redisAuth)) {
                config.useSingleServer().setPassword(redisAuth);
            }
        }
        RedissonClient client = Redisson.create(config);
        logger.info("成功连接redis server......\t 连接IP:{}端口:{}服务器",redisHost,redisPort);
        return client;
    }*/
}
