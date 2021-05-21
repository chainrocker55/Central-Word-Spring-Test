package org.example.caching;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CachingConfig {
//    @Bean
//    Config config() {
//        Config config = new Config();
//
//        MapConfig mapConfig = new MapConfig();
//        mapConfig.setTimeToLiveSeconds(300);
//        config.getMapConfigs().put("cars", mapConfig);
//
//        return config;
//    }
}
