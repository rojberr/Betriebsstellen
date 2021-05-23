package dev.drzymala.betriebsstellen.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BetriebsstellenController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
