package ch.bzz.getraenkeautomat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.ws.rs.FormParam;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Getraenkeautomat {
    @FormParam("getraenkeautomatUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String getraenkeautomatUUID;

    @JsonIgnore
    private List<Getraenk> getraenke;

    @FormParam("modellnummer")
    @NotEmpty
    @Pattern(regexp = "^\\d{7}$")
    private String modellnummer;

    @FormParam("farbe")
    @NotEmpty
    @Size(min = 1, max = 30)
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
