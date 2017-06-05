import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/**
 * @version oct 24
 * @author Grant
 * Project 3
 * 
 * represents info about multiple stations
 */
public class StationDefinitionList 
{
    private HashMap<String, StationDefinition> stationMap =
            new HashMap<String, StationDefinition>();

    /**
     * Constructor for station def list
     * @param fileName name of file to read stations'
     * information from
     * @throws IOException if there is a problem reading data
     * from file
     */
    public StationDefinitionList(String fileName) throws IOException
    {
        //initializes vars to be used to create
        //stations
        String stationId;
        String name;
        String city;
        double nlat;
        double elon;
        StationDefinition stationDef;
        //initializes buffered reader
        BufferedReader br = 
                new BufferedReader(new FileReader(fileName));
        //firstLine is useless
        br.readLine();
        //string of csvs
        String strg = br.readLine();
        //string array to hold info from file
        String[] dataTranslation;
        //while there is still info to be read
        while (strg != null)
        {
            //splits csv string
            dataTranslation = strg.split(",");
            //collects values from csv file to make
            //stationDefinition object
            stationId = dataTranslation[0];
            name = dataTranslation[1];
            city = dataTranslation[2];
            nlat = 
                    Double.parseDouble(dataTranslation[3]);
            elon = Double.parseDouble(dataTranslation[4]);
            //creates stationDef object
            stationDef = new StationDefinition(stationId, 
                    name, city, nlat, elon);
            //adds stationDef to hashmap with key being station
            //Id
            stationMap.put(stationId, stationDef);
            //reads next line
            strg = br.readLine();
        }
        //solves null pointer errors
        //closes bufferedReader
        br.close();
    }

    /**
     * returns station definition of a station with 
     * a certain id
     * @param stationId id of station to get definition
     * from
     * @return the station definition of a certain station
     */
    public StationDefinition getStationInfo(String stationId)
    {
        return stationMap.get(stationId);
    }

    /**
     * returns a string representation of a Station
     * Definition List
     * @return stationDefs string rep of station definition list
     */
    public String toString()
    {
        //String to add stationdefs to and return
        String stationDefs = "";
        //adds string rep of every stationdef 
        for (StationDefinition def : stationMap.values())
        {
            stationDefs += def.toString() + "\n";
        }
        return stationDefs;
    }

    /**
     * adds a day to the heirarchy
     * @param day day to be added
     */
    private void addDay(DataDay day)
    {
        //adds a day to the specific station
        String stationId = day.getStationID();
        stationMap.get(stationId).addDay(day);
    }

    /**
     * loads in data from a file to make a ton 
     * of dataDays
     * @param fileName the name of file to be read
     * @throws IOException if the file cant be
     * read
     */
    public void loadData(String fileName) throws IOException
    {
        BufferedReader br = 
                new BufferedReader(new FileReader(fileName));
        //first line is used to make
        // list of fields in dataday- read through

        DataDay.setDataFields(br.readLine().split(","));
        //string of csvs
        String strg = br.readLine();
        //var to create dataDays
        String[] args;

        //while there is still info to be read
        while (strg != null)
        {
            //splits csv string
            args = strg.split(",");
            //adds dataDay
            addDay(new DataDay(args));
            //reads next line
            strg = br.readLine();
        }

        //closes bufferedReader
        br.close();
    }

    /**
     * returns all station ids in the station
     * definition list
     * @return stationIDs all station ids in the 
     * list
     */
    public ArrayList<String> getStationIds()
    {
        //array list of station ids
        ArrayList<String> stationIDs = 
                new ArrayList<String>();
        //iterates through hashmap
        for (String iD : stationMap.keySet())
        {
            stationIDs.add(iD);
        }
        Collections.sort(stationIDs);
        return stationIDs;
    }

    /**
     * find the average of a statistic
     * @param stationId station to search
     * @param variableId var to find avg of
     * @param keys years to be read
     * @return sample representing average
     * stat
     */
    public Sample getStatisticAverage(String stationId, 
            String variableId, KeyConstraints keys)
    {
        return stationMap.get(stationId).getStatisticAverage(variableId, keys);
    }
    
    /**
     * find the max of a statistic
     * @param stationId station to search
     * @param variableId var to find max of
     * @param keys contains the years to be 
     * computed
     * @return var representing max
     * day
     */
    public DataDay getStatisticMaxDay(String stationId, 
            String variableId, KeyConstraints keys)
    {
        return stationMap.get(stationId).getStatisticMaxDay(variableId, keys);

    }
    
    /**
     * find the min of a statistic
     * @param stationId station to search
     * @param variableId var to find min of
     * @param keys contains the years to be 
     * computed
     * @return var representing min
     * stat
     */
    public DataDay getStatisticMinDay(String stationId,
            String variableId, KeyConstraints keys)
    {
        return stationMap.get(stationId).getStatisticMinDay(variableId, keys);
    }

}
