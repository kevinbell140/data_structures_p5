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
 * Defines properties and methods for the container
 */
public class PrezController {
    private President[] prezArray;
    private int pElem;
    
    private President[] updateArray;
    private int uElem;
    
    private OpenHash table1;
    private OpenHash table2;
    private ChainHash table3;
 
    
    /**
     * Constructor for the Collection
     * @param none
     * @return constructor
     */
    public PrezController(){
        prezArray = new President[16];
        pElem = 0;
        
        updateArray = new President[9];
        uElem = 0;
    }//end constructor
    
    
    /**
     * Inserts a president into the collection array
     * @param president The president inserted into the array
     * @return void
     */
    public void insertArray(President president){
        president.setKey(makeKey(president.getName()));
        prezArray[pElem++] = president;
    }//end insertArray()
    
    
    /**
     * Inserts a president into the update array
     * @param president The president inserted into the array
     * @return void
     */
    public void insertUpdate(President president){
        president.setKey(makeKey(president.getName()));
        updateArray[uElem++] = president;
    }//end insertUpdate()
    
    
    /**
     * Displays the president array
     * @param none
     * @return void
     */
    public void displayArray(){
        for (int i = 0; i<prezArray.length; i++){
            System.out.println(prezArray[i].getName() + " " + prezArray[i].getKey());
        }//end for
    }//end displayArray()
    
    
    /**
     * Displays the updateArray()
     * @param none
     * @return void
     */
    public void displayUpdateArray(){
        System.out.println(" ");
        for (int i = 0; i<updateArray.length; i++){
            System.out.println(updateArray[i].getCode() + " " + updateArray[i].getName() + " " + updateArray[i].getKey());
        }//end for
    }//end while
    
    
    /**
     * Determines the president's key
     * @param name The president's name
     * @return The president's key
     */
    private int makeKey(String name){
        int key = 0;
        
        for(int i=0; i<name.length(); i++){
            int letter = name.toLowerCase().charAt(i)-96;

            key += letter;
        }//end for
        if (name.contains("_")){
            key += 1;
        }//end if
        return key;
    }//makeKey()
    
    
    /**
     * Builds and displays hash table with open addressing
     * @param none
     * @return void
     */
    public void buildOpenHash(){
        
        table1 = new OpenHash(37);
        
        for (President president: prezArray){
            DataItem dataItem = new DataItem(president.getKey(), president);
            table1.insert(dataItem);
        }//end for
        getTableHeader(1);
        table1.displayTable(1);
        
        table2 = new OpenHash(23);
        
        for (President president: prezArray){
            DataItem dataItem = new DataItem(president.getKey(), president);
            table2.insert(dataItem);
        }//end for
        getTableHeader(2);
        table2.displayTable(2);
    }//end buildHashTable()
    
    
    
    
    /**
     * Builds and displays a hash table with separate chaining
     * @param none
     * @return void
     */
    public void buildChainHash(){
        
        table3 = new ChainHash(17);
        
        for (President president: prezArray){
            Link newLink = new Link(president.getKey(), president);
            table3.insert(newLink);
        }//end for
        getChainHeader();
        table3.displayTable();
    }//end buildChainTable
    
    
  
    /**
     * Adds and deletes presidents from the Hash Table
     * @param none
     * @return void
     */
    public void updateTables(){
        for (President president: updateArray){
            DataItem dataItem = new DataItem(president.getKey(), president);
            if(president.getCode().equals("A")){
                
                table1.insertUpdate(dataItem);
                table2.insertUpdate(dataItem);
            }else{
                table1.delete(dataItem);
                table2.delete(dataItem);
            }//end if
        }//end for
        getUpdatedHeader(1);
        table1.displayTable(1);
        getUpdatedHeader(2);
        table2.displayTable(2);
    }//end updateTables
    
    
    
    /**
     * Adds and deletes presidents from the chain table
     * @param none
     * @return void
     */
    public void updateChainTable(){
        for (President president: updateArray){
            Link newLink = new Link(president.getKey(), president);
            if(president.getCode().equalsIgnoreCase("A")){
                table3.insert(newLink);
            }else{
                table3.delete(newLink);
            }//end if
        }//end for
        getChainUpdateHeader();
        table3.displayTable();
    }//end updateChainTable
    
    
    
    /**
     * Displays number of probes for each transaction
     * @param none
     * @return void
     */
    public void displayStats(){
        int[] table1Probes = new int[9];
        int[] table2Probes = new int[9];
        int[] table1Found = new int[6];
        int j = 0;
        
        table1Probes = table1.getProbes();
        table2Probes = table2.getProbes();
        table1Found = table1.getFoundArray();

        getTxnHeader();        
        for (int i = 0; i<updateArray.length; i++){
            if (updateArray[i].getCode().equalsIgnoreCase("D") && table1Found[j++] == 0){
                    System.out.format("\n%-15s%-7s%-15s%-15s", updateArray[i].getName(), updateArray[i].getCode(), "Not found" + "(" +table1Probes[i] + ")", "Not found" + "(" + table2Probes[i] + ")" );
            }else{
                    System.out.format("\n%-15s%-7s%-15s%-15s", updateArray[i].getName(), updateArray[i].getCode(), table1Probes[i], table2Probes[i]);
            }//end if
        }//end for
    }//end displayStats()
    
    
    /**
     * Displays Transaction Performance Header
     * @param none
     * @return void
     */
    private void getTxnHeader(){
      System.out.format("\n\n\n%-15s\n", "Hash Table Performance Statistics");
      System.out.format("\n%-15s%-7s%-15s%-15s", "Transaction", "Type", "Table 1", "Table2");
      System.out.format("\n%-15s%-7s%-15s%-15s", "------------","-----", "---------", "--------");
    }//end getTxnHeader()
    
    
    /**
     * Displays Hash Table Header
     * @param none
     * @return void
     */
    private void getTableHeader(int table){
        System.out.format("\n\n\n%-15s\n", "Hash Table "+ table);
        System.out.format("\n%-7s%-15s", "Index", "Value");
        System.out.format("\n%-7s%-15s", "-----", "------------");
    }//end getTableHeader()
    
    
    /**
     * Displays Updated Hash Table Header
     * @param none
     * @return void
     */
    private void getUpdatedHeader(int table){
        System.out.format("\n\n\n%-15s\n", "Updated Hash Table "+ table);
        System.out.format("\n%-7s%-15s", "Index", "Value");
        System.out.format("\n%-7s%-15s", "-----", "------------");        
    }//end getUpdateHeader
    
    
    /**
     * Displays Chain Table Header
     * @param none
     * @return void
     */
    private void getChainHeader(){
        System.out.format("\n\n\n%-15s\n", "Hash Table 3");
        System.out.format("\n%-8s%-15s%-15s%-15s%-15s", "Index", "Value", "Value", "Value", "Value");
        System.out.format("\n%-8s%-15s%-15s%-15s%-15s", "-----", "----------", "----------", "----------", "----------");
    }//end getChainHeader()
    
    
    /**
     * Displays Updated Chain Table Header
     * @param none
     * @return void
     */
    private void getChainUpdateHeader(){
        System.out.format("\n\n\n%-15s\n", "Updated Hash Table 3");
        System.out.format("\n%-8s%-15s%-15s%-15s%-15s", "Index", "Value", "Value", "Value", "Value");
        System.out.format("\n%-8s%-15s%-15s%-15s%-15s", "-----", "----------", "----------", "----------", "----------");
    }//end getChainUpdateHeader()
}//end Collection Class
