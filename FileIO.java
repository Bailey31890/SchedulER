import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
 * @since	2019-03-21
 **/
public class FileIO {
	
	String[][] classList, majors, majorReq, userCourses, userInfo;
	String[] profile;
	
	public FileIO() throws IOException { 
		
		classList = Read_Class_List();
		majors = Read_Majors();
		userCourses = Read_User_Courses();
		userInfo = Read_User_Info();
		
	}

	//methods
	//getters
	public String[][] getClassList() throws IOException { return classList; }

	public String[][] getMajors() throws IOException { return majors; }

	public String[][] getMajorReq() throws IOException { return majorReq; }

	public String[][] getUserCourses() throws IOException { return userCourses; }

	public String[][] getUserInfo() throws IOException { return userInfo; }

	/**
	 * Read_Class_List
	 * This method reads the csv file ClassList and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public String[][] Read_Class_List() throws IOException
	{
		String[][] classList = new String [2][159];
		File file = new File("ClassList.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String retVal[] = new String[1];

		for (int i=0; i < 159; i++)
		{
			while ((line = br.readLine()) != null)
			{					
				retVal = line.split(",");
				classList[0][i] = retVal[0];
				classList[1][i] = retVal[1];
				i++;
			}
		}

		br.close();
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
	public String[][] Read_Majors() throws IOException
	{
		String[][] majors = new String [2][17];
		File file = new File("Majors.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String retVal[] = new String[1];

		for (int i=0; i < 17; i++)
		{
			while ((line = br.readLine()) != null)
			{					
				retVal = line.split(",");
				majors[0][i] = retVal[0];
				majors[1][i] = retVal[1];
				i++;
			}
		}

		br.close();
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
	public String[][] Read_Major_Requirements(File file) throws IOException
	{
		String[][] majorReq = new String [8][14];
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String retVal[] = new String[1];

		for (int i=0; i < 14; i++)
		{
			while ((line = br.readLine()) != null)
			{					
				retVal = line.split(",");
				majorReq[0][i] = retVal[0];
				majorReq[1][i] = retVal[1];
				majorReq[2][i] = retVal[2];
				majorReq[3][i] = retVal[3];
				majorReq[4][i] = retVal[4];
				majorReq[5][i] = retVal[5];
				majorReq[6][i] = retVal[6];
				majorReq[7][i] = retVal[7];
				i++;
			}
		}

		br.close();
		return majorReq;
	}

	/**
	 * Read_User_Info
	 * This method reads the csv file UserInfo and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public String[][] Read_User_Info() throws IOException
	{
		File file = new File("UserInfo.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String retVal[] = new String[1];

		line = br.readLine();
		retVal = line.split(",");

		String[][] userInfo = new String[retVal.length][3];
		for (int y=0; y<retVal.length; y++)
		{
			userInfo[y][0] = retVal[y];
		}

		for (int i=1; i<3; i++)
		{
			while((line = br.readLine()) != null)
			{
				retVal = line.split(",");

				for (int x=0; x<retVal.length; x++)
				{
					userInfo[x][i] = retVal[x];
				}

				i++;
			}
		}

		br.close();
		return userInfo;
	}

	/**
	 * Read_User_Courses
	 * This method reads the csv file UserCourses and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	public String[][] Read_User_Courses() throws IOException
	{
		File file = new File("UserCourses.csv");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String retVal[] = new String[1];

		line = br.readLine();
		retVal = line.split(",");

		String[][] userCourses = new String[retVal.length][137];
		for (int y=0; y<retVal.length; y++)
		{
			userCourses[y][0] = retVal[y];
		}

		for (int i=1; i<137; i++)
		{
			while ( (line = br.readLine() ) != null )
			{
				retVal = line.split(",");

				for (int x=0; x < retVal.length; x++)
				{
					userCourses[x][i] = retVal[x];
				}

				i++;
			}
		}


		br.close();
		return userCourses;
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