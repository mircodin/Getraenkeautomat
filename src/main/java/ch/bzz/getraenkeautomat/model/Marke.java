package ch.bzz.getraenkeautomat.model;

public class Marke {
    private String markeUUID;
    private String bezeichnung;
    private String hauptsitz;
    private Integer umsatz;
    private String telefonnummer;

    public String getMarkeUUID() {
        return markeUUID;
    }

    public void setMarkeUUID(String markeUUID) {
        this.markeUUID = markeUUID;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getHauptsitz() {
        return hauptsitz;
    }

    public void setHauptsitz(String hauptsitz) {
        this.hauptsitz = hauptsitz;
    }

    public Integer getUmsatz() {
        return umsatz;
    }

    public void setUmsatz(Integer umsatz) {
        this.umsatz = umsatz;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
