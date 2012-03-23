package es.jacascom.hmi.io;

import es.jacascom.hmi.data.MediaFile;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: elkstro
 * Date: 23/03/12
 * Time: 10:39
 * To change this template use File | Settings | File Templates.
 */
public class FileHelperTest {

    private FileHelper helper;

    @Before
    public void setUp() throws Exception {
        helper = new FileHelper();
    }

    @Test
    public void testConvertRealFileToMediaFile() {
        MediaFile media =
                helper.convertRealFileToMediaFile("H:/Bons/Pelicules/Folder/Airbag.avi", "H:/Bons/Pelicules");

        assertEquals("Folder/Airbag.avi", media.getPath());
    }
}
