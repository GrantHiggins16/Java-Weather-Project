import java.awt.Graphics2D;

/**
 * @version oct 24
 * @author Grant
 * Project 3
 * 
 * represents info about a station
 */
public class StationDefinition extends StatisticsAbstract
{
    private String stationID;
    private String name;
    private String city;
    private double nlat;
    private double elon;
    private DataSet dataSet;

    /**
     * constructor for a station definition
     * @param stationId identifying factor of station
     * @param name name of station
     * @param city city station is in
     * @param nlat value of station
     * @param elon value of station
     */
    public StationDefinition(String stationId, String name,
            String city, double nlat, double elon)
    {
        dataSet = new DataSet();
        this.stationID = stationId;
        this.name = name;
        this.city = city;
        this.nlat = nlat;
        this.elon = elon;
    }

    /**
     * adds a day to the dataSet of the station
     * @param day day to be added
     */
    protected void addDay(DataDay day)
    {
        dataSet.addDay(day);
    }

    /**
     * getter for station id
     * @return the stationID
     */
    public String getStationID() 
    {
        return stationID;
    }

    /**
     * getter for name
     * @return the name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * getter for city
     * @return the city
     */
    public String getCity() 
    {
        return city;
    }

    /**
     * getter for nlat
     * @return the nlat
     */
    public double getNlat() 
    {
        return nlat;
    }

    /**
     * getter for elon
     * @return the elon
     */
    public double getElon()
    {
        return elon;
    }

    /**
     * gets the average statistic of a dataSet
     * @param statisticId statistic to average
     * @param keys contains the years to be 
     * computed
     * @return average of statisticId's group
     */
    public Sample getStatisticAverage(String statisticId,
            KeyConstraints keys)
    {
        return dataSet.getStatisticAverage(statisticId, keys);
    }

    /**
     * gets the max statistic of a dataSet
     * @param statisticId statistic to max
     * @param keys contains the years to be 
     * computed
     * @return max of statisticId's group
     */
    public DataDay getStatisticMaxDay(String statisticId, 
            KeyConstraints keys)
    {
        return dataSet.getStatisticMaxDay(statisticId, keys);
    }

    /**
     * gets the min statistic of a dataSet
     * @param statisticId statistic to minimize
     * @param keys contains the years to be 
     * computed
     * @return min of statisticId's group
     */
    public DataDay getStatisticMinDay(String statisticId,
            KeyConstraints keys)
    {
        return dataSet.getStatisticMinDay(statisticId, keys);
    }

    /**
     * returns a string rep of all data 
     * defining a station
     * @return string rep of the station def
     */
    public String toString()
    {
        return String.format("<%s> <%s> <%s> <%f> <%f>",
                stationID, name, city, nlat, elon);
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
        toReturn += dataSet.getStructure();
        return toReturn;
    }
    
    /**
     * draws a station
     * @param g2 context of where to draw
     */
    public void draw(Graphics2D g2)
    {
        // TODO: check if scale or offset should be done
        g2.drawOval((int) 
                (nlat * StateFrame.LATITUDE_SCALE),
                (int) 
                (elon * StateFrame.LONGITUDE_SCALE),
                StateFrame.STATION_RADIUS, 
                StateFrame.STATION_RADIUS);
    }
}
