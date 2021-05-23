package dev.drzymala.betriebsstellen.entity;

import lombok.Data;

@Data
public class Betriebsstelle {
    /*
     * In den veröffentlichten Daten ist für jede Betriebsstelle definiert:
     *
     * * Abk: Abkürzung entsprechend Richtlinie 100.0001, die sich aus Ort und Art zusammensetzt. Eine gute Erklärung findet man in der Wikipedia
     * * Name: Langname, z.B. Frankfurt (Main) Galluswarte
     * * Kurzname: Kurzname, z.B. Ffm Galluswarte
     * * Typ: Zur Abk. gehörende Bahnstellenarten, z.B. Bf
     * * Betr-Zust: Betriebszustand
     * * Primary location code: Eindeutige Nr. innerhalb Europa, z.B. DE 13273
     * * UIC: UIC RICS code, z.B. 0080
     * * RB: Zuständiger Regionalbereich Netz, nur für Örtlichkeiten der DB Netz AG, z.B. 5
     * * gültig von im Format YYYYMMDD, z.B. 20081214
     * * gültig bis im Format YYYYMMDD. Bleibt frei, wenn keine Begrenzung vorliegt.
     * * Netz-Key: Eindeutiger unveränderlicher Schlüssel für alle Infrastrukturstellen, z.B. 117044
     * * Fpl-rel: Fahrplanrelevanz – dies ist eine im Fahrplan bestellbare Örtlichkeit – im Ausland nur ausnahmsweise gekennzeichnet, z.B. J
     * * Fpl-Gr: Fahrplanbearbeitungsgrenze – im Ausland nur ausnahmsweise gekennzeichnet, z.B. N
     */

    private String Abk;
    private String Name;
    private String Kurzname;
    private String Typ;
    private String BetrZust;
    private String PrimaryLocationCode;
    private String UIC; // Long
    private String RB; // Long
    private String GueltigVon; // Long
    private String GueltigBis; // Long
    private String NetzKey; // Long
    private String FplRel;
    private String FplGr;

    public Betriebsstelle(String[] zeile) {
        this.Abk = zeile[0];
        this.Name = zeile[1];
        this.Kurzname = zeile[2];
        this.Typ = zeile[3];
        this.BetrZust = zeile[4];
        this.PrimaryLocationCode = zeile[5];
        this.UIC = zeile[6];
        this.RB = zeile[7];
        this.GueltigVon = zeile[8];
        this.GueltigBis = zeile[9];
        this.NetzKey = zeile[10];
        this.FplRel = zeile[11];
        this.FplGr = zeile[12];
    }
}
