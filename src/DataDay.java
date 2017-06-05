import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author CS2334.  Modified by: 
 * Grant Higgins and Dhruv Khanna
 * 
 * @version sept 18 2016
 * 
 * Project 1
 * This class represents a summary of one 
 * day's data from a single Mesonet station.
 *
 */

public class DataDay extends StatisticsAbstract
{
    /** Year in which the data were sampled */
    private int year;
    /** Month in which the data were sampled */
    private int month;
    /** The day on which the data were sampled (1=January, 2=February, etc */
    private int day;
    private String stationID;
    private HashMap<String, Sample> samples =
            new HashMap<String, Sample>();
    /** arrayList of the fields to be read  */
    public static ArrayList<String> dataFields = 
            new ArrayList<String>();
    /** definition of data type of different fields  */
    private static DataDefinitionList dataDefinitionList;
    /** index of year in data */
    private static int yearIndex;
    /** index of month in data */
    private static int monthIndex;
    /** index of day in data */
    private static int dayIndex;
    /** index of stationID in data */
    private static int stationIDIndex;

    /**
     * DataDay default constructor
     * creates day with uninitialized data
     */
    public DataDay()
    {
        //initialize hashmap with invalid samples
        Sample invalid = new Sample();
        for (String s : dataFields)
        {
            if (dataDefinitionList.isValidStat(s))
            {
                samples.put(s, invalid);
            }
        }
    }

    /**
     * DataDay non-default constructor
     * 
     * @param args the data fields of the day
     * to be constructed
     */
    public DataDay(String[] args)
    {
        //sets year, month, day, and stid
        //based on already found indexes
        year = Integer.parseInt(args[yearIndex]);
        month = Integer.parseInt(args[monthIndex]);
        day = Integer.parseInt(args[dayIndex]);
        stationID = args[stationIDIndex];
        //creates samples out of args and adds
        //them to the correct key in samples
        Sample sampleToAdd;
        for (int i = 0; i < args.length; i++)
        {
            //checks that the given stat exists
            if (dataDefinitionList.isValidStat(dataFields.get(i)))
            {
                //adds stat to hashmap
                sampleToAdd = new Sample(Double.parseDouble(args[i]));
                samples.put(dataFields.get(i), sampleToAdd);
            }
        }
    }

    /**
     * accessor for Year
     * @return the year
     */
    public int getYear() 
    {
        return year;
    }


    /**
     * accessor for month
     * @return the month
     */
    public int getMonth() 
    {
        return month;
    }


    /**
     * accessor for day
     * @return the day
     */
    public int getDay() 
    {
        return day;
    }


    /**
     * accessor for station ID
     * @return the stationID
     */
    public String getStationID() 
    {
        return stationID;
    }

    /**
     * returns the minimum dataDay which, since this is 
     * a dataDay object, ends up returning itself
     * @param statisticId Id of statistic to return
     * @return itself
     */
    @Override
    public DataDay getStatisticMinDay(String statisticId)
    {
        return this;
    }

    /**
     * returns the minimum dataDay which, since this is 
     * a dataDay object, ends up returning itself
     * @param statisticId Id of statistic to return
     * @return itself
     */
    @Override
    public DataDay getStatisticMaxDay(String statisticId)
    {
        return this;
    }

    /**
     * gets the average of all samples in the data day
     * @param statisticId not used, only there b/c of
     * inheritance rules
     * @return sample representing the average valid value
     * in the doc
     */
    @Override
    public Sample getStatisticAverage(String statisticId)
    {
        double totalStatisticValue = 0;
        int validSamples = 0;
        for (Sample s : samples.values())
        {
            //if the sample is valid then add its
            //value to the total
            if (s.isValid())
            {
                totalStatisticValue += s.getValue();
                validSamples++;
            }
        }
        //checks if there was a valid sample
        if (validSamples == 0)
        {
            return new Sample();
        }
        else
        {
            double averageValue = 
                    totalStatisticValue / validSamples;
            return new Sample(averageValue);
        }
    }

    /**
     * sets the datadefinitionslist used to define 
     * the dataDay object
     * @param dataDefinitions the dataDefinitionsList to
     * be used by DataDay
     */
    public static void setDataDefinitionList(DataDefinitionList dataDefinitions)
    {
        dataDefinitionList = dataDefinitions;
    }

    /**
     * sets the indexes of the dataDay
     * @param dataFieldList defines the fields of
     * data day
     */
    public static void setDataFields(String[] dataFieldList)
    {
        //stores every field name 
        for (int i = 0; i < dataFieldList.length; i++)
        {
            //checks if one of indexes then adds
            //to dataFields
            if (dataFieldList[i].equalsIgnoreCase("Year"))
            {
                yearIndex = i;
            }
            else if (dataFieldList[i].equalsIgnoreCase("month"))
            {
                monthIndex = i;
            }
            else if (dataFieldList[i].equalsIgnoreCase("day"))
            {
                dayIndex = i;
            }
            else if (dataFieldList[i].equalsIgnoreCase("stid"))
            {
                stationIDIndex = i;
            }
            dataFields.add(dataFieldList[i]);
        }
    }   

    /**
     * Describe the data for the day
     * 
     * @return String describing the day
     */
    public String toString()
    {
        return String.format("%d-%02d-%02d, %s", 
                year, month, day, stationID);
    }
}
