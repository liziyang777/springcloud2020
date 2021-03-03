//package springcloud.task;
//
//import com.ecwid.consul.v1.ConsulClient;
//import com.ecwid.consul.v1.agent.model.Check;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.stereotype.Component;
//
//import java.util.Iterator;
//import java.util.Map;
//
///**
// * 定时清除consul失效服务
// */
//@Component
//@EnableScheduling
//@Slf4j
//public class CleanUpTask implements SchedulingConfigurer {
//    @Autowired
//    private ConsulClient consulClient;
//
//    public String cronSycn = "0 * * * * ?";
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addCronTask(() -> {
//            log.info("***********************consul上无效服务清理开始*******************************************");
//
//            //获取所有的services检查信息
//            Iterator<Map.Entry<String, Check>> it = consulClient.getAgentChecks().getValue().entrySet().iterator();
//            Map.Entry<String, Check> serviceMap = null;
//            while (it.hasNext()) {
//                //迭代数据
//                serviceMap = it.next();
//                //获取服务名称
//                String serviceName = serviceMap.getValue().getServiceName();
//                //获取服务ID
//                String serviceId = serviceMap.getValue().getServiceId();
//                log.info("服务名称 :{} 服务ID:{}", serviceName, serviceId);
//                //获取健康状态值  PASSING：正常  WARNING  CRITICAL  UNKNOWN：不正常
//                log.info("服务 :{}的健康状态值：{}", serviceName, serviceMap.getValue().getStatus());
//                if (serviceMap.getValue().getStatus() == Check.CheckStatus.CRITICAL) {
//                    log.info("服务 :{}为无效服务，准备清理...................", serviceName);
//                    consulClient.agentServiceDeregister(serviceId);
//                }
//            }
//            log.info("***********************consul上无效服务清理结束*******************************************");
//        }, cronSycn);
//    }
//}
