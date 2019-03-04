// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 2/20/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: SchedulERlauncher extends Application
//
// Attributes: 
//
// Methods: 
//
// Description:
// 
//
// ***************************************************************

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SchedulERlauncher extends Application{

	//Initialize attributes
	public int screen = 0;

	//Initializes objects
	private Login_GUI login;
	private Settings_Page userSettings;
	private Dashboard dash;
	//private Suggest_Schedule buildSchedule;

	@Override
	public void start(Stage primaryStage) throws Exception {

		//initialize variables

		primaryStage.setTitle("SchedulER Application"); //defines stage

		//creates objects
		login = new Login_GUI();
		dash = new Dashboard();
		userSettings = new Settings_Page();

		//if statement allows for panes to switch 
		if (screen == 0) {

			// shows login page*******************************************************
			Scene loginScene = new Scene(login, 400, 300); //stage & scenes
			primaryStage.setScene(loginScene); //sets stage & shows
			primaryStage.show();

		} else if (screen == 1) {

			// shows dashboard page*******************************************************
			Scene dashScene = new Scene(dash, 400, 300); //stage & scenes
			primaryStage.setScene(dashScene); //sets stage & shows
			primaryStage.show();
		} else if (screen == 2) {

			// shows settings page*******************************************************
			Scene settings = new Scene(userSettings.getPane(), 400, 300);
			primaryStage.setScene(settings); //sets stage & shows
			primaryStage.show();
			
		} else if (screen == 3) {


			//primaryStage.setScene(Vscene); //sets stage & shows
			primaryStage.show();
		} 
	}

	public void switchScreens(int input) {
		if (input == 1) {
			screen = 1;
		} else if (input == 2) {
			screen = 2;
		} else if (input == 3) {
			screen = 3;
		}
	}

	//launches code
	public static void main(String[] args) { launch(args); }}