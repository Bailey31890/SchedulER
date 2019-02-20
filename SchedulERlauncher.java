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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SchedulERlauncher extends Application{

	//Initialize attributes
	public int screen = 0;

	//Initialize GUI elements
	public Button switchScreen;
	
	//Initializes objects
	private Login_GUI Login;
	private Settings_Page userSettings;
	private Suggest_Schedule buildSchedule;

	@Override
	public void start(Stage primaryStage) throws Exception {

		//initialize variables

		primaryStage.setTitle("SchedulER Application"); //defines stage

		//creates objects

		switchScreen.setOnAction(e -> {
			//if statement allows for panes to switch 
			if (screen == 0) {

				//Scene vShowScene = new Scene(vShow, 1300, 800); //stage & scenes

				// shows Login screen 
				//primaryStage.setScene(vShowScene); //sets stage & shows
				primaryStage.show();

			} else if (screen == 1) {

				//Scene RTscene = new Scene(RTtest, 1300, 800); //stage & scenes

				// shows user settings screen
				//primaryStage.setScene(RTscene); //sets stage & shows
				primaryStage.show();
			} else if (screen == 2) {

				//Scene Sscene = new Scene(Stest, 1300, 800);

				// SHOWS SPATIAL TEST *******************************************************
				//primaryStage.setScene(Sscene); //sets stage & shows
				primaryStage.show();
			} else if (screen == 4) {


				//primaryStage.setScene(Vscene); //sets stage & shows
				primaryStage.show();
			} else if (screen == 5) {

				primaryStage.hide();

				//primaryStage.setScene(SCENE NAME); //sets stage & shows
				primaryStage.show();
			}
		});
	}

	//launches code
	public static void main(String[] args) { launch(args); }}