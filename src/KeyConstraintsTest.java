
import org.junit.Assert;
import org.junit.Test;


/**
 * @version nov 15
 * @author Grant
 * project 4
 * 
 * test of the key constraints class
 */
public class KeyConstraintsTest {

    /**
     * tests the constructor and get
     * next and add end
     *  methods of keyconstraints
     */
    @Test
    public void constructorAndNextTest() 
    {
        KeyConstraints test = new KeyConstraints();
        Assert.assertTrue(test.getNext() == null);
        KeyConstraints test2 = new KeyConstraints();
        test2.add(1);
        test.addEnd(test2);
        Assert.assertTrue(test.getNext().get(0) == 1);
    }


}
