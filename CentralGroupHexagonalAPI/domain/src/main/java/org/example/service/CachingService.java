package org.example.service;

import org.example.constantParams.ConstantParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CachingService {

    @Autowired
    CacheManager cacheManager;

   public void evictSingleCacheValue(String cacheName, String cacheKey){
       cacheManager.getCache(cacheName).evict(cacheKey);
   }
    public void evictAllCachesValue(){
        cacheManager.getCacheNames().stream().parallel().forEach(e -> cacheManager.getCache(e).clear());
    }

    @Scheduled(fixedRate = ConstantParam.CACHE_SCHEDULE_TIME)
    public void evictAllCachesValueAtInterval(){
        System.out.println("Clear cache common formula: " + new Date());
        evictAllCachesValue();
    }

}
