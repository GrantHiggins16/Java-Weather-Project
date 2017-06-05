/**
 * 
 * @author CS2334.  Modified by: 
 * Grant Higgins and Dhruv Khanna
 * 
 * @version sept 18 2016
 * Project 1
 * 
 * This class represents individual, real-valued samples.  This class
 * explicitly addresses the fact that some samples are invalid.
 *
 */

public class Sample 
{
    /** The observed value. */
    private double value;

    /** Indicates whether the observation is a valid one */
    private boolean valid;

    /**
     * default constructor for
     * sample - creates sample that
     * is invalid
     */
    Sample()
    {
        valid = false;
    }

    /**
     * constructor for sample class
     * @param value to be 
     * put into sample
     */
    Sample(double value)
    {
        this.value = value;
        //checks if value is valid
        if (value > -900)
        {
            valid = true;
        }
        else
        {
            valid = false;
        }
    }

    /**
     * accessor for variable valid
     * @return value of sample
     */
    public double getValue()
    {
        //throws error if default constructor is used
        //b/c no value initialized
        return value;
    }

    /**
     * checks if sample is valid
     * @return true if sample is valid
     */
    public boolean isValid()
    {
        return valid;
    }

    /**
     * toString method for Sample
     * @return value if valid, 
     * "invalid" if not
     */
    public String toString()
    {
        //checks if valid then produces correct result
        if (this.valid)
        {
            //returns value with 4 decimal pts
            return String.format("%.4f", this.getValue());
        }
        else
        {
            return "invalid";
        }
    }

    /**
     * compares 2 samples and determines if
     * the one calling is less than one
     * in method header
     * @param s sample to compare to
     * @return true if calling sample
     * is less than s
     */
    public boolean isLessThan(Sample s)
    {
        //determines correct way to
        //compare s and the calling Sample
        //by checking first their validity
        //then their values
        if (this.isValid())
        {
            if (s.isValid())
            {
                //if both samples are valid return
                //the bool representing the less than
                //comparison
                return (this.getValue() < 
                        s.getValue());
            }
            //if calling sample is valid
            //and s is invalid return true
            else
            {
                return true;
            }
        }
        //if calling sample is invalid
        else
        {
            //if s is valid and this sample
            //is invalid return false
            return !(s.isValid());
        }

    }

    /**
     * compares 2 samples and determines if
     * the one calling is greater than the one
     * in method header
     * @param s sample to compare to
     * @return true if calling sample
     * is less than s
     */
    public boolean isGreaterThan(Sample s)
    {
        //determines correct way to
        //compare s and the calling Sample
        //by checking first their validity
        //then their values
        if (this.isValid())
        {
            if (s.isValid())
            {
                //if both samples are valid return
                //the bool representing the greater than
                //comparison
                return (this.getValue() > 
                        s.getValue());
            }
            //if calling sample is valid
            //and s is invalid return true
            else
            {
                return true;
            }
        }
        //if calling sample is invalid
        else
        {
            //if this is invalid and
            //s is valid return false
            return !(s.isValid());
        }
    }


}
