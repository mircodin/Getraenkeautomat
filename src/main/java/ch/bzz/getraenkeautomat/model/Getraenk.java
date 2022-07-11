package ch.bzz.getraenkeautomat.model;

import ch.bzz.getraenkeautomat.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;

import javax.ws.rs.FormParam;
import java.time.LocalDate;
import java.util.Date;

public class Getraenk {
    @FormParam("getraenkUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String getraenkUUID;

    @FormParam("bezeichnung")
    @NotEmpty
    @Size(min = 1, max = 30)
    private String bezeichnung;

    @FormParam("preis")
    @NotEmpty
    @DecimalMin(value = "0.05")
    @DecimalMax(value = "100.00")
    private Double preis;

    @FormParam("inhaltInML")
    @NotEmpty
    @Size(min = 1, max = 10000)
    private Integer inhaltInML;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FormParam("ablaufdatum")
    @NotEmpty
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$")
    private Date ablaufdatum;

    @JsonIgnore
    private Marke marke;

    public void setMarkeUUID(String markeUUID){
        setMarke(new Marke());
        Marke marke = DataHandler.readMarkeByUUID(markeUUID);
        getMarke().setMarkeUUID(markeUUID);
        getMarke().setBezeichnung(marke.getBezeichnung());
        getMarke().setHauptsitz(marke.getHauptsitz());
        getMarke().setUmsatz(marke.getUmsatz());
        getMarke().setTelefonnummer(marke.getTelefonnummer());
    }

    public String getMarkeUUID() {
        if (getMarke() == null) return null;
        return  getMarke().getMarkeUUID();
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
