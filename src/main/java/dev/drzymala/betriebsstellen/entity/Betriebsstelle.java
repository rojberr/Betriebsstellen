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
    private Long ReadableByteChannel;
    private Long gültigVon;
    private Long gültigBis;
    private Long NetzKey;
    private String FplRel;
    private String FplGr;
}
