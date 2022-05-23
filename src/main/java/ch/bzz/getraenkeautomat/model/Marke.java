package ch.bzz.getraenkeautomat.model;

public class Marke {
    private String markeUUID;
    private String bezeichnung;
    private String hauptsitz;
    private Integer umsatz;
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
