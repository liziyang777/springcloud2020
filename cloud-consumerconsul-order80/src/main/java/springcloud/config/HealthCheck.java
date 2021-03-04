package springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 重写后， 调用 http://localhost:8001/actuator/health 运行该处方法
 */
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
