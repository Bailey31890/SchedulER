import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/** 
 * @name FileIO
 * @description reads the different csv files that stores the information
 * about classes, majors, credits, and users as well as writes any changes
 * that occur to user settings or courses.
 * 
 * @author	Liam Kehoe, Nathaniel Deen 
 * @version	4.0
 * @since	2019-04-24
 **/
public class FileIO {

	String[][] classList, majors, majorReq, userCourses, userInfo;
	String[] profile, classes;

	public FileIO() throws Exception { 

		classList = Read_Class_List();
		majors = Read_Majors();
		userCourses = Read_User_Courses();
		userInfo = Read_User_Info();

		classes = makeProfile("1234567");
		profile = makeClasses("1234567");
	}

	//methods
	/**
	 * makeProfile
	 * 
	 * This method creates a one dimensional array that holds the current user's information
	 * 
	 * @param cur
	 * @return String[]
	 * @throws IOException
	 */
	public String[] makeProfile(String cur) throws IOException {

		userInfo = Read_User_Info();

		String[] cut = new String[5];

		cur = userInfo[0][0]; //changes with login just a test value
		String check = "0000000";
		int counter = 0;

		//loop finds index of users profile
		while (!cur.equals(check)) {
			check = userInfo[counter][0];

			counter++;
		}

		for (int i = 0; i < 5; i++) {

			cut[i] = userInfo[counter - 1][i];
		}

		profile = cut;
		return cut;
	}

	/**
	 * makeClasses
	 * 
	 * This method creates a one dimensional array that holds the current user's courses
	 * 
	 * @param cur
	 * @return String[]
	 * @throws Exception
	 */
	public String[] makeClasses(String cur) throws Exception{

		String[] cut = new String[135];

		String check = "0000000";
		int counter = 0;

		//loop finds index of users profile
		while (!(cur.equals(check))) {
			check = userCourses[1][0];

			counter++;
		}

		for (int i = 1; i < 136; i++) {

			cut[i - 1] = userCourses[counter][i];
		}

		classes = cut;
		return cut;
	}

	/**
	 * @name Read_Class_List
	 * @description This method reads the csv file ClassList and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	private String[][] Read_Class_List() throws IOException
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
	 * @name Read_Majors
	 * @description This method reads the csv file Majors and saves the information
	 * inside of it as an ArrayList
	 * 
	 * @return ArrayList
	 * @throws IOException
	 */
	private String[][] Read_Majors() throws IOException
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
	 * @name Read_Major_Requirements
	 * @description This method reads the csv file dedicated to whichever major 
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
	 * @name Read_User_Info
	 * @description This method reads the csv file UserInfo and saves the information
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
		FileReader fr2 = new FileReader(file);
		BufferedReader br2 = new BufferedReader(fr2);
		String line;
		String retVal[] = new String[1];

		int r = 0;
		while((line = br.readLine()) != null)
		{
			r++;
		}

		String[][] userInfo = new String[r][5];


		line = br2.readLine();
		retVal = line.split(",");
		for (int y=0; y<retVal.length; y++)
		{
			userInfo[0][y] = retVal[y];
		}

		for (int x=1; x<r; x++)
		{
			while((line = br2.readLine()) != null)
			{
				retVal = line.split(",");

				for (int i=0; i<retVal.length; i++)
				{
					userInfo[x][i] = retVal[i];
				}

				x++;
			}
		}

