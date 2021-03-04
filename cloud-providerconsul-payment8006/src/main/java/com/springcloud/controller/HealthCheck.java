package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service("consulHealthIndicator")
@Slf4j
@Component
public class HealthCheck extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 自由发挥，可以直接写 builder.up();也可以按照最新的健康检查逻辑拷贝进来
        log.info("health check....");

    }
}
