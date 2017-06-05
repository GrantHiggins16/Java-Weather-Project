
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @version oct 24
 * @author Grant
 * Project 3
 * 
 * test for the dataDat class
 */
public class DataDayTest 
{

    /**
     * implicitly tests all parts of data
     * day and data def list
     * @throws IOException if issues reading in files
     */
    @Test
    public void dataDayConstructorTest() throws IOException 
    {
        StationDefinitionList sd = 
                new StationDefinitionList("data/geoinfo.csv");
        DataDefinitionList dd = 
                new DataDefinitionList("data/DataTranslation.csv");
        Assert.assertEquals(dd.toString().substring(0, 63), 
                "<9AVG>, <Average Air Temperature at 9m>, "
                + "(<degrees Fahrenheit>)");
        sd.loadData("data/alldata_2011.csv");
        BufferedReader br = 
                new BufferedReader(new FileReader("data/alldata_2011.csv"));
        DataDay dataD; 
        br.readLine();
        String[] strg = br.readLine().split(",");
        dataD = new DataDay(strg);
        Assert.assertEquals("2011-01-01, ACME", dataD.toString());
        br.close();
        System.out.println(dataD.getStatisticAverage("9AVG"));
    }
}
