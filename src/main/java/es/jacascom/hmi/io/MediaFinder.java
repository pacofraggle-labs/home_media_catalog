package es.jacascom.hmi.io;

import es.jacascom.hmi.data.MediaFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaFinder implements IMediaFinder {


    public List<MediaFile> findMedia(String path) {

        File mFolder = new File(path);

        File [] mFiles = mFolder.listFiles();

        List<MediaFile> list = new ArrayList<MediaFile>();

        if (mFiles == null) {

        }   else {
            for (int i=0; i< mFiles.length; i++){
                // If mFiles is a Directory, then goes in and check mFiles
                if (mFiles[i].isDirectory()) {
                    List<MediaFile> dirFiles = findMedia(mFiles[i].getAbsolutePath());
                    list.addAll(dirFiles);
                } else {
                    // Creates a MediaFile with mFiles[i]
                    MediaFile f = new MediaFile("CRC",mFiles[i].getName(),mFiles[i].getPath(),"Title",mFiles[i].length());
                    list.add(f);
                }
            }
        }
        // TODO
        return list;
    }


    public List<MediaFile> findMedia(String path, String[] extensions) {
        // TODO
        return null;
    }
}
