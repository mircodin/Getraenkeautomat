package ch.bzz.getraenkeautomat.model;

import java.util.List;

public class Getraenkeautomat {
    private List<Getraenk> getraenke;
    private String modellnummer;
    private String farbe;

    public List<Getraenk> getGetraenke() {
        return getraenke;
    }

    public void setGetraenke(List<Getraenk> getraenke) {
        this.getraenke = getraenke;
    }

    public String getModellnummer() {
        return modellnummer;
    }

    public void setModellnummer(String modellnummer) {
        this.modellnummer = modellnummer;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
