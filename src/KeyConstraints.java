import java.util.ArrayList;

/**
 * @version nov 14
 * @author Grant
 *
 * project 4
 * 
 * Implements linked list of constraints to
 * dataYear
 */
public class KeyConstraints extends ArrayList<Integer>
{
    private KeyConstraints next;
    
    /**
     * constructor for key constraints obj
     */
    public KeyConstraints()
    {
        //gives keyConstraints the attributes
        //of arraylist
        super();
        //sets the next element to null
        next = null;
    }
    
    /**
     * gets the next keyconstraint in the linked
     * list
     * @return next key constraint in list
     */
    public KeyConstraints getNext()
    {
        return next;
    }
    
    /**
     * adds a keyconstraint to the end of 
     * the linked list
     * @param elem keyconstraint to be added 
     * to list
     */
    public void addEnd(KeyConstraints elem)
    {
        //recursive function, calls
        //next element until there is
        //none then sets it to elem
        if (this.getNext() == null)
        {
            next = elem;
        }
        else
        {
            this.getNext().addEnd(elem);
        }
    }
}
