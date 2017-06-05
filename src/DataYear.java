
import java.util.Iterator;
import java.util.TreeMap;

/**
 * @version oct 9
 * @author Grant and Dhruv
 *
 * Project 2
 * 
 * class representing a year of data
 */
public class DataYear extends MultiStatisticsAbstract
{
    private int year = -1;
    private String stationID;
    private TreeMap<Integer, DataMonth> months = 
            new TreeMap<Integer, DataMonth>();

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
        //sets instance vars if not already
        //initialized
        if (year == -1)
        {
            year = day.getYear();
            stationID = day.getStationID();
        }
        
        //finds month and adds day to it
        //if month doesnt exist, it is created
        //and day is added
        DataMonth dm = new DataMonth();
        if (!(months.containsKey(day.getMonth())))
        {
            dm.addDay(day);
            months.put(day.getMonth(), dm);
        }
        //else day is simply added
        else
        {
            dm = months.get(day.getMonth());
            dm.addDay(day);
            months.put(day.getMonth(), dm);
        }
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
        return months.get(month - 1);
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
}
