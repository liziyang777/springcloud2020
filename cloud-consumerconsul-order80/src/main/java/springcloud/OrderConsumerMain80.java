package springcloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OrderConsumerMain80 {

    private static final String INVOKE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain80.class, args);
    }

    @RequestMapping("/hello")
    public String home() {
//        String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return "{\n" +
                "\"status\": \"UP\",\n" +
                "\"application\": {\n" +
                "\"status\": \"UP\"\n" +
                "}\n" +
                "}";
    }


}
