/**
 * @version oct 9
 * @author Grant
 *
 * Project 2
 * Class representing a series of 
 * calculations done on data days
 */
public abstract class MultiStatisticsAbstract 
    extends StatisticsAbstract implements Iterable<Integer>
{
    /**
     * returns sub-objects 
     * @param key indicates which item to get 
     * @return the sub-object key represents
     */
    protected abstract StatisticsAbstract getItem(Integer key);

    /**
     * method that determines the day of minimum
     * value of a statistic
     * @param statisticId the statisticID for the
     * stat we are trying to find min of
     * @return the day of min statistic value
     */
    @Override
    public DataDay getStatisticMinDay(String statisticId)
    {
        //variables to compare stat values
        //of days
        DataDay minCurrentStatistic = new DataDay();
        Sample minCurrentStatSample = new Sample();
        DataDay currentStatistic;
        Sample currentStatSample;
        //loops through every item in the set
        for (Integer index : this)
        {
            
            //reduces getItem to a data day
            currentStatistic = 
                    getItem(index + 1).getStatisticMinDay(statisticId); 
            //reduces that  day to a sample
            currentStatSample =
                    currentStatistic.getStatisticAverage(statisticId);
            //compares the current minimum Statistic with
            //current and replaces if current is less than
            if (currentStatSample.isLessThan(minCurrentStatSample))
            {
                minCurrentStatistic = currentStatistic;
                minCurrentStatSample = currentStatSample;
            }
        }
        //due to the function of isLessThan in
        //Sample - this returns a blank data day
        //only if all stats are invalid
        return minCurrentStatistic;
    }

    /**
     * method that determines the day of max statistic
     * value
     * @param statisticId the statisticID for the
     * stat we are trying to find max of
     * @return the day of max statistic value
     */
    @Override
    public DataDay getStatisticMaxDay(String statisticId)
    {
        //variables to compare stat values
        //of days
        DataDay maxCurrentStatistic = new DataDay();
        Sample maxCurrentStatSample = new Sample();
        DataDay currentStatistic;
        Sample currentStatSample;
        //loops through every item in the set
        for (Integer index : this)
        {
            
            //reduces getItem to a data day
            //index + 1 b/c of the difference btwn
            //indexes and months and years and such
            currentStatistic = 
                    getItem(index + 1).getStatisticMaxDay(statisticId); 
            //reduces that  day to a sample
            currentStatSample =
                    currentStatistic.getStatisticAverage(statisticId);
            //compares the current maximum Statistic with
            //current and replaces if current is greater than
            if (currentStatSample.isLessThan(maxCurrentStatSample))
            {
                maxCurrentStatistic = currentStatistic;
                maxCurrentStatSample = currentStatSample;
            }
        }
        //due to the function of isGreaterThan in
        //Sample - this returns a blank data day
        //only if all stats are invalid
        return maxCurrentStatistic;
    }

    /**
     * method that determines the average statistic
     * value
     * @param statisticId the statisticID for the
     * stat we are trying to find min of
     * @return the average statistic value
     */
    @Override
    public Sample getStatisticAverage(String statisticId)
    {
        //variables to keep track of statistics
        Sample statCurrentDay;
        Double totalStatisticValue = 0.0;
        int validStats = 0;
        //loops through every item in the set
        for (Integer index : this)
        {
            //reduces getItem to a wind speed sample
            statCurrentDay = 
                    getItem(index).getStatisticAverage(statisticId);
            //checks that current sample is valid
            if (statCurrentDay.isValid())
            {
                totalStatisticValue += statCurrentDay.getValue();
                validStats++;
            }
        }
        //checks if the average is invalid
        if (totalStatisticValue >= 0.01 && 
                totalStatisticValue <= 0.01)
        {
            //if invalid return invalid sample()
            return new Sample();
        }
        
        else
        {

            double avgValue = totalStatisticValue / validStats;
            return new Sample(avgValue);
        }
    }

    /**
     * adds a day to the dataset
     * @param day day to be added
     */
    protected abstract void addDay(DataDay day);
}
