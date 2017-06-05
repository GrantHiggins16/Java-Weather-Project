import java.io.IOException;

/**
 * 
 * @author CS2334.  Modified by: 
 * Grant Higgins and Dhruv Khanna
 * 
 * @version sept 18 2016
 * 
 * Project 1
 * This class creates and prints a data month object
 *
 */
public class Driver 
{

    /**
     * reports the info related to a 
     * specific stat
     * @param station station to get info
     * from
     * @param dataDefinitionList list of vars 
     * to get info from
     * @param variableId specific variable to get
     * info about
     */
    public static void reportVariable(StationDefinition station, 
            DataDefinitionList dataDefinitionList,
            String variableId)
    {
        String sid = station.getStationID();
        System.out.print(station.toString());
        System.out.print(dataDefinitionList.getDataInfo(variableId));
        System.out.print(station.getStatisticMaxDay(sid));
    }

    /**
     * reports info about a specific station
     * @param list list of stations to get vars from
     * @param dataDefinitionList list of defs to worry
     * about
     * @param variableId the Id of the variable we are 
     * worrying about
     * @throws IOException if there is an error reading the
     * file
     */
    public static void reportStation(StationDefinitionList list, 
            DataDefinitionList dataDefinitionList, 
            String stationId) throws IOException
    {
        StationDefinition sd = list.getStationInfo(stationId);
        System.out.println(sd);
        System.out.println(dataDefinitionList.getDataInfo("DMAX"));
        System.out.println(sd.getStatisticAverage("DMAX").getValue());
    }

    /**
     * reads in files and prints them
     * according to class hierarchy
     * @param args command line arguments
     * @throws IOException if there is a 
     * problem reading in a file
     */
    public static void main(String[] args) throws IOException
    {
        StationDefinitionList sl = 
                new StationDefinitionList("data/geoinfo.csv");
        DataDefinitionList ddl = 
                new DataDefinitionList("data/DataTranslation.csv");
        sl.loadData("data/alldata_2011.csv");
        sl.loadData("data/alldata_2012.csv");
        sl.loadData("data/alldata_2013.csv");
        System.out.println(sl.getStationInfo("BBOW").getStructure());
        reportStation(sl, ddl, "BBOW");
        
    }    
}