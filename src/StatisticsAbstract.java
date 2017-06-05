/**
 * @version oct 9
 * @author Grant
 * 
 * Project 2
 *
 * abstract class representing set of methods
 * that allow for calculations of wind speed
 * and solar radiation
 */
public abstract class StatisticsAbstract 
{
    /**
     * method that determines the day of minimum
     * value of a statistic
     * @param statisticId the id of stat to search
     * @return the day of min statistic value
     */
    public abstract DataDay getStatisticMinDay(String statisticId);
    
    /**
     * method that determines the average value
     * of a statistic     
     * @param statisticId the id of stat to search
     * @return the average statistic value
     */
    public abstract Sample getStatisticAverage(String statisticId);
    
    /**
     * method that determines the max value 
     * of a statistic
     * @param statisticId the id of stat to search
     * @return the day of max statistic value
     */
    public abstract DataDay getStatisticMaxDay(String statisticId);


    
}
    
    