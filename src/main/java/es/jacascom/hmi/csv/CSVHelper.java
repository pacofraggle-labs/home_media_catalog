package es.jacascom.hmi.csv;

import es.jacascom.hmi.data.MediaFile;

public final class CSVHelper {

    private CSVHelper() {
    }

    public static MediaFile convertToMediaFile(String[] row) {
        return new MediaFile(row);
    }

    public static String[] convertFromMediaFile(MediaFile media) {
        return media.toStringArray();
    }

    public static String[] extractRowHeaders(Class beanClass) {
        return null;
    }
}
