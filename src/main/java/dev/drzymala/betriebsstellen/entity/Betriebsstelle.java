package dev.drzymala.betriebsstellen.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Betriebsstelle {

    @Id
    @SequenceGenerator(
            name = "betriebsstelle_sequence",
            sequenceName = "betriebsstelle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "issues_sequence"
    )
    private Long id;
    private String Abkurzung;
    private String Name;
    private String Kurzname;
    private String Typ;
    private String BetrZust;
    private String PrimaryLocationCode;
    private Long UIC;
    private Long RB;
    private Long gültigVon;
    private Long gültigBis;
    private Long NetzKey;
    private String FplRel;
    private String FplGr;

    /**
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
}
