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
// An area where users input classes that they have taken previously. Once the
// user is done adding classes that they have previously taken, there will be a
// save button that the user must click before leaving that page.
// Save button then saves user class information directly to an excel file where
// it can then be later called for other functions.
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

public class Settings_Page extends Pane {

	//Initializes objects
	FileIO inOut = new FileIO();

	//Initializes Attributes
	private String[] UserProfile = {"1234", "Software", "UNIV 101", "EGR 101"};
	private String[] majorListHolder = {"major 1", "Software", "major 3", "major 4"};
	private String[] classListHolder = {"CS 223", "EGR 115", "COM 221", "HU 125", "UNIV 101", "EGR 101"};


	//GUI elements
	private TabPane tabPane;
	private ComboBox<String> majorList;
	private ListView<String> classList, userList;
	private Label currentMajor;

	//screen constructor
	public Settings_Page(){
		
		//initializes objects
		SchedulERlauncher go = new SchedulERlauncher();

		//Initializes variables
		Tab majorTab, classTab, infoTab;
		Pane majorPane, classPane, settingPane;

		//initializes objects
		inOut = new FileIO();
		
		tabPane = new TabPane();

		majorPane = new Pane();
		classPane = new Pane();
		settingPane = new Pane();

		majorTab = new Tab();
		classTab = new Tab();
		infoTab = new Tab();

		Button Mhome = new Button("Main Menu");
		Button Chome = new Button("Main Menu");
		Button Ihome = new Button("Main Menu");

		//infoPane*****************************************************************
		HBox pwB = new HBox();
		HBox pwC = new HBox();
		HBox pB = new HBox();
		VBox pwV = new VBox();

		Button confirmPass;
		confirmPass = new Button("Save Changes");

		Label pwError = new Label("Passwords must match");
		pwError.setTextFill(Color.RED);
		pwError.setVisible(false);
		pwError.setLayoutX(75);
		pwError.setLayoutY(160);

		Label pwLabel = new Label("Update Password:");
		pwLabel.setFont(new Font("Comic Sans MS", 25));
		pwLabel.setLayoutX(50);
		pwLabel.setLayoutY(25);

		Label pw = new Label("New Password: ");
		TextField pwText = new TextField ();
		pwB.getChildren().addAll(pw, pwText);
		pwB.setSpacing(10);

		Label pwConfirm = new Label("Confirm Password: ");
		TextField pwCText = new TextField ();
		pwC.getChildren().addAll(pwConfirm, pwCText);
		pwC.setSpacing(10);

		pwV.setSpacing(25);
		pwV.setLayoutX(75);
		pwV.setLayoutY(75);
		pwV.getChildren().addAll(pwB, pwC);

		pB.getChildren().addAll(confirmPass, Ihome);
		pB.setSpacing(175);
		pB.setLayoutX(25);
		pB.setLayoutY(225);

		settingPane.getChildren().addAll(pwLabel, pwV, pB, pwError);

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
		infoTab.setText("Info");
		infoTab.setContent(settingPane);
		tabPane.getTabs().add(infoTab);

		majorTab.setText("Major");
		majorTab.setContent(majorPane);
		tabPane.getTabs().add(majorTab);

		classTab.setText("Classes");
		classTab.setContent(classPane);
		tabPane.getTabs().add(classTab);

		//event handlers****************************************************************
		confirmMajor.setOnAction(e -> { 
			setMajor();
		});
		
		add.setOnAction(e -> { 
			addClasses();
		});
		
		remove.setOnAction(e -> { 
			removeClasses();
		});
		
		Ihome.setOnAction(e -> { 
			go.switchScreens(1);
		});
		
		Mhome.setOnAction(e -> { 
			go.switchScreens(1);
		});
		
		Chome.setOnAction(e -> { 
			go.switchScreens(1);
		});

		//listeners*********************************************************************
		pwText.textProperty().addListener( (observe, pass, passC)->{

			pass = pwText.getText();
			passC = pwCText.getText();

			if (!pass.equals(passC)) {
				confirmPass.setDisable(true);
				pwError.setVisible(true);
			} else {
				pwError.setVisible(false);	
				confirmPass.setDisable(false);
			}

			/*if(!noErrors(stringCheck(pwText.getText(), pwCText.getText()))){
				confirmPass.setDisable(false);
			}*/
		});


	}

	//methods section********************************
	private Boolean stringCheck (String pass, String passC) {

		boolean error = false;

		if(pass != passC) {
			error = true;
		}

		return error;
	}

	/*private boolean noErrors(boolean check) {
		boolean error = false;
		if (!check) {
			error = true;
		}
		return error;
	}*/

	private void ChangePassword(){

	}

	//adds class to user list
	protected void addClasses(){
		
		userList.getItems().add(classList.getSelectionModel().getSelectedItem());
		
		classList.getItems().remove(classList.getSelectionModel().getSelectedItem());

	}

	//removes class from users list
	protected void removeClasses(){
		
		classList.getItems().add(userList.getSelectionModel().getSelectedItem());
		
		userList.getItems().remove(userList.getSelectionModel().getSelectedItem());

	}

	protected int UpdateCredits(){
		return 0;
	}

	//creates list for comboBox
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

	//creates list for users classes
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
	//saves major selection & updates list
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