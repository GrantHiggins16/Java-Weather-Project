
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @version oct 9
 * @author Grant
 *
 * Project 2
 * 
 * Class representing a set of DataYears
 */
public class DataSet extends MultiStatisticsWithDaysAbstract
{

    private TreeMap<Integer, DataYear> years = 
            new TreeMap<Integer, DataYear>();
    private String stationId;
    
    /**
     * Constructor for DataSet 
     * 
     */
    public DataSet() 
    {
       //empty on purpose - only to initialize
       //instance vars
    }

    /**
     * returns the year associated with int year
     * @param year the number that indicates the 
     * year to return
     * @return the year associated with i
     */
    @Override
    protected DataYear getItem(Integer year) 
    {
        //year-1 due to difference between numbering
        //of indexes and years
        return years.get(year);
    }

    /**
     * returns string representation of the dataSet
     * @return the string representation of the data set
     */
    public String toString()
    {
        return "Data Set: " + stationId;
    }
    /**
     * returns an object representing the 
     * dataset that can be iterated 
     * through using integers
     * @return an iterator of dataset
     */
    public Iterator<Integer> iterator()
    {
        return years.navigableKeySet().iterator();
    }
    
    /**
     * * returns string that describes
     * entire content of object
     * @return entire contents of object
     */
    public String getStructure()
    {
        String toReturn = this.toString();
        toReturn += "\n";
        for (DataYear y : years.values())
        {
            toReturn += y.toString() + "\n";
        }
        return toReturn;    
    }
    
    /**
     * add a day to years
     * @param d day to be added
     */
    protected void addDay(DataDay d)
    {
        //finds year and adds day to it
        //if year doesnt exist, it is created
        //and day is added
        if (!(years.containsKey(d.getYear())))
        {
            years.put(d.getYear(), new DataYear());
            years.get(d.getYear()).addDay(d);
        }
        //else day is simply added
        else
        {
            years.get(d.getYear()).addDay(d);
        }
    }
}
