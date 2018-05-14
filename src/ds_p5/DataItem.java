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
 * Defines properties and methods of a Data item for the Hash Table
 */
public class DataItem {
    private int key;
    private President president; 
    
    /**
     * Constructor for a Data item
     * @param inKey The key for the data item
     * @param inPrez The president object in the data item
     * @return constructor
     */
    public DataItem(int inKey, President inPrez){
        key = inKey;
        president = inPrez;
    }//end constructor
    
    
    /**
     * Gets the key for the data item
     * @param none
     * @return The data item's key
     */
    public int getKey(){
        return key;
    }//end getKey()
    
    /**
     * Gets the name of the president in the data item
     * @param none
     * @return The president's name
     */
    public String getName(){
        return president.getName();
    }//end getName()
    
    
    /**
     * Gets the president object in the Data Item
     * @param none
     * @return The president in the Data Item
     */
    public President getPresident(){
        return president;
    }//end getPresident()
}//end DataItem Class

