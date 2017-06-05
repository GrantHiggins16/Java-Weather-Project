
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
     * @param constraints the years that should
     * be printed
     * @return the day of min statistic value
     */
    @Override
    public DataDay getStatisticMinDay(String statisticId, 
            KeyConstraints constraints)
    {
        // Remember both the best day and the best sample so far
        //  (both are initialized to invalid)
        DataDay bestDay = new DataDay();
        Sample bestValue = new Sample();

        // Iterate over sub-objects
        //checks if constraints includes year or is
        //null. order prevents null pointer due to 
        //short-circuiting

        //create correct iterator based on 
        //the state of the constraints
        if (constraints == null)
        {
            for (Integer key : this)
            {
                // Get the sub-object corresponding to key
                StatisticsAbstract o = getItem(key);
                //checks if constraints includes year or is
                //null. order prevents null pointer due to 
                //short-circuiting

                // Ask the next object what its best value is
                DataDay newDay = o.getStatisticMinDay(statisticId, 
                        constraints);

                Sample newValue = newDay.getStatisticAverage(statisticId,
                        constraints);

                // Is this new one better?
                if (newValue.isLessThan(bestValue))
                {
                    // Yes - replace
                    bestDay = newDay;
                    bestValue = newValue;
                }
            }
        }
        else
        {
            for (Integer key : this)
            {
                if (constraints.contains(key))
                {
                    // Get the sub-object corresponding to key
                    StatisticsAbstract o = getItem(key);
                    //checks if constraints includes year or is
                    //null. order prevents null pointer due to 
                    //short-circuiting

                    // Ask the next object what its best value is
                    DataDay newDay = o.getStatisticMinDay(statisticId, 
                            constraints.getNext());

                    Sample newValue = newDay.getStatisticAverage(statisticId,
                            constraints.getNext());

                    // Is this new one better?
                    if (newValue.isLessThan(bestValue))
                    {
                        // Yes - replace
                        bestDay = newDay;
                        bestValue = newValue;
                    }
                }
            }
        }
        return bestDay;
    }




    /**
     * method that determines the day of max statistic
     * value
     * @param statisticId the statisticID for the
     * stat we are trying to find max of
     * @param constraints the years that should
     * be printed
     * @return the day of max statistic value
     */
    @Override
    public DataDay getStatisticMaxDay(String statisticId, 
            KeyConstraints constraints)
    {
        // Remember both the best day and the best sample so far
        // (both are initialized to invalid)
        DataDay bestDay = new DataDay();
        Sample bestValue = new Sample();
        //create correct iterator based on 
        //the state of the constraints
        if (constraints == null)
        {
            for (Integer key : this)
            {
                // Get the sub-object corresponding to key
                StatisticsAbstract o = getItem(key);
                //checks if constraints includes year or is
                //null. order prevents null pointer due to 
                //short-circuiting

                // Ask the next object what its best value is
                DataDay newDay = o.getStatisticMaxDay(statisticId, 
                        constraints);

                Sample newValue = newDay.getStatisticAverage(statisticId,
                        constraints);

                // Is this new one better?
                if (newValue.isGreaterThan(bestValue))
                {
                    // Yes - replace
                    bestDay = newDay;
                    bestValue = newValue;
                }
            }
        }
        else
        {
            for (Integer key : this)
            {
                if (constraints.contains(key))
                {
                    // Get the sub-object corresponding to key
                    StatisticsAbstract o = getItem(key);
                    //checks if constraints includes year or is
                    //null. order prevents null pointer due to 
                    //short-circuiting

                    // Ask the next object what its best value is
                    DataDay newDay = o.getStatisticMaxDay(statisticId, 
                            constraints.getNext());

                    Sample newValue = newDay.getStatisticAverage(statisticId,
                            constraints.getNext());

                    // Is this new one better?
                    if (newValue.isGreaterThan(bestValue))
                    {
                        // Yes - replace
                        bestDay = newDay;
                        bestValue = newValue;
                    }
                }
            }
        }

        return bestDay;
    }



    /**
     * method that determines the average statistic
     * value
     * @param statisticId the statisticID for the
     * stat we are trying to find min of
     * @param constraints the years that should
     * be printed
     * @return the average statistic value
     */
    @Override
    public Sample getStatisticAverage(String statisticId, 
            KeyConstraints constraints)
    {

        double accum = 0;
        int count = 0;
        if (constraints == null)
        {
            for (Integer i : this)
            {
                Sample newValue =
                        getItem(i).getStatisticAverage(
                                statisticId, constraints);
                //Ask the next object what its average value is

                // Is this new one valid?
                if (newValue.isValid())
                {
                    // Yes - include
                    accum += newValue.getValue();
                    ++count;
                }
            }
        }
        else
        {
            for (Integer i : this)
            {
                if (constraints.contains(i))
                {
                    Sample newValue = 
                            getItem(i).getStatisticAverage(
                                    statisticId, constraints.getNext());
                    if (newValue.isValid())
                    {
                        // Yes - include
                        accum += newValue.getValue();
                        ++count;
                    }
                }
            }
        }
        // Were there any sub-objects?
        if (count == 0)
        {
            // No - return an invalid sample
            return new Sample();
        }
        else
        {
            // Yes - return the average
            return new Sample(accum / count);
        }
    }

    /**
     * adds a day to the dataset
     * @param day day to be added
     */
}
