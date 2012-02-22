package es.jacascom.hmi.data;

import org.apache.commons.lang.StringUtils;


/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 16/02/12
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */
public class MediaFile {

    private String crc;
    private String filename;
    private String path;
    private String title;
    private long filesize;

    public MediaFile(String crc, String filename, String path, String title, long filesize) {
        this.filesize = filesize;
        this.crc = crc;
        this.filename = filename;
        this.path = path;
        this.title = title;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFilesize() {
        return filesize;
    }

    public void setFilesize(long filesize) {
        this.filesize = filesize;
    }

    @Override
    public String toString() {
        return "MediaFile{" +
                "crc='" + crc + '\'' +
                ", filename='" + filename + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                ", filesize=" + filesize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof MediaFile)) {
            return false;
        }

        MediaFile m = (MediaFile) o;

        if (StringUtils.equals(this.getCrc(), m.getCrc())) {
            if (this.getCrc() == null) {
                if ( (StringUtils.equals(this.getFilename(), m.getFilename())) &&
                     (StringUtils.equals(this.getPath(), m.getPath())) &&
                     (StringUtils.equals(this.getTitle(), m.getTitle())) &&
                     (this.getFilesize() == m.getFilesize()) ) {

                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }

        return false;

    }



    @Override
    public int hashCode() {
        return crc != null ? crc.hashCode() : 0;
    }
}
