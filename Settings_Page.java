// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 3/6/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: Settings_Page extends Pane
//
// Attributes: inOut, UserProfile, majorListHolder, classListHolder, tabPane, currentMajor, majorList, classList, userList
//
// Methods: 
//
// Description:
// Front and back end functionality of a settings page allowing users to change
// class, major, or password information. Save buttons then saves updated user
// info directly to a csv file where it can then be later called for other functions.
//
// ***************************************************************

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The Settings_Page Class maintains front and back end functionality of the settings page
 *
 *@author - Nathaniel Deen
 */
public class Settings_Page extends Pane {

	//Initializes Attributes
	private String[] UserProfile = {"1234", "Software", "UNIV 101", "EGR 101"};
	private String[] majorListHolder = {"Computer Science", "Computer", "Software","Mechanical", "Aerospace", "Cyber Security", "Electrical"};
	private String[] classListHolder = {"CS 223", "EGR 115", "COM 221", "HU 125", "UNIV 101", "EGR 101"};


	//GUI elements
	private TabPane tabPane;
	private ComboBox<String> majorList;
	private ListView<String> classList, userList;
	private Label currentMajor;

	/**
	 *This constructor creates the front end of the settings page
	 *
	 *@author - Nathaniel Deen
	 * @param  recieves an object of the SchedulER class so screens can be changed
	 */
	public Settings_Page(SchedulERlauncher go, FileIO inOut){

		//Initializes variables
		Tab majorTab, classTab;
		Pane majorPane, classPane;

		tabPane = new TabPane();

		majorPane = new Pane();
		classPane = new Pane();

		majorTab = new Tab();
		classTab = new Tab();

		Button Mhome = new Button("Main Menu");
		Button Chome = new Button("Main Menu");

		//majorPane*****************************************************************
		VBox mP = new VBox();
		HBox m = new HBox();
		HBox c = new HBox();
		HBox mB = new HBox();

		Button confirmMajor;
		confirmMajor = new Button("Save Changes");

		Label majorLabel = new Label("Update Major:");
		majorLabel.setFont(new Font("Comic Sans MS", 25));
		majorLabel.setLayoutX(50);
		majorLabel.setLayoutY(25);

		Label major, changeMajor;
		currentMajor = new Label(UserProfile[1]);
		major = new Label("Current Major: ");
		changeMajor = new Label("Change Major: ");
		majorList = new ComboBox<String>(FXCollections.observableArrayList(makeMajorList()));

		m.getChildren().addAll(major, currentMajor);
		m.setSpacing(10);
		c.getChildren().addAll(changeMajor, majorList);
		c.setSpacing(10);

		mP.getChildren().addAll(m, c); 
		mP.setSpacing(50);
		mP.setLayoutX(75);
		mP.setLayoutY(75);

		mB.getChildren().addAll(confirmMajor, Mhome);
		mB.setSpacing(175);
		mB.setLayoutX(25);
		mB.setLayoutY(225);

		majorPane.getChildren().addAll(majorLabel, mP, mB);

		//classPane***************************************************************
		HBox cStuff = new HBox();
		HBox cB = new HBox();
		VBox listedClasses = new VBox();
		VBox cButtons = new VBox();
		VBox userClasses = new VBox();

		Label classLabel = new Label("Update Classes:");
		classLabel.setFont(new Font("Comic Sans MS", 25));
		classLabel.setLayoutX(50);
		classLabel.setLayoutY(25);

		Button confirmClass, add, remove;
		confirmClass = new Button("Save Changes");
		add = new Button("->");
		remove = new Button("<-");
		cButtons.getChildren().addAll(add, remove);
		cButtons.setLayoutY(100);

		Label classListLabel = new Label("Available Classes:");
		Label userListLabel = new Label("Your Classes:");

		classList = new ListView<String>(FXCollections.observableArrayList(makeClassList()));
		userList = new ListView<String>(FXCollections.observableArrayList(getClassList()));
		classList.setPrefWidth(70);
		classList.setPrefHeight(100);
		userList.setPrefWidth(70);
		userList.setPrefHeight(100);

		userClasses.getChildren().addAll(userListLabel, cButtons, userList);
		listedClasses.getChildren().addAll(classListLabel, classList);

		cB.getChildren().addAll(confirmClass, Chome);
		cB.setSpacing(175);
		cB.setLayoutX(25);
		cB.setLayoutY(225);

		cStuff.getChildren().addAll(listedClasses, cButtons,userClasses);
		cStuff.setSpacing(20);
		cStuff.setLayoutX(50);
		cStuff.setLayoutY(75);

		classPane.getChildren().addAll(classLabel, cStuff, cB);

		//creates tabs and adds them to the tabPane
		classTab.setText("Classes");
		classTab.setContent(classPane);
		tabPane.getTabs().add(classTab);
		
		majorTab.setText("Major");
		majorTab.setContent(majorPane);
		tabPane.getTabs().add(majorTab);

		//event handlers****************************************************************
		confirmMajor.setOnAction(e -> { setMajor(); });

		add.setOnAction(e -> { addClasses(); });

		remove.setOnAction(e -> { removeClasses(); });

		Mhome.setOnAction(e -> { go.switchScreens(1); });

		Chome.setOnAction(e -> { go.switchScreens(1); });
	}

