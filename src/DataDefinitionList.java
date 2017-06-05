import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Grant
 * @version oct 24
 * project 3
 * class representing a ton of dataDefinitions
 */
public class DataDefinitionList 
{
    private HashMap<String, DataDefinition> datainfoMap =
            new HashMap<String, DataDefinition>();

    /**
     * constructor for data definition list
     * @param fileName name of file to be read for
     * data definitions
     * @throws IOException if unable to read file correctly
     */
    public DataDefinitionList(String fileName) throws IOException
    {
        //initializes vars to be used to create
        //data definitions
        String varName;
        String iD;
        String unit;
        boolean positive;
        String description;
        DataDefinition dataDef;
        //initializes buffered reader
        BufferedReader br = 
                new BufferedReader(new FileReader(fileName));
        //first line is useless - read through
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
            //data def object
            varName = dataTranslation[0];
            iD = dataTranslation[1];
            unit = dataTranslation[2];
            positive = 
                    Boolean.getBoolean(dataTranslation[3]);
            description = dataTranslation[4];
            //creates dataDefinition object
            dataDef = new DataDefinition(varName, iD, 
                    unit, positive, description);
            //adds dataDef to hashmap with key being variable
            //Id
            datainfoMap.put(iD, dataDef);
            //reads next line
            strg = br.readLine();
        }
        //use object to initialize data definitions
        //list
        DataDay.setDataDefinitionList(this);
        //closes bufferedReader
        br.close();
    }

    /**
     * getter for the set of variable Ids
     * @return varIds 
     * the variable Ids in dataDefList
     */
    public ArrayList<String> getVariableIds()
    {
        //array list of var ids
        ArrayList<String> varIds = new ArrayList<String>();
        //iterates through hashmap
        for (String id : datainfoMap.keySet())
        {
            varIds.add(id);
        }
        return varIds;
    }

    /**
     * returns bool representing the validity of 
     * a datadef with a specific Id
     * valid if stat with ID exists
     * @param variableId Id of dataDef to check validity
     * of
     * @return true if stat is valid false otherwise
     */
    public boolean isValidStat(String variableId)
    {
        return datainfoMap.containsKey(variableId);
    }

    /**
     * getter for a data definition with a specific
     * variable ID
     * @param variableId variable ID of object to be returned
     * @return the dataDefinition of object using variableId
     */
    public DataDefinition getDataInfo(String variableId)
    {
        return datainfoMap.get(variableId);
    }
    
    /**
     * returns a string representation of a dataDefList
     * @return dataDefs all contained data definitions with a
     * new line at the very bottom
     */
    public String toString()
    {
        //String to add datadefs to and return
        String dataDefs = "";
        //adds string rep of every datadef 
        for (DataDefinition def : datainfoMap.values())
        {
            dataDefs += def.toString() + "\n";
        }
        return dataDefs;
    }
}
