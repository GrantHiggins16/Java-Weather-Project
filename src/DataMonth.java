
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 
 * @author CS2334.  Modified by: 
 * Grant Higgins and Dhruv Khanna
 * 
 * @version sept 18 2016
 * 
 * Project 2
 * This class represents the data for all of the days within a single month
 *
 */


public class DataMonth extends MultiStatisticsWithDaysAbstract
{
    private int year = -1;
    private int month;
    private String stationID;
    /** The set of days. */
    private TreeMap<Integer, DataDay> days = 
            new TreeMap<Integer, DataDay>();

    /**
     * constructor for data month
     */
    public DataMonth()
    {
        //empty on purpose. simply creates 
        //instance variables
    }

    /**
     * Describe the month
     * 
     * @return A string describing all of 
     * the days and the statistics for the 
     * month
     */
    public String toString()
    {
        if (year == -1)
        {
            return "0000-00, null";
        }
        else
        {
            return String.format("%d-%2d, %s",
                    year, month, stationID);
        }
    }

    /**
     * add a data day to the month
     * 
     * @param day day to be added
     */
    protected void addDay(DataDay day)
    {
        days.put(day.getDay(), day);
        //extracts values of instance vars from
        //specific day if not initialized
        if (year == -1)
        {
            month = day.getMonth();
            year = day.getYear();
            stationID = day.getStationID();
        }
    }

    /**
     * gets day in set of data days
     * @param day indicates which data day 
     * to grab
     * @return DataDay associated with i
     */
    @Override
    protected DataDay getItem(Integer day) 
    {
        return days.get(day);
    }

    /**
     * returns an object representing the 
     * dataMonth that can be iterated 
     * through using integers
     * @return an iterator of datamonth
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return days.keySet().iterator();
    }

    /**
     * returns string that describes
     * entire content of object
     * @return entire contents of object
     */
    public String getStructure()
    {
        String toReturn = "Month: " + this.toString();
        toReturn += "\n";
        for (DataDay d : days.values())
        {
            toReturn += d.toString() + "\n";
        }
        return toReturn;     
    }

}
