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
 * Defines properties and methods for a hash table with separate chaining
 */
public class ChainHash {
    private SortedList[] hashArray;
    private int arraySize;
    
    
    /**
     * Constructor for the Chain Table
     * @param size The size of the table
     * @return constructor
     */
    public ChainHash(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i<arraySize; i++){
            hashArray[i] = new SortedList();
        }//end for
    }//end constructor
    
    
    /**
     * Displays the Chain Table
     * @param none
     * @return void
     */
    public void displayTable(){
        
        System.out.println("");
        for (int i = 0; i<arraySize; i++){
            System.out.format("%-3s%-5s", i, "     ");
            hashArray[i].displayList();
        }//end for
    }//end displayTable

    
    /**
     * Defines the hashing function
     * @param key The key used to determine the hash value
     * @return The hash value
     */
    public int hashFunc(int key){
        return key%arraySize;
    }//end hashFunc
    
    
    /**
     * Inserts a link into the Chain table
     * @param link The link inserted
     * @return void
     */
    public void insert(Link link){
        int key = link.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }//end insert
        
    /**
     * Deletes a link from the chain table
     * @param link The link deleted
     * @return void
     */
    public void delete(Link link){
        int key = link.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(link);
    }//end delete
}//end ChainHash Class
