package dev.drzymala.betriebsstellen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BetriebsstellenController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
