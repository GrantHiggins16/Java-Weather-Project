import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author CS2334.  Modified by: 
 * Grant Higgins and Dhruv Khanna
 * 
 * @version sept 18 2016
 * Project 1
 * 
 * This class represents a comprehensive test for 
 * the Sample class
 */
public class SampleTest 
{
    /**
     * tests the Constructors for Sample
     */
    @Test
    public void sampleConstTest() 
    {
        //creates default Sample object
        Sample testSamp = new Sample();
        Assert.assertTrue(!(testSamp.isValid()));
        //creates Sample object with valid value
        Sample testSamp1 = new Sample(10.0);
        Assert.assertEquals(10.0, testSamp1.getValue(), 0.01);
        Assert.assertTrue(testSamp1.isValid());
        //creates Sample object with invalid value
        Sample testSamp2 = new Sample(-1000.0);
        Assert.assertTrue(!(testSamp2.isValid()));
    }

    /**
     * tests the toString method of Sample
     */
    @Test
    public void sampleToStringTest() 
    {
        //creates invalid sample object and prints
        Sample testSamp3 = new Sample(-1000.0);
        Assert.assertEquals("invalid", testSamp3.toString());
        //creates valid Sample object and prints
        Sample testSamp4 = new Sample(10.0);
        Assert.assertEquals(10.0, 
                Double.parseDouble(testSamp4.toString()), 0.01);
    }

    /**
     * tests sample's less than method
     */
    @Test
    public void sampleIsLessThanTest()
    {
        //samples to test valid and invalid
        Sample validSample = new Sample(5);
        Sample invalidSample = new Sample();
        //tests the two combinations of one invalid
        //input
        Assert.assertTrue(validSample.isLessThan(invalidSample));
        Assert.assertFalse(invalidSample.isLessThan(validSample));
        //tests the method with 2 invalids
        Assert.assertTrue(invalidSample.isLessThan(invalidSample));
        //sample to test 2 valid combinations
        Sample validSampleLess = new Sample(4);
        Assert.assertFalse(validSample.isLessThan(validSampleLess));
        Assert.assertTrue(validSampleLess.isLessThan(validSample));
    }

    /**
     * tests Sample's greater than method
     */
    public void sampleIsGreaterThanTest()
    {
        //samples to test valid and invalid
        Sample validSample = new Sample(5);
        Sample invalidSample = new Sample();
        //tests the two combinations of one invalid
        //input
        Assert.assertTrue(validSample.isLessThan(invalidSample));
        Assert.assertFalse(invalidSample.isLessThan(validSample));
        //tests the method with 2 invalids
        Assert.assertTrue(invalidSample.isLessThan(invalidSample));
        //sample to test 2 valid combinations
        Sample validSampleLess = new Sample(4);
        Assert.assertTrue(validSample.isGreaterThan(validSampleLess));
        Assert.assertFalse(validSampleLess.isGreaterThan(validSample));
    }
}
