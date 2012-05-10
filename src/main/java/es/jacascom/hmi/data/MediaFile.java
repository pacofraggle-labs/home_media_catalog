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

    private String code;
    private String filename;
    private String path;
    private String title;
    private long filesize;

    public MediaFile() {

    }

    public MediaFile(String code, String filename, String path, String title, long filesize) {
        this.filesize = filesize;
        this.code = code;
        this.filename = filename;
        this.path = path;
        this.title = title;
    }

    public MediaFile(String[] row) {
        setCode(row[0]);
        setFilename(row[1]);
        setPath(row[2]);
        setTitle(row[3]);
        setFilesize(Long.parseLong(row[4]));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String[] toStringArray() {
        return new String[]{code, filename, path, title, Long.toString(filesize)};
    }
    @Override
    public String toString() {
        return "MediaFile{" +
                "code='" + code + '\'' +
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

        if (StringUtils.equals(this.getCode(), m.getCode())) {
            if (this.getCode() == null) {
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


    public static String[] obtainFieldNames() {
        return new String[] {"Code", "FileName", "Path", "Title", "FileSize"};
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
