package es.jacascom.hmi;

import es.jacascom.hmi.csv.CSVManager;
import es.jacascom.hmi.csv.ICSVManager;
import es.jacascom.hmi.io.*;
import es.jacascom.hmi.data.*;

import java.io.IOException;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        IMediaFinder finder = new MediaFinder();

        String[] ext = new String[1];

        ext[0] = "avi";

        List<MediaFile> files = finder.findMedia("H:/Bons/Pelicules","H:/Bons/Pelicules", ext);
//        for(int i=0; i<files.size(); i++) {
//            System.out.println(files.get(i));
//        }

        ICSVManager csv = new CSVManager()  ;

        try {
            csv.saveCSV(files, "H:/Bons/lista.csv");
            List<MediaFile> llista = csv.loadCSV("H:/Bons/lista.csv");
            for(int i=0; i<files.size(); i++) {
                System.out.println(llista.get(i));
            }


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }




    }








}

