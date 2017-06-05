
/**
 * @version oct 23
 * @author Grant
 * project 3
 * 
 * represents info about a single variable
 *
 */
public class DataDefinition 
{
    private String variableName;
    private String variableId;
    private String unit;
    private boolean positive;
    private String description;
    
    /**
     * constructor for data definition object
     * @param variableName name of variable
     * @param iD id of variable
     * @param unit unit of measurement for variable
     * @param positive whether the variable should be
     * counted positively or negatively
     * @param description description of the variable
     */
    public DataDefinition(String variableName, String iD,
            String unit, boolean positive, String description)
    {
        this.variableName = variableName;
        this.variableId = iD;
        this.unit = unit;
        this.positive = positive;
        this.description = description;
    }

    /**
     * getter for var name
     * @return the variableName
     */
    public String getVariableName() 
    {
        return variableName;
    }

    /**
     * getter for var id
     * @return the variableId
     */
    public String getVariableId() 
    {
        return variableId;
    }

    /**
     * getter for unit
     * @return the unit
     */
    public String getUnit() 
    {
        return unit;
    }

    /**
     * getter for whether the value
     * should be counted positively or not
     * @return the positive
     */
    public boolean isPositive()
    {
        return positive;
    }

    /**
     * getter for description
     * @return the description
     */
    public String getDescription() 
    {
        return description;
    }
    
    /**
     * to string function for data definition
     * 
     * @return a string representation of the 
     * data definition object
     */
    public String toString()
    {
        return String.format("<%s>, <%s>, (<%s>)", 
                this.variableId, this.variableName,
                this.unit);
    }
    
    
}
