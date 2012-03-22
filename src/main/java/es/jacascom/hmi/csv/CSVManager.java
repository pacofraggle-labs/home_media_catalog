package es.jacascom.hmi.csv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import es.jacascom.hmi.data.MediaFile;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 22/03/12
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class CSVManager implements ICSVManager {
    public List<MediaFile> loadCSV(String path) throws IOException {

        FileReader reader = new FileReader(path);
        CSVReader csv = new CSVReader(reader);

        List<String[]> cells = csv.readAll();

        List<MediaFile> medias = new ArrayList<MediaFile>();
        for (int i=0; i < cells.size(); i++){
            MediaFile k = new MediaFile(cells.get(i));
            medias.add(k);
        }



        return medias;
    }

    public boolean saveCSV(List<MediaFile> mediaList, String filename) throws IOException {

        FileWriter writer = new FileWriter(filename);
        CSVWriter csv = new CSVWriter(writer);

        for (int i=0; i< mediaList.size(); i++){

            csv.writeNext(mediaList.get(i).toStringArray());


        }


        csv.close();


        return true;

    }
}
