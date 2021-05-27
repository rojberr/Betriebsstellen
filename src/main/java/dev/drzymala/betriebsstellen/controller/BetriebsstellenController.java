package dev.drzymala.betriebsstellen.controller;


import dev.drzymala.betriebsstellen.betriebsstelle.Betriebsstelle;
import dev.drzymala.betriebsstellen.betriebsstelle.BetriebsstelleService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@AllArgsConstructor
@RequestMapping(value="/betriebsstelle", produces = MediaType.APPLICATION_JSON_VALUE)
public class BetriebsstellenController {

//    Beispiel-Request:
//    .../betriebsstelle/aamp
//
//    Beispiel-Response:
//    HTTP-STATUS: 200
//    {
//        Name: Hamburg Anckelmannsplatz
//        Kurzname: Anckelmannsplatz
//        Typ: Ost
//    }

    private final BetriebsstelleService betriebsstelleService;

    @GetMapping("/{query}")
    public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String query) throws IOException {
        return betriebsstelleService.findByAbk(query);
    }
}

