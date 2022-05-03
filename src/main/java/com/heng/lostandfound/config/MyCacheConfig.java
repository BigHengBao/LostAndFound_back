package com.heng.lostandfound.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/5/3/12:47
 * title：
 */
//
//@Configuration
//@EnableCaching
//@EnableConfigurationProperties(CacheProperties.class)
//public class MyCacheConfig {
//
////    @Autowired
////    CacheProperties cacheProperties;
//
//    @Bean
//    public RedisCacheConfiguration redisCacheConfiguration(CacheProperties cacheProperties) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//        config = config.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()));
//        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//
//        CacheProperties.Redis redis = cacheProperties.getRedis();
//
//        if (redis.getTimeToLive() != null) {
//            config = config.entryTtl(redis.getTimeToLive());
//        }
//        if (redis.getKeyPrefix() != null) {
//            config = config.prefixKeysWith(redis.getKeyPrefix());
//        }
//        if (!redis.isCacheNullValues()) {
//            config = config.disableCachingNullValues();
//        }
//        if (!redis.isUseKeyPrefix()) {
//            config = config.disableKeyPrefix();
//        }
//        return config;
//
//    }
//
//
//
//}
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class MyCacheConfig {
    @Bean(name="redisTemplate")
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(redisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(redisSerializer);
        //key haspmap序列化
        template.setHashKeySerializer(redisSerializer);
        //
        return template;
    }
}
