package es.jacascom.hmi.io;

import es.jacascom.hmi.data.MediaFile;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class MediaFinder implements IMediaFinder {

    private FileHelper helper;

    public MediaFinder() {
        helper = new FileHelper();
    }

    public List<MediaFile> findMedia(String path) {
        return findMedia(path, null);
    }


    public List<MediaFile> findMedia(String path, String[] extensions) {
        // Build the filter
        FileFilter filter = new MediaFileFilter(extensions);

        File mFolder = new File(path);

        // Pass the filter to the listFiles method
        File [] mFiles = mFolder.listFiles(filter);

        List<MediaFile> list = null;
        if (mFiles != null) {
            list = new ArrayList<MediaFile>(mFiles.length);
            for (int i=0; i< mFiles.length; i++){
                // If mFiles is a Directory, then it goes in and checks mFiles
                if (mFiles[i].isDirectory()) {
                    List<MediaFile> dirFiles = findMedia(mFiles[i].getAbsolutePath(), extensions);
                    if (dirFiles != null) {
                        list.addAll(dirFiles);
                    }
                } else {
                    // Creates a MediaFile with mFiles[i]
                    MediaFile f = helper.convertRealFileToMediaFile(mFiles[i], path);
                    if (f != null) {
                        list.add(f);
                    }
                }
            }
        }

        return list;
    }
}
