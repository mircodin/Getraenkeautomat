package ch.bzz.getraenkeautomat.data;

import ch.bzz.getraenkeautomat.model.Getraenk;
import ch.bzz.getraenkeautomat.model.Marke;
import ch.bzz.getraenkeautomat.model.Getraenkeautomat;
import ch.bzz.getraenkeautomat.service.Config;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static List<Getraenk> getraenkList;
    private static List<Marke> markeList;
    private static List<Getraenkeautomat> getraenkeautomatList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
    }

    /**
     * initialize the lists with the data
     */
    public static void initLists() {
        DataHandler.setGetraenkList(null);
        DataHandler.setMarkeList(null);
        DataHandler.setGetraenkeautomatList(null);
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
     * inserts a new book into the bookList
     *
     * @param getraenkeautomat the book to be saved
     */
    public static void insertGetraenkeautomat(Getraenkeautomat getraenkeautomat) {
        getGetraenkeautomatList().add(getraenkeautomat);
        writeGetraenkeautomatJSON();
    }
    /**
     * updates the bookList
     */
    public static void updateGetraenkeautomat() {
        writeGetraenkeautomatJSON();
    }
    /**
     * deletes a book identified by the bookUUID
     * @param getraenkeautomatUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteGetraenkeautomat(String getraenkeautomatUUID) {
        Getraenkeautomat getraenkeautomat = readGetraenkeautomatbyUUID(getraenkeautomatUUID);
        if (getraenkeautomat != null) {
            getGetraenkeautomatList().remove(getraenkeautomat);
            writeGetraenkeautomatJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * inserts a new book into the bookList
     *
     * @param getraenk the book to be saved
     */
    public static void insertGetraenk(Getraenk getraenk) {
        getGetraenkList().add(getraenk);
        writeGetraenkJSON();
    }
    /**
     * updates the bookList
     */
    public static void updateGetraenk() {
        writeGetraenkJSON();
    }
    /**
     * deletes a book identified by the bookUUID
     * @param getraenkUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteGetraenk(String getraenkUUID) {
        Getraenk getraenk = readGetraenkByUUID(getraenkUUID);
        if (getraenk != null) {
            getGetraenkList().remove(getraenk);
            writeGetraenkJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * inserts a new book into the bookList
     *
     * @param marke the book to be saved
     */
    public static void insertMarke(Marke marke) {
        getMarkeList().add(marke);
        writeMarkeJSON();
    }
    /**
     * updates the bookList
     */
    public static void updateMarke() {
        writeMarkeJSON();
    }
    /**
     * deletes a book identified by the bookUUID
     * @param markeUUID  the key
     * @return  success=true/false
     */
    public static boolean deleteMarke(String markeUUID) {
        Marke marke = readMarkeByUUID(markeUUID);
        if (marke != null) {
            getMarkeList().remove(marke);
            writeMarkeJSON();
            return true;
        } else {
            return false;
        }
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
            Getraenk[] getraenke = objectMapper.readValue(jsonData, Getraenk[].class);
            for (Getraenk getraenk : getraenke) {
                getGetraenkList().add(getraenk);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * writes the bookList to the JSON-file
     */
    private static void writeGetraenkJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String getraenkPath = Config.getProperty("getraenkJSON");
        try {
            fileOutputStream = new FileOutputStream(getraenkPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getGetraenkList());
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
     * writes the bookList to the JSON-file
     */
    private static void writeMarkeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String markePath = Config.getProperty("markeJSON");
        try {
            fileOutputStream = new FileOutputStream(markePath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getMarkeList());
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
     * writes the bookList to the JSON-file
     */
    private static void writeGetraenkeautomatJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String getraenkeautomatPath = Config.getProperty("getraenkeautomatJSON");
        try {
            fileOutputStream = new FileOutputStream(getraenkeautomatPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getGetraenkeautomatList());
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
        if (getraenkList == null) {
            setGetraenkList(new ArrayList<>());
            readGetraenkJSON();
        }
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
        if (markeList == null) {
            setMarkeList(new ArrayList<>());
            readMarkeJSON();
        }
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
        if (getraenkeautomatList == null) {
            setGetraenkeautomatList(new ArrayList<>());
            readGetraenkeautomatJSON();
        }
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
