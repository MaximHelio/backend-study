package com.example.demo.system;

import com.example.boot.autoconfigure.cache.JCacheManagerCustomizer;
import com.example.cache.annotation.EnableCaching;
import com.example.cahce.context.annotation.Bean;
import com.example.context.annotation.Configuration;

import javax.cache.configuration.MutableConfiguration;


@Configuration(proxyBeanMethos = false)
@EnableCaching
class CacheConfiguration {

    @Bean
    public JCacheManagerCustomizer petclinicCacheConfigurationCustomizer(){
        return cm -> {
            cm.createCache("vets", cacheConfiguration())
        }
    }

    private javax.cache.configuration.Configuration<Object, object> cacheConfiguration(){
        return new MutableConfiguration<>().setStatisticsEnabled(true)
    }
}