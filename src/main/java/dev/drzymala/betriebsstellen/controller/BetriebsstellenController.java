package dev.drzymala.betriebsstellen.controller;


import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvValidationException;
import dev.drzymala.betriebsstellen.entity.Betriebsstelle;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{abkuerzung}")
    public ResponseEntity<Betriebsstelle> getBetriebsstelle(@PathVariable String query) throws IOException {
        try (
                //Open CSV and create reader
                Reader reader = Files.newBufferedReader(Paths.get("./DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv"));
                CSVReader csvReader = new CSVReader(reader)) {
                    // Iterate through CSV with openCSV
                    String[] zeile;
                    while ((zeile = csvReader.readNext()) != null) {
                        String[] abk = zeile[0].split(";");

                        // If first element is equal to query -> return Betriebsstelle in JSON
                        if (abk[0].equalsIgnoreCase(query.replace('-',' '))) {
                            Betriebsstelle betriebsstelle = new Betriebsstelle();
                            // TODO: Init Betriebsstelle with CSV
                            return new ResponseEntity(betriebsstelle, HttpStatus.OK);
                        }
                    }
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

                } catch (IOException | CsvValidationException ex) {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
    }
}

