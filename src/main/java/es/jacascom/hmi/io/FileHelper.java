package es.jacascom.hmi.io;

import es.jacascom.hmi.data.MediaFile;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public class FileHelper {

    private Checksum algorithm;
    private long maxSize;

    public static final long MEGABYTE = 1048576;
    private static final int CHUNK_SIZE = 2048;

    public FileHelper() {
        setAlgorithm(new Adler32());
        setMaxSize(4*MEGABYTE);
    }
    public FileHelper(Checksum algorithm, long maxSize) {
        setAlgorithm(algorithm);
        setMaxSize(maxSize);
    }

    public MediaFile convertRealFileToMediaFile(String filename, String basedir) {
        return convertRealFileToMediaFile(new File(filename), basedir);
    }

    public MediaFile convertRealFileToMediaFile(File file, String basedir) {
        String crc = calculateCRC(file);
        String path = FileHelper.pathToRelative(basedir, file.getPath());

        path = StringUtils.removeStart(path, "/");

        String title = new String(file.getName());
        title = StringUtils.replaceChars(title, "_", " ");
        title = StringUtils.substringBeforeLast(title, ".");

        return new MediaFile(crc, file.getName(), path, title, file.length());
    }

    public String calculateCRC(File f) {
        String result;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            algorithm.reset();
            int pos = 0;
            long max = getMaxSize();
            int len;
            byte[] bytes = new byte[FileHelper.CHUNK_SIZE];
            do {
                len = fis.read(bytes, 0, FileHelper.CHUNK_SIZE);
                if (len > 0) {
                    algorithm.update(bytes, 0, len);
                }
                pos += FileHelper.CHUNK_SIZE;
            } while ((pos < max) && (len == FileHelper.CHUNK_SIZE));

            result = Long.toString(algorithm.getValue());
        } catch (IOException e) {
            result = null;
        } finally {
            try {
                fis.close();
            } catch(Exception e) { }
        }

        return result;
    }

    private static String pathToRelative(String base, String path) {
        path = StringUtils.replaceChars(path, "\\", "/");
        base = StringUtils.replaceChars(base, "\\", "/");
        return StringUtils.removeStartIgnoreCase(path, base);
    }



    public Checksum getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Checksum algorithm) {
        this.algorithm = algorithm;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }
}
