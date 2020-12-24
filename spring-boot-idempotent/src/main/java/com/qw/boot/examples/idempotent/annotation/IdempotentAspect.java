package com.qw.boot.examples.idempotent.annotation;

import com.qw.boot.examples.base.util.R;
import com.qw.boot.examples.idempotent.common.IdempotentException;
import com.qw.boot.examples.idempotent.util.IdempotentKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/23 6:17 下午
 * <br> Copyright (c) 2020/12/23 ZiYun Tech.
 */
@Component
@Slf4j
@Aspect
@ConditionalOnClass(RedisTemplate.class)
public class IdempotentAspect {
    private static final String KEY_TEMPLATE = "idempotent_%S";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 切点(自定义注解)
     */
    @Pointcut("@annotation(com.qw.boot.examples.idempotent.annotation.Idempotent)")
    public void executeIdempotent() {
    }

    /**
     * 切点业务
     *
     * @throws Throwable
     */
    @Around("executeIdempotent()")
    public Object arountd(ProceedingJoinPoint jPoint) throws Throwable {
        //获取当前方法信息
        Method method = ((MethodSignature) jPoint.getSignature()).getMethod();
        //获取注解
        Idempotent idempotent = method.getAnnotation(Idempotent.class);
        //生成Key
        Object[] args = jPoint.getArgs();
        int[] custArgs = idempotent.custKeysByParameterIndexArr();

        String key = String.format(KEY_TEMPLATE, idempotent.key() + "_" + IdempotentKeyUtil.generate(method, custArgs, args));
        //https://segmentfault.com/a/1190000002870317 -- JedisCommands接口的分析
        //nxxx的值只能取NX或者XX，如果取NX，则只有当key不存在是才进行set，如果取XX，则只有当key已经存在时才进行set
        //expx expx的值只能取EX或者PX，代表数据过期时间的单位，EX代表秒，PX代表毫秒
        // key value nxxx(set规则) expx(取值规则) time(过期时间)

        //低版本`Springboot`使用如下方法
//        String redisRes = redisTemplate.execute((RedisCallback<String>) conn -> ((RedisAsyncCommands) conn).getStatefulConnection().sync().set(key, "NX", "EX", idempotent.expirMillis()));

        // Jedis jedis = new Jedis("127.0.0.1",6379);
        // jedis.auth("xuzz");
        // jedis.select(0);
        // String redisRes = jedis.set(key, key,"NX","EX",idempotent.expirMillis());
        Boolean result = redisTemplate.opsForValue().setIfAbsent(key, "0", idempotent.expirMillis(), TimeUnit.SECONDS);

        if (result) {
            return jPoint.proceed();
        } else {
            System.out.println("数据幂等错误");
            throw new IdempotentException("幂等校验失败。key值为：" + IdempotentKeyUtil.getKeyOriginalString(method, custArgs, args));
        }
    }

}
