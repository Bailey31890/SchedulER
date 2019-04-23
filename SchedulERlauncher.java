// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 3/6/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: SchedulERlauncher extends Application
//
// Attributes: mainStage, userSettings, dash, dashScene, settings
//
// Methods: switchScreen(int), start(Stage)
//
// Description: This is the run file for the code
// 
// ***************************************************************

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The class SchedulERlauncher functions as the run file and main platform for the code.  
 *
 *@author - Nathaniel Deen
 */
public class SchedulERlauncher extends Application{

	//Initialize attributes
	public Stage mainStage;

	//Initializes objects
	private Login_GUI login;
	private Settings_Page userSettings;
	private Dashboard dash;
	public FileIO inOut;
	//private Suggest_Schedule buildSchedule;
	
	//initializes scenes
	private Scene dashScene, settings, loginScene;

	/**
	 * The start method runs immediately upon running the code. It initializes all GUI elements and runs initial file IO
	 * 
	 *@author - Nathaniel Deen
	 *@param Stage which is used to show scenes of the GUI
	 */
	public void start(Stage primaryStage) throws Exception {
		
		//creates objects
		inOut = new FileIO();
		login = new Login_GUI(this, inOut);
		dash = new Dashboard(this, inOut);		
		userSettings = new Settings_Page(this, inOut);
		mainStage = new Stage();
		
		mainStage.setTitle("SchedulER Application"); //defines stage
		
		//builds scenes
		dashScene = new Scene(dash, 600, 500); 
		settings = new Scene(userSettings.getPane(), 400, 300);
		loginScene = new Scene(login, 400, 450);
		
		switchScreens(0);
	}

	/**
	 * This method takes in an integer value and updates the GUI scene to match the number
	 *
	 *@author - Nathaniel Deen
	 * @param  integer value for the screen number
	 * @see    Sets a different scene
	 */
	//method for switching screens
	public void switchScreens(int input) {

		//if statement allows for panes to switch 
		if (input == 0) {

			// shows login page*******************************************************			
			mainStage.setScene(loginScene); //sets stage & shows
			mainStage.show();

		} else if (input == 1) {

			// shows dashboard page******************************************************* 
			mainStage.setScene(dashScene); //sets stage & shows
			mainStage.show();
			
		} else if (input == 2) {

			// shows settings page*******************************************************
			mainStage.setScene(settings); //sets stage & shows
			mainStage.show();

		} else if (input == 3) {


			//primaryStage.setScene(Vscene); //sets stage & shows
			mainStage.show();
		} 
	}


	/**
	 * The main method launches the application
	 * 
	 *@author - Nathaniel Deen
	 */
	public static void main(String[] args) { launch(args); }}