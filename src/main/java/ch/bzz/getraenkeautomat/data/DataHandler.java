package ch.bzz.getraenkeautomat.data;

import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Marke;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;
import ch.bzz.getraenkeautomat.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance;
    private static List<Getraenk> getraenkList;
    private static List<Marke> markeList;
    private static List<Getraenkeautomat> getraenkeautomatList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }

    /**
     * gets the only instance of this class
     * @return
     */
    public synchronized static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all Getraenke
     * @return list of Getraenke
     */
    public static List<Getraenk> readAllGetraenke() {
        return getGetraenkList();
    }

    /**
     * reads a Getraenk by its uuid
     * @param getraenkUUID
     * @return the getraenk (null=not found)
     */
    public static Getraenk readGetraenkByUUID(String getraenkUUID) {
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
    public static List<Marke> readAllMarken() {

        return getMarkeList();
    }

    /**
     * reads an marke by its uuid
     * @param markeUUID
     * @return the Marke (null=not found)
     */
    public static Marke readMarkeByUUID(String markeUUID) {
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
    public static List<Getraenkeautomat> readAllGetraenkeautomaten() {

        return getGetraenkeautomatList();
    }

    /**
     * reads a getraenkeautomat by its uuid
     * @param getraenkeautomatUUID
     * @return the Getraenkeautomat (null=not found)
     */
    public static Getraenkeautomat readGetraenkeautomatbyUUID(String getraenkeautomatUUID) {
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
    private static void readGetraenkJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("getraenkJSON")
                    )
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
    private static void readMarkeJSON() {
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
    private static void readGetraenkeautomatJSON() {
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
    private static List<Getraenk> getGetraenkList() {
        return getraenkList;
    }

    /**
     * sets getraenkList
     *
     * @param getraenkList the value to set
     */
    private static void setGetraenkList(List<Getraenk> getraenkList) { DataHandler.getraenkList = getraenkList;
    }

    /**
     * gets markeList
     *
     * @return value of markeList
     */
    private static List<Marke> getMarkeList() {
        return markeList;
    }

    /**
     * sets markeList
     *
     * @param markeList the value to set
     */
    private static void setMarkeList(List<Marke> markeList) {
        DataHandler.markeList = markeList;
    }

    /**
     * gets getraenkeautomatList
     *
     * @return value of getraenkeautomatList
     */
    private static List<Getraenkeautomat> getGetraenkeautomatList() {
        return getraenkeautomatList;
    }

    /**
     * sets getraenkeautomatList
     *
     * @param getraenkeautomatList the value to set
     */
    private static void setGetraenkeautomatList(List<Getraenkeautomat> getraenkeautomatList) {
        DataHandler.getraenkeautomatList = getraenkeautomatList;
    }


}
