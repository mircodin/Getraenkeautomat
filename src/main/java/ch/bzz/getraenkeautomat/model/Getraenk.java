package ch.bzz.getraenkeautomat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Getraenk {
    private String getraenkUUID;
    private String bezeichnung;
    private Double preis;
    private Integer inhaltInML;
    // @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate ablaufdatum;
    private Getraenkeautomat getraenkeautomat;
    private Marke marke;

    /**
     * gets getraenkUUID
     *
     * @return value of getraenkUUID
     */
    public String getGetraenkUUID() {
        return getraenkUUID;
    }

    /**
     * gets getraenkUUID
     *
     * @param getraenkUUID the value to set
     */
    public void setGetraenkUUID(String getraenkUUID) {
        this.getraenkUUID = getraenkUUID;
    }

    /**
     * gets bezeichnung
     *
     * @return value of bezeichnung
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * gets bezeichnung
     *
     * @param bezeichnung the value to set
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * gets preis
     *
     * @return value of preis
     */
    public Double getPreis() {
        return preis;
    }

    /**
     * gets preis
     *
     * @param preis the value to set
     */
    public void setPreis(Double preis) {
        this.preis = preis;
    }

    /**
     * gets inhaltInML
     *
     * @return value of inhaltInML
     */
    public Integer getInhaltInML() {
        return inhaltInML;
    }

    /**
     * gets inhaltInML
     *
     * @param inhaltInML the value to set
     */
    public void setInhaltInML(Integer inhaltInML) {
        this.inhaltInML = inhaltInML;
    }

    /**
     * gets ablaufdatum
     *
     * @return value of ablaufdatum
     */
    public LocalDate getAblaufdatum() {
        return ablaufdatum;
    }

    /**
     * gets ablaufdatum
     *
     * @param ablaufdatum the value to set
     */
    public void setAblaufdatum(LocalDate ablaufdatum) {
        this.ablaufdatum = ablaufdatum;
    }

    /**
     * gets getraenkeautomat
     *
     * @return value of getraenkeautomat
     */
    public Getraenkeautomat getGetraenkeautomat() {
        return getraenkeautomat;
    }

    /**
     * gets getraenkeautomat
     *
     * @param getraenkeautomat the value to set
     */
    public void setGetraenkeautomat(Getraenkeautomat getraenkeautomat) {
        this.getraenkeautomat = getraenkeautomat;
    }

    /**
     * gets marke
     *
     * @return value of marke
     */
    public Marke getMarke() {
        return marke;
    }

    /**
     * gets marke
     *
     * @param marke the value to set
     */
    public void setMarke(Marke marke) {
        this.marke = marke;
    }
}
