package dev.drzymala.betriebsstellen.controller;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import dev.drzymala.betriebsstellen.entity.Betriebsstelle;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
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

    @GetMapping("/{query}")
    public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String query) throws IOException {
        try (
                //Open CSV and create reader
                Reader reader = Files.newBufferedReader(Paths.get("./DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv"));
                CSVReader csvReader = new CSVReader(reader)) {
                    // Iterate through CSV
                    String[] input;
                    while ((input = csvReader.readNext()) != null) {
                        String[] zeile = input[0].split(";");

                        // If query equals abk return JSON
                        if (zeile[0].equalsIgnoreCase(query.replace('-',' '))) {
                            Betriebsstelle betriebsstelle = new Betriebsstelle(zeile);
                            return new ResponseEntity(betriebsstelle, HttpStatus.OK);
                        }
                    }
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

                } catch (IOException | CsvValidationException ex) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
    }
}

