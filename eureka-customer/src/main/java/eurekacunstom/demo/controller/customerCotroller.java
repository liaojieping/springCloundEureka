package eurekacunstom.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import eurekacunstom.demo.customerService.CustomerService;
import eurekacunstom.demo.eurekainterface.eurekaInterface;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerCotroller {
    @Autowired
    public  CustomerService service;

    @Autowired
    public eurekaInterface aa;

    @GetMapping("/test") //没有使用feign
    @HystrixCommand(fallbackMethod = "hystrix_Prox") //一旦调用失败，会自动调用hystrix_Prox方法
    public String get(){
        return "购买了电影票8082："+service.getTicket();
    }

    public String hystrix_Prox(){
        return "调用降级熔断";
    }

    @GetMapping("/test1") //使用Feign面向接口编程,也调用了熔断
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")//用户具有 ROLE_ADMIN 权限时才能访问，否则返回 401 未授权
    //@HystrixCommand(fallbackMethod = "hystrix_Prox") //一旦调用失败，会自动调用hystrix_Prox方法
    public String get1(){
        //用hutool生成二维码
      QrCodeUtil.generate("倪玲是猪", 300, 300, FileUtil.file("d:/qrcode.jpg"));
       // QrConfig aaa=new QrConfig();
        return "购买了电影票12："+aa.aa();
    }
}
