package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 方法二：使用 DiscoveryClient 查询服务
 * <p>
 * 官网解释：You can also use the org.springframework.cloud.client.discovery.
 * DiscoveryClient which provides a simple API for discovery clients that is not specific to Netflix
 */
@RestController
@Slf4j
public class OrderConsulController {


    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 查询服务名下的实例
     * @return
     */
    @GetMapping("query")
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("client-2");
        if (list != null && list.size() > 0) {
            return String.valueOf(list.get(0).getUri());
        }
        return null;
    }

}
