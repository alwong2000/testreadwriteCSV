package testreadwritecsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf_sarhan
 *
 */
public class CsvFileReader {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	
	//Student attributes index
	private static final int STUDENT_ID_IDX = 0;
	private static final int STUDENT_FNAME_IDX = 1;
	private static final int STUDENT_LNAME_IDX = 2;
	private static final int STUDENT_GENDER = 3; 
	private static final int STUDENT_AGE = 4;
	public static int duplicate_flag =0;
	public static void readCsvFile(String fileName) {

		BufferedReader fileReader = null;
     
        try {
        	
        	//Create a new list of student to be filled by CSV file data 
        	List<Student> students = new ArrayList<Student>();
        	
            String line = "";
            
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));
            
            //Read the CSV file header to skip it
            fileReader.readLine();
            
            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                	//Create a new student object and fill his  data
					Student student = new Student(Long.parseLong(tokens[STUDENT_ID_IDX]), tokens[STUDENT_FNAME_IDX], tokens[STUDENT_LNAME_IDX], tokens[STUDENT_GENDER], Integer.parseInt(tokens[STUDENT_AGE]));
					//added merging duplicate rows function
int rows_total = students.size();
System.out.println("The total number of the ArrayList students is: "+ rows_total ); //debugging statement
 //
 
for (int i =0; i< rows_total; i++){
if (students.get(i).getLastName().compareTo(tokens[STUDENT_LNAME_IDX])==0){
    System.out.println("The age number of the current matched student is: "+ students.get(i).getAge() ); //debugging statement
    System.out.println("The age number of the current purging student is: "+ tokens[STUDENT_AGE] ); //debugging statement
students.get(i).setAge(students.get(i).getAge()+Integer.parseInt(tokens[STUDENT_AGE]));
duplicate_flag =1;
// test the value of age;
System.out.println("The age number of the current student is: "+ students.get(i).getAge() ); //debugging statement
}
}
 
//
/*for ( Student studentb : students) {
if (studentb.getLastName().compareTo(tokens[STUDENT_LNAME_IDX])==0)){
studentb.setAge(studentb.getAge()+Integer.parseInt(tokens[STUDENT_AGE]));
}
}*/

if (duplicate_flag == 1 ){ duplicate_flag = 0;}else{
                                        students.add(student);duplicate_flag = 0;}
				}
            }
            
            //Print the new student list
            for (Student student : students) {
				System.out.println(student.toString());
			}
            
        } 
        catch (Exception e) {
        	System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
            	System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

	}

}
