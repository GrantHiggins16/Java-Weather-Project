
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
/**
 * @version oct 24
 * @author Grant
 * Project 3
 * 
 * test for the data def class
 */
public class DataDefinitionTest {

    /**
     * tests the constructor for data definition
     * constructor and implicitly all of the
     * code
     * @throws IOException if file cant be read
     */
    @Test
    public void dataDefinitionConstructorTest() throws IOException 
    {
        DataDefinitionList dd = 
                new DataDefinitionList("data/DataTranslation.csv");
        Assert.assertEquals(dd.toString().substring(0, 63), 
                "<9AVG>, <Average Air Temperature at 9m>, "
                + "(<degrees Fahrenheit>)");
    }

}
