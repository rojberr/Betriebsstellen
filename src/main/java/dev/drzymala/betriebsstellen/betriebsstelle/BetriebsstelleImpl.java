package dev.drzymala.betriebsstellen.betriebsstelle;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
public class BetriebsstelleImpl implements BetriebsstelleService {

    @Override
    public ResponseEntity<Betriebsstelle> findByAbk(String query) throws IOException {
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
