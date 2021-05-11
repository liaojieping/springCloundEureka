package eurekacunstom.demo.eurekainterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-provide",fallbackFactory = eurekaFallBack.class) //使用feign调用微服务的名，以及熔断触发的方法
@Service
public interface eurekaInterface {
    @GetMapping("/ticket") //调用的微服务的接口名称
    public String aa();
}
