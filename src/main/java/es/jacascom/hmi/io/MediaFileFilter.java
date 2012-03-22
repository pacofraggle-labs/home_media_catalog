package es.jacascom.hmi.io;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: fcastro
 * Date: 3/4/12
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MediaFileFilter implements FileFilter {

    private String[] extensions;

    /**
     * Constructor
     *
     * @param filter Store the extensions that will be filtered
     */
    public MediaFileFilter(String[] filter) {
        if (filter != null) {
            Set<String> unique = new HashSet<String>();
            for(String ext: filter) {
                unique.add("." + ext.toLowerCase());
            }
            this.extensions = (String[]) unique.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
        }
    }

    public boolean accept(File pathname) {
        if ((extensions == null) || (pathname.isDirectory())) {
            return true;
        }

        for(String ext: this.extensions) {
            if (StringUtils.endsWithIgnoreCase(pathname.getName(), ext)) {
                return true;
            }
        }

        return false;
    }
}