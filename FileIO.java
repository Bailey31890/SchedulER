import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 2/27/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: Course_Database extends Pane
//
// Attributes: 
//
// Methods: 
//
// Description:
// 
//
// ***************************************************************

/** 
 * FileIO
 * FileIO reads the five different csv files that stores the information
 * about classes, majors, credits, and users as well as writes any changes
 * that occur to user settings or courses.
 * 
 * @author	Liam Kehoe 
 * @version	1.0
 * @since	2019-03-05
**/
public class FileIO {

	//Initializes Attributes
	private char[] Courses;
	private char[] Degrees;
	private char[] User_Information;

	//methods
	/**
	 * Temporary Main
	 * This is just a temporary main class used for debugging and testing
	 * purposes.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		FileIO fileio = new FileIO();
		ArrayList<String> alFile = fileio.Read_Class_List();
		for (int i=0;i<alFile.size();i++)
		{
			System.out.println(alFile.get(i));
		}
	}

	/**
	 * Read_Class_List
	 * This method reads the csv file ClassList and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> Read_Class_List() throws IOException
	{
		ArrayList<String> classList = new ArrayList<>();
		//Scanner scanner = new Scanner(new File("ClassList.csv"));
		File file = new File("ClassList.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
			while ( (line = br.readLine() ) != null )
			{
				classList.add(line);
			}
		
		return classList;
	}
	
	/**
	 * Read_Majors
	 * This method reads the csv file Majors and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> Read_Majors() throws IOException
	{
		return majors;
	}
	
	/**
	 * Read_Major_Requirements
	 * This method reads the csv file dedicated to whichever major 
	 * requirements file given and saves the information inside of it 
	 * as an ArrayList
	 * 
	 * @param file This is the specific file to be read
	 * @return ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> Read_Major_Requirements(File file) throws IOException
	{
		return mRequirements;
	}
	
	/**
	 * Read_User_Info
	 * This method reads the csv file UserInfo and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> Read_User_Info() throws IOException
	{
		return uInfo;
	}
	
	/**
	 * Read_User_Courses
	 * This method reads the csv file UserCourses and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public ArrayList<String> Read_User_Courses() throws IOException
	{
		return uCourses;
	}

	/**
	 * 
	 */
	public void Write_User_Info()
	{
		
	}
	/**
	 * 
	 */
	public void Write_User_Courses()
	{
		
	}
}//end File IO