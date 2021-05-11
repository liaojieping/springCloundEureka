package eurekaprovide.demo.controller;

import eurekaprovide.demo.service.provideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class provideController {
    @Autowired
    public provideService service;

    @GetMapping("/ticket")
    public String getTiket() {
        return service.getTikcet();
    }
}
