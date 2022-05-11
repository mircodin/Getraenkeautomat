package ch.bzz.getraenkeautomat.model;

import java.time.LocalDate;

public class Getraenk {
    private String bezeichnung;
    private Double preis;
    private Integer inhaltInML;
    private LocalDate ablaufdatum;

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
}
