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
 * Defines properties and methods of a link in a Sorted List
 */
public class Link {
    private int key;
    private President president;
    public Link next;
    
    /**
     * Constructor for a Link
     * @param inKey The key for the link
     * @param inPrez The president object in the link
     * @return constructor
     */
    public Link(int inKey, President inPrez){
        key = inKey;
        president = inPrez;
    }//end constructor
    
    
    /**
     * Gets the key for the link
     * @param none
     * @return The links key
     */
    public int getKey(){
        return key;
    }//end getKey()
    
    /**
     * Sets the key for the link
     * @param newKey the new key
     * @reuturn void
     */
    public void setKey(int newKey){
        key = newKey;
    }//end setKey()
    
    /**
     * Gets the name of the president in the link
     * @param none
     * @return The president's name
     */
    public String getName(){
        return president.getName();
    }//end getName()
    
    
    /**
     * Displays the link
     * @param none
     * @return void
     */
    public void displayLink(){
        if (key == -1){
            System.out.format("%-10s%-5s", "*"+president.getName(), "     ");
        }else{
            System.out.format("%-10s%-5s", president.getName(), "     ");
        }//end if
    }//end displayLink()
}//end Link class
