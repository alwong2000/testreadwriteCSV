/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testreadwritecsv;

/**
 *
 * @author alan
 */
public class TestReadWriteCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String fileName = "inventorylist.csv";
		/*
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);
             */
		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);
   
                
                
    }
    
}
