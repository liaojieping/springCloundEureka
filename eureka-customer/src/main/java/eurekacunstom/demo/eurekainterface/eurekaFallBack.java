package eurekacunstom.demo.eurekainterface;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class eurekaFallBack  implements FallbackFactory<eurekaInterface> {
    @Override
    public eurekaInterface create(Throwable throwable) {
        return new eurekaInterface(){
            @Override
            public String aa() {
                return "Feign熔断";
            }
        };
    }
}
