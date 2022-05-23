package ch.bzz.getraenkeautomat.data;

import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Marke;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;
import ch.bzz.getraenkeautomat.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Getraenk> getraenkList;
    private List<Marke> markeList;
    private List<Getraenkeautomat> getraenkeautomatList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setGetraenkList(new ArrayList<>());
        readGetraenkJSON();
        setMarkeList(new ArrayList<>());
        readMarkeJSON();
        setGetraenkeautomatList(new ArrayList<>());
        readGetraenkeautomatJSON();
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all Getraenke
     * @return list of Getraenke
     */
    public List<Getraenk> readAllGetraenke() {
        return getGetraenkList();
    }

    /**
     * reads a Getraenk by its uuid
     * @param getraenkUUID
     * @return the getraenk (null=not found)
     */
    public Getraenk readGetraenkByUUID(String getraenkUUID) {
        Getraenk getraenk = null;
        for (Getraenk entry : getGetraenkList()) {
            if (entry.getGetraenkUUID().equals(getraenkUUID)) {
                getraenk = entry;
            }
        }
        return getraenk;
    }

    /**
     * reads all marken
     * @return list of marken
     */
    public List<Marke> readAllMarken() {

        return getMarkeList();
    }

    /**
     * reads an marke by its uuid
     * @param markeUUID
     * @return the Marke (null=not found)
     */
    public Marke readMarkeByUUID(String markeUUID) {
        Marke marke = null;
        for (Marke entry : getMarkeList()) {
            if (entry.getMarkeUUID().equals(markeUUID)) {
                marke = entry;
            }
        }
        return marke;
    }

    /**
     * reads all getraenkeautomaten
     * @return list of getraenkeautomaten
     */
    public List<Getraenkeautomat> readAllGetraenkeautomaten() {

        return getGetraenkeautomatList();
    }

    /**
     * reads a getraenkeautomat by its uuid
     * @param getraenkeautomatUUID
     * @return the Getraenkeautomat (null=not found)
     */
    public Getraenkeautomat readGetraenkeautomatbyUUID(String getraenkeautomatUUID) {
        Getraenkeautomat getraenkeautomat = null;
        for (Getraenkeautomat entry : getGetraenkeautomatList()) {
            if (entry.getGetraenkeautomatUUID().equals(getraenkeautomatUUID)) {
                getraenkeautomat = entry;
            }
        }
        return getraenkeautomat;
    }

    /**
     * reads the getraenke from the JSON-file
     */
    private void readGetraenkJSON() {
        try {
            String path = Config.getProperty("getraenkJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            // objectMapper.registerModule(new JavaTimeModule());
            Getraenk[] getraenke = objectMapper.readValue(jsonData, Getraenk[].class);
            for (Getraenk getraenk : getraenke) {
                getGetraenkList().add(getraenk);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the marken from the JSON-file
     */
    private void readMarkeJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("markeJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Marke[] marken = objectMapper.readValue(jsonData, Marke[].class);
            for (Marke marke : marken) {
                getMarkeList().add(marke);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the getraenkeautomat from the JSON-file
     */
    private void readGetraenkeautomatJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("getraenkeautomatJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Getraenkeautomat[] getraenkeautomaten = objectMapper.readValue(jsonData, Getraenkeautomat[].class);
            for (Getraenkeautomat getraenkeautomat : getraenkeautomaten) {
                getGetraenkeautomatList().add(getraenkeautomat);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * gets getraenkList
     *
     * @return value of getraenkList
     */
    private List<Getraenk> getGetraenkList() {
        return getraenkList;
    }

    /**
     * sets getraenkList
     *
     * @param getraenkList the value to set
     */
    private void setGetraenkList(List<Getraenk> getraenkList) {
        this.getraenkList = getraenkList;
    }

    /**
     * gets markeList
     *
     * @return value of markeList
     */
    private List<Marke> getMarkeList() {
        return markeList;
    }

    /**
     * sets markeList
     *
     * @param markeList the value to set
     */
    private void setMarkeList(List<Marke> markeList) {
        this.markeList = markeList;
    }

    /**
     * gets getraenkeautomatList
     *
     * @return value of getraenkeautomatList
     */
    private List<Getraenkeautomat> getGetraenkeautomatList() {
        return getraenkeautomatList;
    }

    /**
     * sets getraenkeautomatList
     *
     * @param getraenkeautomatList the value to set
     */
    private void setGetraenkeautomatList(List<Getraenkeautomat> getraenkeautomatList) {
        this.getraenkeautomatList = getraenkeautomatList;
    }


}
