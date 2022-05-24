package ch.bzz.getraenkeautomat.model;

import ch.bzz.getraenkeautomat.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Date;

public class Getraenk {
    private String getraenkUUID;
    private String bezeichnung;
    private Double preis;
    private Integer inhaltInML;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ablaufdatum;

    @JsonIgnore
    private Getraenkeautomat getraenkeautomat;

    @JsonIgnore
    private Marke marke;

    public void setGetraenkeautomatUUID(String getraenkeautomatUUID){
        setGetraenkeautomat(DataHandler.getInstance().readGetraenkeautomatbyUUID(getraenkeautomatUUID));
    }

    public void setMarkeUUID(String markeUUID){
        setMarke(DataHandler.getInstance().readMarkeByUUID(markeUUID));
    }

    /**
     * gets getraenkUUID
     *
     * @return value of getraenkUUID
     */
    public String getGetraenkUUID() {
        return getraenkUUID;
    }

    /**
     * sets getraenkUUID
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
     * sets bezeichnung
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
     * sets preis
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
     * sets inhaltInML
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
    public Date getAblaufdatum() {
        return ablaufdatum;
    }

    /**
     * sets ablaufdatum
     *
     * @param ablaufdatum the value to set
     */
    public void setAblaufdatum(Date ablaufdatum) {
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
     * sets getraenkeautomat
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
     * sets marke
     *
     * @param marke the value to set
     */
    public void setMarke(Marke marke) {
        this.marke = marke;
    }
}
