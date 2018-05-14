/*
Author: Kevin Bell
Course: COP3538
Project#: 5
Title: Hashing
Due Date: 12/1/2016

Builds and modifies hash tables
 */
package ds_p5;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Builds and modifies hash tables
 */
public class Main {

    /**
     * Builds and modifies hash tables
     * @param args None
     * @return void
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PrezController drvr = new PrezController();
        
        FileInterface fileData = new FileInterface("HashHeap.txt");
        fileData.parse();
        
        for (President president: fileData.getFileData()){
            drvr.insertArray(president);
        }//end for
        
        drvr.buildOpenHash();
        
        FileInterface updateData = new FileInterface("HashHeapUpdate.txt");
        updateData.parseUpdate();
        
        for (President president: updateData.getFileData()){
            drvr.insertUpdate(president);
        }//end for
        
        drvr.updateTables();
        drvr.displayStats();
        
        drvr.buildChainHash();
        drvr.updateChainTable();
        
    }//end main()
}//end Main Class
