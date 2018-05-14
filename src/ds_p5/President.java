/*
Author: Kevin Bell
Course: COP3538
Project#: 5
Title: Hashing
Due Date: 12/1/2016

Builds and modifies hash tables
 */
package ds_p5;

/**
 * Defines properties and methods for a president object
 */
public class President {
    private int key;
    private int number;
    private String name; 
    private int years;
    private String party;
    private String code;
    private String state;
    
    
    /**
     * Creates an object instance of a presidents object
     * @param pNum President's number
     * @param pName President's name
     * @param pYears President's years in office
     * @param pParty President's party
     * @param pState President's state
     * @param pCode  President's transaction code
     * @return Constructor for president object
     */
    public President (int pNum, String pName, int pYears, String pParty, String pState, String pCode){
        number = pNum;
        name = pName;
        years = pYears;
        party = pParty;
        state = pState;
        code = pCode;
    }//end constructor
    
    
    /**
     * Gets the president's hash key
     * @param none
     * @return President's key
     */
    public int getKey(){
        return key;
    }//end getKey()
   
    
    /**
     * Gets the president's name
     * @param none
     * @return The president's name
     */
    public String getName(){
        return name;
    }//end getName()
    
    
    /**
     * Sets the president's hash key
     * @param inKey The president's key
     * @return void
     */
    public void setKey(int inKey){
        key = inKey;
    }//end setKey()
    
    
    /**
     * Gets the president's transaction code
     * @param none
     * @return The president's transaction code
     */
    public String getCode(){
        return code;
    }//end getCode()
}//end President Class
