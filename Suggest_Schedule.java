// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 2/20/2019
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

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Suggest_Schedule extends Pane{

	//constructor
	public Suggest_Schedule(SchedulERlauncher go, FileIO inOut) throws IOException{
		
		//build pane - labels of pane come from below functions - doing a 2 by 9 grid
		GridPane schedulePane = new GridPane();
		
		Label header = new Label("Suggested Schedule");
		Label user = new Label();
		//left side label for class
		Label classHeader1 = new Label("Class 1:");
		Label classHeader2 = new Label("Class 2:");
		Label classHeader3 = new Label("Class 3:");
		Label classHeader4 = new Label("Class 4:");
		Label classHeader5 = new Label("Class 5:");
		Label classHeader6 = new Label("Class 6:");
		Label classHeader7 = new Label("Class 7:");
		Label classHeader8 = new Label("Class 8:");
		
		
		//actual name for classes - need to retrieve classes from single dimensional array and place them into the label descriptions
		String[] classes = new String[8];
		
		//pass this array to method that fills with classes
		
		Label class1 = new Label(classes[0]);
		Label class2 = new Label(classes[1]);
		Label class3 = new Label(classes[2]);
		Label class4 = new Label(classes[3]);
		Label class5 = new Label(classes[4]);
		Label class6 = new Label(classes[5]);
		Label class7 = new Label(classes[6]);
		Label class8 = new Label(classes[7]);
		
		schedulePane.add(header, 0, 0);
		schedulePane.add(user, 1, 0);
		schedulePane.add(classHeader1, 0, 1);
		schedulePane.add(classHeader2, 0, 2);
		schedulePane.add(classHeader3, 0, 3);
		schedulePane.add(classHeader4, 0, 4);
		schedulePane.add(classHeader5, 0, 5);
		schedulePane.add(classHeader6, 0, 6);
		schedulePane.add(classHeader7, 0, 7);
		schedulePane.add(classHeader8, 0, 8);	
		
	}

	//methods
	private void BuildSchedule(String id, FileIO fio) throws IOException{
		//use id and FIO to pull info needed to get classes available
		//file format for major req is: MajorRequirements - MAJOR.csv
		String[][] userInf = fio.getUserInfo();
		String[][] reqs = fio.getMajorReq();
		String[][] courses = fio.getUserCourses();
		String[] userCourses;
		
		String major;
		File majorFile;
		
		for(int i=0;i<userInf.length;i++) {
			if(userInf[0][1]==id){
				//at the correct row in the user info array
				major = userInf[3][i];
			}
		}
		for(int j=0;j<courses.length;j++) {
			if(courses[j][0]==id) {
				//found column of courses for user
				for(int k=0;k<courses[j].length;k++) {
					//loop to every course
					userCourses[k] = courses[j][k];
				}
			}
		}
				switch(major)
				{
				case("Computer Science"):	
					majorFile = new File("MajorRequirements - Computer Science.csv");
					reqs = fio.Read_Major_Requirements(majorFile);
					
					
					
					break;
				case("Software Engineering"):
					 majorFile = new File("MajorRequirements - Software Engineering.csv");	
					reqs = fio.Read_Major_Requirements(majorFile);
					
					break;
				case("Aerospace Propulsion"):
					majorFile = new File("MajorRequirements - Aerospace Propulsion.csv");
					reqs = fio.Read_Major_Requirements(majorFile);
					break;
				case("Computer Engineering"):
					majorFile = new File("MajorRequirements - Computer Engineering.csv");
					reqs = fio.Read_Major_Requirements(majorFile);
				default:
					//major that is passed is not present
					System.out.println("Major given is not a valid major for SchedulER");
				}
				
			}
		}

	private void CheckPrerequisites(){
		//need to verify that classes selected by user are legal
		FileIO fio = new FileIO();
		String[] userClasses = in
	}
}//end Suggest_Schedule