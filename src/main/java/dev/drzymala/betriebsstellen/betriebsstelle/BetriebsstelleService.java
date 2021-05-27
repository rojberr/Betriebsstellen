package dev.drzymala.betriebsstellen.betriebsstelle;

import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface BetriebsstelleService {
    // List of functions (easily updated - clean code)
    ResponseEntity<Betriebsstelle> findByAbk(String query) throws IOException;
    // - another function ...
    // - and another ...
    // - ...
}