		br.close();
		br2.close();
		return userInfo;
	}

	/**
	 * @name Read_User_Courses
	 * @description This method reads the csv file UserCourses and saves the information
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

	//writes to files

	/**
	 * @name Write_User_Info
	 * @description This method reads the csv file with the userInfo and writes new information
	 * given inside of the csv file
	 * 
	 * @param String[][]
	 * @throws  IOException
	 */
	public void Write_User_Info(String[][] userInfo) throws IOException
	{		
		File file = new File("UserInfo.csv");

		int r = userInfo.length;

		if (file.exists())
		{
			file.delete();
		}

		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);		

		for (int i=0; i < r; i++) 
		{
			if (userInfo[i][0] == null) 
			{
				break;
			} 
			else 
			{

				for (int j=0; j < 5; j++) 
				{
					if (j==4)
					{
						pw.print(userInfo[i][j]);
						pw.println();
					}
					else
					{
						pw.print(userInfo[i][j]);
						pw.print(",");
					}
				}
			}
		}
		pw.close();
	}

	/**
	 * @name ChangeOrAdd_User_Info
	 * @description This method reads the csv file with the userInfo and writes new information
	 * given inside of the csv file
	 * 
	 * @param String[]
	 * @return String[][]
	 * @throws Exception 
	 */
	public  String[][] ChangeOrAdd_User_Info(String[] curUserInfo) throws Exception {
		FileIO fileio = new FileIO();
		String[][] userInfo = fileio.getUserInfo();
		Boolean eUser = false;

		int uAmt = userInfo.length;

		String[][] newUserInfo = new String[uAmt + 1][5];

		for (int i=0; i<uAmt; i++)
		{
			if (curUserInfo[0].equals(userInfo[i][0]))
			{
				userInfo[i][3] = curUserInfo[3];
				userInfo[i][4] = curUserInfo[4];
				i = uAmt;
				eUser = true;
			}
		}

		if (eUser == false)
		{
			//String[][] newUserInfo = new String[uAmt + 1][5];

			for (int i=0; i<uAmt +1; i++)
			{
				if (i==uAmt)
				{
					newUserInfo[i][0] = curUserInfo[0];
					newUserInfo[i][1] = curUserInfo[1];
					newUserInfo[i][2] = curUserInfo[2];
					newUserInfo[i][3] = curUserInfo[3];
					newUserInfo[i][4] = curUserInfo[4];
				}
				else
				{
					newUserInfo[i][0] = userInfo[i][0];
					newUserInfo[i][1] = userInfo[i][1];
					newUserInfo[i][2] = userInfo[i][2];
					newUserInfo[i][3] = userInfo[i][3];
					newUserInfo[i][4] = userInfo[i][4];
				}
			}
		}
		else if (eUser == true)
		{
			//String[][] newUserInfo = new String[uAmt][5];

			for (int i=0; i<uAmt; i++)
			{
				newUserInfo[i][0] = userInfo[i][0];
				newUserInfo[i][1] = userInfo[i][1];
				newUserInfo[i][2] = userInfo[i][2];
				newUserInfo[i][3] = userInfo[i][3];
				newUserInfo[i][4] = userInfo[i][4];
			}
		}
		else
		{
			//String[][] newUserInfo = new String[uAmt][5];

			System.out.println("ERROR: Current User Not Showing As New User Nor Existing User");
		}



		return newUserInfo;
	}

	/**
	 * @name Write_User_Courses
	 * @description This method reads the csv file with the userCourses and writes new information
	 * given inside of the csv file
	 * 
	 * (Not fully implemented)
	 * 
	 * @param String[]
	 * @throws Exception 
	 */
	public void Write_User_Courses(String[] curUserCourses) throws Exception {
		File file = new File("UserCourses.csv");
		FileIO fileio = new FileIO();

		String[][] userCourses = fileio.getUserCourses();

		int r = curUserCourses.length;
		int q = userCourses.length;
		Boolean eUser = false;

		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);

		if (file.exists())
		{
			file.delete();
		}

		for (int i=0; i<q; i++)
		{
			System.out.println();
			System.out.println(curUserCourses[0]);
			System.out.println(userCourses[i][0]);
			if (curUserCourses[0].contentEquals(userCourses[i][0]))
			{
				eUser = true;
				for (int j=0; j<r; j++)
				{
					userCourses[i][j] = curUserCourses[j];
				}
			}				
		}

		for (int i=0; i<137; i++)
		{
			if (userCourses[0][i] == null) 
			{
				break;
			} 
			else 
			{
				for (int j=0; j<q; j++)
				{
					if (j==1)
					{
						pw.print(userCourses[j][i]);
						System.out.println(userCourses[j][i]);
						pw.println();
					}
					else
					{
						pw.print(userCourses[j][i]);
						System.out.println(userCourses[j][i]);
						pw.print(",");
					}
				}
			}
		}

		pw.close();
	}

	//getters
	public String[][] getClassList() throws IOException { return classList; }

	public String[][] getMajors() throws IOException { return majors; }

	public String[][] getMajorReq() throws IOException { return majorReq; }

	public String[][] getUserCourses() throws Exception {
		FileIO fileio = new FileIO();
		String[][] userCourses = fileio.Read_User_Courses();
		return userCourses;
	}

	public String[][] getUserInfo() throws Exception {
		FileIO fileio = new FileIO();
		String[][] userInfo = fileio.Read_User_Info();
		return userInfo;
	}
}//end File IO