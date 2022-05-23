package ch.bzz.getraenkeautomat.model;

import java.util.List;

public class Getraenkeautomat {
    private String getraenkeautomatUUID;
    private List<Getraenk> getraenke;
    private String modellnummer;
    private String farbe;

    /**
     * gets getraenkeautomatUUID
     *
     * @return value of getraenkeautomatUUID
     */
    public String getGetraenkeautomatUUID() {
        return getraenkeautomatUUID;
    }

    /**
     * gets getraenkeautomatUUID
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
     * gets getraenke
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
     * gets modellnummer
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
     * gets farbe
     *
     * @param farbe the value to set
     */
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
