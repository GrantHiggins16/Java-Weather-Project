
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @version oct 26
 * @author Grant
 *
 * Project 3
 * 
 * a test for the stationDefinitionList 
 * class
 */
public class StationDefinitionListTest {

    /**
     * test for constructor of stationdef
     * and implicitly all of stationdef
     * @throws IOException if there is an issue
     * reading the file
     */
    @Test
    public void stationDefinitionConstructortest() throws IOException
    {
        StationDefinitionList sd = 
                new StationDefinitionList("data/geoinfo.csv");
        Assert.assertEquals(sd.toString().substring(0, 50), 
                "<HOOK> <Hooker> <Hooker> "
                + "<36.855180> <-101.225470>");
    }

}
