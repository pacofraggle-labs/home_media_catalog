package es.jacascom.hmi.io;

import java.util.List;
import es.jacascom.hmi.data.MediaFile;

public interface IMediaFinder {

    /**
     * Find MediaFiles in a given folder
     * 
     * @param path Root folder
     */
    List<MediaFile> findMedia(String path);

    /**
     * Find MediaFiles in a given folder
     * 
     * @param path Root folder
     * @param extensions Extensions to be filtered
     */
    List<MediaFile> findMedia(String path, String[] extensions);
}
