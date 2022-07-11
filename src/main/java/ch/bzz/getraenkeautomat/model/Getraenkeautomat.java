package ch.bzz.getraenkeautomat.model;

import ch.bzz.getraenkeautomat.data.DataHandler;
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
    @Size(min = 1, max = 7)
    private String modellnummer;

    @FormParam("farbe")
    @NotEmpty
    @Size(min = 1, max = 30)
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
    public List<Getraenk> getGetraenkeList() {
        return getraenke;
    }

    /**
     * sets getraenke
     *
     * @param getraenke the value to set
     */
    public void setGetraenkeList(List<Getraenk> getraenke) {
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

    /**
     * sets the getraenke from their UUIDs
     *
     * @param uuidList  list of getraenke-uuids
     */
    public void setAGetraenkUUID(List<String> uuidList) {

        this.setGetraenkeList(new ArrayList<>());
        for (String uuid : uuidList) {
            Getraenk getraenk = DataHandler.readGetraenkByUUID(uuid);
            this.getGetraenkeList().add(getraenk);
        }
    }

    /**
     * gets all the Getraenke of a Getraenkeautomat
     * @return  all getraenke as comma separated string
     */
    @JsonIgnore
    public String getGetraenke() {
        StringBuilder getraenke = new StringBuilder();
        if (this.getGetraenkeList() != null) {
            List<String> uuidList = new ArrayList<>();
            for (Getraenk getraenk : this.getGetraenkeList()) {
                getraenke.append(getraenk.getBezeichnung()).append(", ");
                getraenke.append(getraenk.getPreis()).append(", ");
                getraenke.append(getraenk.getInhaltInML()).append(", ");
                getraenke.append(getraenk.getAblaufdatum()).append(", ");
            }

        }
        return (getraenke.length() == 0)
                ? null
                : (getraenke.substring(0, getraenke.length() - 2));
    }
}
