import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** 
 * @name SchedulERlauncher
 * @description this file is the runfile for the whole project
 * 
 * @author	Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privatt 
 * @version	3.4
 * @since	2019-04-24
 **/
public class SchedulERlauncher extends Application{

	//Initialize attributes
	public Stage mainStage;

	//Initializes objects
	private Login_GUI login;
	private Academics academics;
	private Dashboard dash;
	public FileIO inOut;
	
	private String ID;
	private String[] user = new String[5];
	private String[] classes = new String[137];
	//private Suggest_Schedule buildSchedule;
	
	//initializes scenes
	private Scene dashScene, school, loginScene;

	/**
	 * @name start
	 * @description The start method runs immediately upon running the code. It initializes all GUI elements and runs initial file IO
	 * 
	 *@author - Nathaniel Deen
	 *@param Stage which is used to show scenes of the GUI
	 */
	public void start(Stage primaryStage) throws Exception {
		
		mainStage = new Stage();
		
		//creates objects
		inOut = new FileIO();
		login = new Login_GUI(this, inOut);
		
		mainStage.setTitle("SchedulER Application"); //defines stage
		
		//builds scenes
		loginScene = new Scene(login, 400, 450);
		
		switchScreens(0);
	}

	/**
	 * @name switchScreens
	 * @description This method takes in an integer value and updates the GUI scene to match the number
	 *
	 * @author - Nathaniel Deen
	 * @param  integer value for the screen number
	 * @throws IOException 
	 * @see    Sets a different scene
	 */
	public void switchScreens(int input) throws Exception {
		
		ID = login.getUserID();
		
		//if statement allows for panes to switch 
		if (input == 0) {
		/// shows login page*******************************************************			
			mainStage.setScene(loginScene); //sets stage & shows
			mainStage.show();
			

		} else if (input == 1) {
			
			
			
			user = inOut.makeProfile(ID);
			classes = inOut.makeClasses(ID);
			
			dash = new Dashboard(this, inOut, ID);	
			
			dashScene = new Scene(dash, 400, 450); 
			
			dash.update(user, inOut);
			
			// shows dashboard page******************************************************* 
			mainStage.setScene(dashScene); //sets stage & shows
			mainStage.show();
			
		} else if (input == 2) {
			
			user = inOut.makeProfile(ID);
			classes = inOut.makeClasses(ID);
			
			academics = new Academics(this, inOut, ID);
			school= new Scene(academics.getPane(), 400, 300);
			
			// shows settings page*******************************************************
			mainStage.setScene(school); //sets stage & shows
			mainStage.show();

		} else if (input == 3) {

			//meant for suggest schedule pane
			mainStage.show();
		} 
		
		//saveStuff();
	}

	/** 
	 * @name setProfile
	 * @description recieves array and writes to a global variable
	 * 
	 * @author Nathaniel Deen 
	 * @param String[]
	 * @throws exception
	 **/
	public void setProfile(String[] n) throws Exception {
		user = n;
		
		for (int i = 0; i < user.length; i++) {
			System.out.print(user[i] + " ");
		}
		
		System.out.println();
		
		//saveStuff();
	}
	
	/** 
	 * @name setClasses
	 * @description recieves array and writes to a global variable
	 * 
	 * @author Nathaniel Deen 
	 * @param String[]
	 * @throws exception
	 **/
	public void setClasses(String[] n) throws Exception {
		classes = n;
		
		for (int i = 0; i < classes.length; i++) {
			System.out.print(classes[i] + " ");
		}
		
		System.out.println();
		
		//saveStuff();
	}
	
	/** 
	 * @name saveStuff
	 * @description uses global vaiables to write out to files - NOT OPERATIONAL
	 * 
	 * @author Nathaniel Deen 
	 * @throws exception
	 **/
	private void saveStuff() throws Exception {
		
		String[] formatClasses = new String[classes.length];
		formatClasses[0] = ID;
		
		System.out.println(formatClasses[0]);
		 
		for (int i = 1; i < classes.length; i++) {
			
				formatClasses[i] = classes[i - 1];
		
		}
		
		inOut.Write_User_Info(inOut.ChangeOrAdd_User_Info(user));
		
		//inOut.Write_User_Courses(formatClasses);
	}

	//getters
	public String[] getProfile() {
		return user;
	}
	
	public String[] getClasses() {
		return classes;
	}
	
	/** 
	 * @name main
	 * @description cause code to launch
	 * 
	 * @author Nathaniel Deen 
	 * @param String[]
	 **/
	public static void main(String[] args) { launch(args); }}

