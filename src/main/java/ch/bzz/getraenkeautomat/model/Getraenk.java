package ch.bzz.getraenkeautomat.model;

import java.time.LocalDate;

public class Getraenk {
    private String getraenkUUID;
    private String bezeichnung;
    private Double preis;
    private Integer inhaltInML;
    private LocalDate ablaufdatum;
    private Getraenkeautomat getraenkeautomat;
    private Marke marke;

    public String getGetraenkUUID() {
        return getraenkUUID;
    }

    public void setGetraenkUUID(String getraenkUUID) {
        this.getraenkUUID = getraenkUUID;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public Integer getInhaltInML() {
        return inhaltInML;
    }

    public void setInhaltInML(Integer inhaltInML) {
        this.inhaltInML = inhaltInML;
    }

    public LocalDate getAblaufdatum() {
        return ablaufdatum;
    }

    public void setAblaufdatum(LocalDate ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }

    public Getraenkeautomat getGetraenkeautomat() {
        return getraenkeautomat;
    }

    public void setGetraenkeautomat(Getraenkeautomat getraenkeautomat) {
        this.getraenkeautomat = getraenkeautomat;
    }

    public Marke getMarke() {
        return marke;
    }

    public void setMarke(Marke marke) {
        this.marke = marke;
    }
}
