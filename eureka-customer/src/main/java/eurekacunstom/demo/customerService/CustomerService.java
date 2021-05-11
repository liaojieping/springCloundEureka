package eurekacunstom.demo.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    public RestTemplate restTemplate;

    public String getTicket() {
        return restTemplate.getForObject("http://EUREKA-PROVIDE/ticket", String.class);
    }
}
