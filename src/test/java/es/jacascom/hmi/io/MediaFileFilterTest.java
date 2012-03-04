package es.jacascom.hmi.io;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by IntelliJ IDEA.
 * User: fcastro
 * Date: 3/4/12
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */

public class MediaFileFilterTest {

    FileFilter filter;

    @Before
    public void setup() {
        filter = new MediaFileFilter(new String[]{"jpg", "gif", "JPG"});

    }

    @Test
    public void testAcceptFile() {

        File f = new FakeFile("c:/dir/file.GIF", false);

        assertTrue(filter.accept(f));
    }

    @Test
    public void testNotAcceptFile() {

        File f = new FakeFile("c:/dir/file.XGIF", false);

        assertFalse(filter.accept(f));
    }

    @Test
    public void testAcceptDirectory() {

        File f = new FakeFile("c:/dir/", true);

        assertTrue(filter.accept(f));
    }
}


class FakeFile extends File {

    private boolean directory;
    private String name;

    public FakeFile(String name, boolean directory) {
        super(name);
        this.name = name;
        this.directory = directory;
    }


    public String getName() {
        return name;
    }

    public boolean isDirectory() {
        return directory;

    }
}