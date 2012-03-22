package es.jacascom.hmi.csv;

import java.util.List;
import java.io.IOException;
import es.jacascom.hmi.data.MediaFile;

public interface ICSVManager {

    /**
     * Find MediaFiles in a given folder
     * 
     * @param path Root folder
     */
    List<MediaFile> loadCSV(String path) throws IOException;

    /**
     * Find MediaFiles in a given folder
     * 
     * @param path Root folder
     * @param extensions Extensions to be filtered
     */
    boolean saveCSV(List<MediaFile> media, String filename) throws IOException;
}
