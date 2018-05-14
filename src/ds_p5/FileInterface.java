/*
Author: Kevin Bell
Course: COP3538
Project#: 5
Title: Hashing
Due Date: 12/1/2016

Builds and modifies hash tables
 */
package ds_p5;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides properties and methods for reading input
 */
public class FileInterface {
    private FileReader fr;
    private BufferedReader br;
    
    private ArrayList<President> fileData;
    
    
    /**
     * Constructor for FileInterface
     * @param file the input file
     * @return constructor
     * @throws FileNotFoundException 
     */
    public FileInterface(String file) throws FileNotFoundException{
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        
        fileData = new ArrayList<>();
        //dataStrings = new ArrayList<>();
    }//end constructor 
    
    
    /**
     * Parses input file
     * @param none
     * @return void
     * @throws IOException 
     */
    public void parse() throws IOException{
        int number;
        String name;
        int years;
        String party;
        String state;
        int key;
        String code;
        String input;
        
        while ((input = br.readLine()) != null){
            try{  
                String[] inArray = new String[5];
            
                inArray = input.split(",");
            
                number = Integer.parseInt(inArray[0]);
                name = inArray[1];
                years = Integer.parseInt(inArray[2]);
                party = inArray[3];
                state = inArray[4];
                code = null;

                fileData.add(new President(number, name, years, party, state, code));
            }catch(Exception e){                
            }//end try
        }//end while    }//end parse()
    }//end parse()
    
    
    /**
     * Parses updates file 
     * @param none
     * @return void
     * @throws IOException 
     */
    public void parseUpdate() throws IOException{
        int number;
        String name;
        int years;
        String party;
        String state;
        int key;
        String code;
        String input;
        
        while ((input = br.readLine()) != null){
            try{               
                String[] inArray = new String[6];
            
                inArray = input.split(",");
            
                code = inArray[0];
                number = Integer.parseInt(inArray[1]);
                name = inArray[2];
                years = Integer.parseInt(inArray[3]);
                party = inArray[4];
                state = inArray[5];
               
                fileData.add(new President(number, name, years, party, state, code));
            }catch(Exception e){ 
                
                String[] inArray = new String[2];
                
                inArray = input.split(",");
                
                code = inArray[0];
                name = inArray[1];
                number = -1;
                years = -1;
                party = null;
                state = null;
                
                fileData.add(new President(number, name, years, party, state, code));
            }//end try         
        }//end while
    }//end parseUpdate()
    
    
    /**
     * Returns input data
     * @param none
     * @return the array of file data
     */
    public ArrayList<President> getFileData(){
          return fileData;
      }//end getFileData
}//end FileInterface