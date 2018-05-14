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
 * Provides properties and methods for a Sorted Linked List
 */
public class SortedList {
    private Link first;
    
    /**
     * Constructor for Sorted Linked List
     * @param none
     * @return Constructor 
     */
    public SortedList(){
        first = null;
    }//end constructor
    
    
    
    /**
     * Inserts a link into the linked list
     * @param link The link inserted into the list
     * @return void
     */
    public void insert(Link link){
        int key = link.getKey();
        Link previous = null;
        Link current = first;
        
        while(current != null && key>current.getKey()){
            previous = current;
            current = current.next;
        }//end while
        if(previous == null){
            first = link;
        }else{
            previous.next = link;
        }//end if
        link.next = current;
    }//end insert
    
    
    
    /**
     * Deletes a link from a list
     * @param key The key for deletion 
     * @return The link deleted 
     */
    public Link delete(Link link){
        int key = link.getKey();
        
        Link current = first;
        
        while(current!= null && current.getKey() <= key){
            if (current.getKey() == key){
                current.setKey(-1);
                return current;
            }//end if
            current = current.next;
        }//end while
        return null;
    }//end delete()
    
    
    
    /**
     * Displays the linked list
     * @param none
     * @return void
     */
    public void displayList(){
        Link current = first;
        
        while(current != null){
            current.displayLink();
            current = current.next;
        }//end while
        System.out.println("");
    }//end displayList   
}//end SortedList Class
