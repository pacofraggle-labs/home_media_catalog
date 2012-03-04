package es.jacascom.hmi.data;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: fcastro
 * Date: 2/22/12
 * Time: 8:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class MediaFileTest {

    private MediaFile mediaFile;

    @Before
    public void setUp()  {
        mediaFile = new MediaFile("1111", "FileName", "Path", "Title", 1024);
    }

    @Test
    public void testEqualsSameCode()  {
        MediaFile other = new MediaFile("1111", "other", "other", "other", 0);

        assertEquals("Same Code but equals fails", mediaFile, other);
    }

    @Test
    public void testEqualsDifferentCode()  {
        MediaFile other = new MediaFile("2222", "FileName", "Path", "Title", 1024);

        assertFalse("Different Code but equals fails", mediaFile.equals(other));
    }

    @Test
    public void testEqualsWithNull()  {
        assertFalse("equals with null fails", mediaFile.equals(null));
    }

    @Test
    public void testEqualsWithNullInternalCode()  {
        mediaFile.setCode(null);
        MediaFile other = new MediaFile("1111", "FileName", "Path", "Title", 1024);
        assertFalse("equals with null Code fails", mediaFile.equals(null));
    }

    @Test
    public void testEqualsWithNullCode()  {
        MediaFile other = new MediaFile(null, "FileName", "Path", "Title", 1024);
        assertFalse("equals with null Code fails", mediaFile.equals(other));
    }

    @Test
    public void testEqualsWithBothCodeNull()  {
        MediaFile other = new MediaFile(null, "FileName", "Path", "Title", 0);
        mediaFile.setCode(null);

        assertFalse("equals with null Codes fails", mediaFile.equals(other));
    }
}
