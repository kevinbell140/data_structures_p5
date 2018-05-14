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
 * Defines properties and methods for a hash table with open addressing 
 */
public class OpenHash {
    private DataItem[] hashArray;
    private int arraySize;
    private President nonItem;
    private int[] probeArray;
    private int probeElem; 
    private int[] foundArray;
    private int foundElem;
    
    
    /**
     * Constructor for a hash table of presidents
     * @param size The size of the hash table
     * @return constructor
     */
    public OpenHash(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        
        
        probeArray = new int[9];
        probeElem = 0;
        
        
        foundArray = new int[6];
        foundElem = 0;
    }//end constructor
    
    /**
     * Displays the hash table
     * @param table Determines which table to display
     * @return void
     */
    public void displayTable(int table){

        for (int i = 0; i<arraySize; i++){
            if (hashArray[i] != null){
                if(hashArray[i].getKey() == -1){
                    System.out.format("\n%-7s%-15s", i, "*"+hashArray[i].getName());
                }else{
                    System.out.format("\n%-7s%-15s", i, hashArray[i].getName());
                }//end if
            }else{
                System.out.format("\n%-7s%-15s", i, " ");
            }//end if
        }//end for
    }//end displayTable()
    
    
    
    /**
     * Defines the hashing function
     * @param key The key used to determine the hash value
     * @return The hash value
     */
    public int hashFunc(int key){
        return key%arraySize;
    }//end hashFunc()
    
    
    /**
     * Inserts a data item into the hash table
     * @param item The president to be inserted into the hash table
     * @return void
     */
    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
      
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arraySize;
        }//end while
        hashArray[hashVal] = item;
    }//end insert()
    
    /**
     * Inserts a data item from the update file into the hash table
     * @param item  The president to be inserted into the hash table
     * @return void
     */
    public void insertUpdate(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int probes= 1;
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            
            ++hashVal;
            hashVal %= arraySize;
            probes++;
        }//end while
        probeArray[probeElem++] = probes; 
        hashArray[hashVal] = item;
    }//end insertUpdate()
    
    
    /**
     * Logically deletes an item from the hash table
     * @param item The president to be deleted from the hash table
     * @return The data item deleted
     */
    public DataItem delete(DataItem item){
        
        DataItem nonItem = new DataItem(-1, item.getPresident());
        int key = item.getKey();
        int hashVal = hashFunc(key);
        
        int probes = 1;
        
        while(hashArray[hashVal] != null){
            if (hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                probeArray[probeElem++] = probes; 
                foundArray[foundElem++] = 1; 
                return temp;
            }//end if
            probes++;
            ++hashVal;
            hashVal%=arraySize;
        }//end while
        probeArray[probeElem++] = probes;
        foundArray[foundElem++] = 0;
        return null;
    }//end delete()
    
    /**
     * Gets the transaction stats
     * @param none
     * @return the array of stats 
     */
    public int[] getProbes(){
        
        return probeArray;
    }//end getProbes()
    
    
    /**
     * Gets the found array
     * @param none
     * @return the array of transaction success
     */
    public int[] getFoundArray(){

        return foundArray;
    }//end getFoundArray()
}//end OpenHash class
