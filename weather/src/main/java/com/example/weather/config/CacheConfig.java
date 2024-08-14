package com.example.weather.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfig {
    private static final Logger logger = LoggerFactory.getLogger(CacheConfig.class);
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("weather");
    }

    @Scheduled(fixedRate = 60000)
    public void clearCache() {
        logger.info("Очистка кэша погоды...");
        cacheManager().getCache("weather").clear();
    }
}
