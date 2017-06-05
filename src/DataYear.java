
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @version oct 9
 * @author Grant and Dhruv
 *
 * Project 2
 * 
 * class representing a year of data
 */
public class DataYear extends MultiStatisticsWithDaysAbstract
{
    private int year;
    private String stationID;
    private TreeMap<Integer, DataMonth> months = 
            new TreeMap<Integer, DataMonth>();
    private static TreeSet<Integer> yearList =
            new TreeSet<Integer>();
    /**
     * consructor for data year
     */
    public DataYear()
    {
        //empty on purpose - only
        //to initialize instance vars
    }

    /**
     * adds a day to the array of months
     * @param day day to be added
     */
    protected void addDay(DataDay day)
    {
        //finds month and adds day to it
        //if month doesnt exist, it is created
        //and day is added
        if (!(months.containsKey(day.getMonth())))
        {
            months.put(day.getMonth(), new DataMonth());
            months.get(day.getMonth()).addDay(day);
        }
        //else day is simply added
        else
        {
            months.get(day.getMonth()).addDay(day);
        }
        yearList.add(day.getYear());
    }


    /**
     * returns DataMonth associated with month
     * @param month indicates which month to return
     * @return the month associated with var
     * month
     */
    @Override
    protected DataMonth getItem(Integer month) 
    {
        //must subtract 1 from month due to difference
        //in array indexing and month numbering
        return months.get(month);
    }


    /**
     * generates and returns a string representation of the DataYear
     * @return returns string rep of the year
     */
    public String toString()
    {
        return String.format("%2d, %s", year, stationID);
    }
    
    /**
     * returns an object representing the 
     * datayear that can be iterated 
     * through using integers
     * @return an iterator of datayear
     */
    public Iterator<Integer> iterator()
    {
        return months.navigableKeySet().iterator();
    }
    
    /**
     * returns string that describes
     * entire content of object
     * @return entire contents of object
     */
    public String getStructure()
    {
        String toReturn = "Year: " + this.toString();
        toReturn += "\n";
        for (DataMonth m : months.values())
        {
            toReturn += m.toString() + "\n";
        }
        return toReturn;    
    }
    
    /**
     * provides access to the years loaded into
     * the program
     * @return arraylist of years added in order
     * of least to greatest
     */
    public static ArrayList<Integer> getYearList()
    {
        return new ArrayList<Integer>(yearList);
    }
}
