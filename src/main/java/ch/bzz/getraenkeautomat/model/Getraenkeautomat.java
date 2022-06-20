package ch.bzz.getraenkeautomat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Getraenkeautomat {
    private String getraenkeautomatUUID;

    @JsonIgnore
    private List<Getraenk> getraenke;

    private String modellnummer;
    private String farbe;

    public Getraenkeautomat() {
        setGetraenke(new ArrayList<>());
    }

    /**
     * gets getraenkeautomatUUID
     *
     * @return value of getraenkeautomatUUID
     */
    public String getGetraenkeautomatUUID() {
        return getraenkeautomatUUID;
    }

    /**
     * sets getraenkeautomatUUID
     *
     * @param getraenkeautomatUUID the value to set
     */
    public void setGetraenkeautomatUUID(String getraenkeautomatUUID) {
        this.getraenkeautomatUUID = getraenkeautomatUUID;
    }

    /**
     * gets getraenke
     *
     * @return value of getraenke
     */
    public List<Getraenk> getGetraenke() {
        return getraenke;
    }

    /**
     * sets getraenke
     *
     * @param getraenke the value to set
     */
    public void setGetraenke(List<Getraenk> getraenke) {
        this.getraenke = getraenke;
    }

    /**
     * gets modellnummer
     *
     * @return value of modellnummer
     */
    public String getModellnummer() {
        return modellnummer;
    }

    /**
     * sets modellnummer
     *
     * @param modellnummer the value to set
     */
    public void setModellnummer(String modellnummer) {
        this.modellnummer = modellnummer;
    }

    /**
     * gets farbe
     *
     * @return value of farbe
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * sets farbe
     *
     * @param farbe the value to set
     */
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
