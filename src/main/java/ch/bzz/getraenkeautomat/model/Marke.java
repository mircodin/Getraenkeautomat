package ch.bzz.getraenkeautomat.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

public class Marke {
    @FormParam("markeUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String markeUUID;

    @FormParam("bezeichnung")
    @NotEmpty
    @Size(min = 1, max = 30)
    private String bezeichnung;

    @FormParam("hauptsitz")
    @NotEmpty
    @Size(min = 1, max = 30)
    private String hauptsitz;

    @FormParam("umsatz")
    @NotEmpty
    @Size(min = 1, max = 9000000)
    private Integer umsatz;

    @FormParam("telefonnummer")
    @NotEmpty
    @Pattern(regexp = "^+?[1-9]\\d{1,14}$")
    private String telefonnummer;

    /**
     * gets markeUUID
     *
     * @return value of markeUUID
     */
    public String getMarkeUUID() {
        return markeUUID;
    }

    /**
     * sets markeUUID
     *
     * @param markeUUID the value to set
     */
    public void setMarkeUUID(String markeUUID) {
        this.markeUUID = markeUUID;
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
     * gets hauptsitz
     *
     * @return value of hauptsitz
     */
    public String getHauptsitz() {
        return hauptsitz;
    }

    /**
     * sets hauptsitz
     *
     * @param hauptsitz the value to set
     */
    public void setHauptsitz(String hauptsitz) {
        this.hauptsitz = hauptsitz;
    }

    /**
     * gets umsatz
     *
     * @return value of umsatz
     */
    public Integer getUmsatz() {
        return umsatz;
    }

    /**
     * sets umsatz
     *
     * @param umsatz the value to set
     */
    public void setUmsatz(Integer umsatz) {
        this.umsatz = umsatz;
    }

    /**
     * gets telefonnummer
     *
     * @return value of telefonnummer
     */
    public String getTelefonnummer() {
        return telefonnummer;
    }

    /**
     * sets telefonnummer
     *
     * @param telefonnummer the value to set
     */
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
