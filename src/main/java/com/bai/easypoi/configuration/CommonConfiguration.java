package com.bai.easypoi.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(CommonConfiguration.class);

    @Autowired
    private ApplicationContext applicationContext;

    public CommonConfiguration() {
       // if(logger.isDebugEnabled()) {
            logger.info("CommonConfiguration.CommonConfiguration......");
        //}
    }
}