	//methods section********************************

	/**
	 * This method updates the class lists on screen for the user through attributes 
	 *
	 *@author - Nathaniel Deen
	 */
	protected void addClasses(){

		if (classList.getSelectionModel().getSelectedItem() != null) {
			userList.getItems().add(classList.getSelectionModel().getSelectedItem());

			classList.getItems().remove(classList.getSelectionModel().getSelectedItem());
		}

	}

	//removes class from users list
	protected void removeClasses(){

		if (userList.getSelectionModel().getSelectedItem() != null) {
			classList.getItems().add(userList.getSelectionModel().getSelectedItem());

			userList.getItems().remove(userList.getSelectionModel().getSelectedItem());
		}

	}

	/**
	 * METHOD NOT CREATED YET 
	 *
	 *@author - Nathaniel Deen
	 */
	protected int UpdateCredits(){
		return 0;
	}

	/**
	 * This method always returns immediately, a String[] list of all the majors in the database 
	 * without the one the user is taking
	 *
	 *@author - Nathaniel Deen
	 * @return String[] of a major list without duplicates
	 */
	private String[] makeMajorList() {
		String[] tranList = new String[majorListHolder.length - 1];
		int counter = 0;

		for (int i = 0; i < majorListHolder.length; i++) {

			if(UserProfile[1] != majorListHolder[i]) {
				tranList[counter++] = majorListHolder[i];
			} 
		}

		return tranList;
	}

	/**
	 * This method always returns immediately, a String[] list of all the classes in the database 
	 * without the one the user is taking
	 *
	 *@author - Nathaniel Deen
	 * @return String[] of a class list without duplicates
	 */
	protected String[] makeClassList() {
		String[] revisedList = new String[classListHolder.length - (UserProfile.length - 2)];
		int counter = 0;
		int c = 0;

		String[] RclassList = getClassList();

		for (int i = 0; i < classListHolder.length; i++) {

			if(RclassList[counter] != classListHolder[i]) {
				revisedList[c++] = classListHolder[i];
			} else {
				counter++;
			}
		}

		return revisedList;
	}

	//Setters and getters*********************************************
	protected void setMajor() {

		majorList.getItems().add(UserProfile[1]);

		UserProfile[1] = majorList.getValue();

		currentMajor.setText(UserProfile[1]);

		majorList.getItems().remove(UserProfile[1]);

	}

	protected String[] getClassList() {
		String[] list = new String[UserProfile.length - 2];

		for(int i = 0; i < UserProfile.length - 2; i++) {

			list[i] = UserProfile[i + 2];
		}

		return list;
	}

	public TabPane getPane() {
		return tabPane;
	}

	protected String[] getUserProfile() {
		return UserProfile;
	}
}//end Settings_Page