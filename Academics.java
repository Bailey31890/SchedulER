import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/** 
 * @name Academics
 * @description Manages interaction between stored user data and the user. including the switching of a major track and adding/removing classes
 * 
 * @author	Nathaniel Deen, Bailey Roberts 
 * @version	6.7
 * @since	2019-04-24
 **/
public class Academics extends Pane {

	//Initializes Attributes
	private String[] UserProfile = new String[5];
	private String[] major = new String[17];
	private String[] classListHolder = new String[158];
	private String[] UserClasses = new String[135];

	//GUI elements
	private TabPane tabPane;
	private ComboBox<String> majorList;
	private ListView<String> classList, userList;
	private Label currentMajor;

	/**
	 * @name Academics
	 * @description This constructor creates the front end of the settings page
	 *
	 *@author - Nathaniel Deen
	 * @param  recieves an object of the SchedulER class, FileIO class and user ID
	 * @throws Exception 
	 */
	public Academics(SchedulERlauncher go, FileIO inOut, String ID) throws Exception{

		classListHolder = convertClassData(inOut.getClassList());
		major = converMajor(inOut.getMajors());
		UserClasses = convertUserClasses(inOut.makeClasses(ID));
		UserProfile = inOut.makeProfile(ID);

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

		Label majorLabel = new Label(UserProfile[1] + "'s Major:");
		majorLabel.setFont(new Font("Verdana", 25));
		majorLabel.setLayoutX(25);
		majorLabel.setLayoutY(25);

		Label major, changeMajor;
		currentMajor = new Label(UserProfile[3]);
		currentMajor.setFont(new Font("Verdana", 12));
		major = new Label("Current Major: ");
		major.setFont(new Font("Verdana", 12));
		changeMajor = new Label("Change Major: ");
		changeMajor.setFont(new Font("Verdana", 12));
		majorList = new ComboBox<String>(FXCollections.observableArrayList(makeMajorList()));

		m.getChildren().addAll(major, currentMajor);
		m.setSpacing(3);
		c.getChildren().addAll(changeMajor, majorList);
		c.setSpacing(3);

		mP.getChildren().addAll(m, c); 
		mP.setSpacing(50);
		mP.setLayoutX(25);
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

		Label classLabel = new Label(UserProfile[1] + "'s Classes:");
		classLabel.setFont(new Font("Verdana", 25));
		classLabel.setLayoutX(25);
		classLabel.setLayoutY(25);

		Button confirmClass, add, remove;
		confirmClass = new Button("Save Changes");
		add = new Button("->");
		remove = new Button("<-");
		cButtons.getChildren().addAll(add, remove);
		cButtons.setLayoutY(100);

		Label classListLabel = new Label("Available Classes:");
		classListLabel.setFont(new Font("Verdana", 15));
		Label userListLabel = new Label("Your Classes:");
		userListLabel.setFont(new Font("Verdana", 15));

		classList = new ListView<String>(FXCollections.observableArrayList(makeClassList()));
		userList = new ListView<String>(FXCollections.observableArrayList(formatClasses(UserClasses)));
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
		confirmMajor.setOnAction(e -> { 

			setMajor();

			try {
				go.setProfile(UserProfile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		confirmClass.setOnAction(e -> {  
			try {
				go.setClasses(UserClasses);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 

			try {
				countCredits(inOut);
				go.setProfile(UserProfile);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		add.setOnAction(e -> { addClasses(); 

		int i = 0;

		while (UserClasses[i] != null) {
			i++;
		}

		UserClasses[i] = userList.getItems().get(i);

		});

		remove.setOnAction(e -> { 

			int y;

			for (y = 0; y < UserClasses.length + 1; y++) {

				if (y >= userList.getSelectionModel().getSelectedIndex()) {
					if (y < UserClasses.length - 1) {
						UserClasses[y] = UserClasses[y + 1];
					}
				} 
			}

			//UserClasses[userList.getSelectionModel().getSelectedIndex()]; 
			removeClasses();

		});

		Mhome.setOnAction(e -> { 
			try {
				go.switchScreens(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} });

		Chome.setOnAction(e -> { 
			try {
				go.switchScreens(1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} });
	}

	//methods section********************************

	/**
	 * @name convertClassData
	 * @description This method converts the raw class data into a managable array
	 *
	 * @author - Nathaniel Deen
	 * @param  recieves an object of the SchedulER class, FileIO class and user ID
	 * @returns 2D array of classes on the list 
	 */
	private String[] convertClassData(String[][] raw) {
		String[] newFormat = new String[158];

		for (int i = 1; i < 159; i++) {

			newFormat[i - 1] = raw[0][i];
		}


		return newFormat;
	}

	/**
	 * @name convertUserClasses
	 * @description This method converts the raw user class data into a managable array
	 *
	 * @author - Nathaniel Deen
	 * @param  recieves a String[]
	 * @returns 2D array of classes on the list 
	 */
	private String[] convertUserClasses(String[] raw) {
		String[] converted = new String[135];

		int i;

		for (i = 0; i < 135; i ++) {

			converted[i] = raw[i];

		}

		return converted;
	}

	/**
	 * @name formatClasses
	 * @description This method converts a user class list with nulls to a list containing no nulls
	 *
	 * @author - Nathaniel Deen
	 * @param  recieves a String[]
	 * @returns 2D array of classes on the list 
	 */
	private String[] formatClasses(String[] raw) {

		int c = 0;

		for (int i = 0; i < raw.length; i++ ) {

			if (raw[i] != null) {
				c++;
			}
		}

		String[] converted = new String[c];

		int i;

		for (i = 0; i < c; i ++) {

			converted[i] = raw[i];
		}

		return converted;
	}

	/**
	 * @name addClasses
	 * @description This method adds a GUI ListViews and String[]
	 *
	 * @author - Nathaniel Deen, Bailey Roberts 
	 */
	protected void addClasses(){

		if (classList.getSelectionModel().getSelectedItem() != null) {
			userList.getItems().add(classList.getSelectionModel().getSelectedItem());

			classList.getItems().remove(classList.getSelectionModel().getSelectedItem());
		}

	}

	/**
	 * @name removeClasses
	 * @description This method removes a class from ListViews and String[]
	 *
	 * @author - Nathaniel Deen, Bailey Roberts
	 */
	protected void removeClasses(){

		if (userList.getSelectionModel().getSelectedItem() != null) {
			classList.getItems().add(userList.getSelectionModel().getSelectedItem());

			userList.getItems().remove(userList.getSelectionModel().getSelectedItem());
		}

	}

	/**
	 * @name makeMajorList
	 * @description This method always returns immediately, a String[] list of all the majors in the database 
	 * without the one the user is taking
	 *
	 * @author - Nathaniel Deen
	 * @return String[] of a major list without duplicates
	 */
	private String[] makeMajorList() {
		String[] tranList = new String[major.length - 1];
		int counter = 0;

		for (int i = 0; i < major.length; i++) {

			if(!(UserProfile[3].equals(major[i]))) {
				tranList[counter++] = major[i];
			} 
		}

		return tranList;
	}

	/**
	 * @name convertMajor
	 * @description This method converts the raw class major data into a managable array
	 *
	 * @author - Nathaniel Deen
	 * @param  recieves a String[]
	 * @returns 2D array of classes on the list 
	 */
	private String[] converMajor(String[][] raw) {

		String[] rev = new String[17];

		for (int i = 0; i < 17; i++) {

			rev[i] = raw[0][i];
		}

		return rev;
	}

	/**
	 * @name makeClassList
	 * @description this method returns a String[] without the users taken classes
	 *
	 * @author - Nathaniel Deen
	 * @returns 2D array of classes on the list 
	 */
	protected String[] makeClassList() {

		String[] holder = formatClasses(UserClasses);
		String[] revisedList = new String[classListHolder.length - holder.length];
		int counter = 0;

		boolean check = false;

		for (int i = 0; i < classListHolder.length; i++) {

			for (int x = 0; x < holder.length; x++) {

				if(classListHolder[i].equals( holder[x])) {
					check = true;
				}

			}

			if (check == false) {
				revisedList[counter] = classListHolder[i];
				counter++;
			} else {
				check = false;
			}
		}

		return revisedList;
	}

	/**
	 * @name countCredits
	 * @description This method counts the number of credits a user has taken
	 *
	 * @author - Nathaniel Deen
	 * @param  recieves an object of the FileIO class
	 */
	private void countCredits(FileIO inOut) throws IOException {

		int i = 0;
		String[][] classes = inOut.getClassList();
		String credits = "0";

		while (UserClasses[i] != null) {

			for (int x = 0; x < 158 ; x++) {

				for (int y = 0 ; y < formatClasses(UserClasses).length; y++) {
					if (classes[0][x].equals(UserClasses[y]) == true) {
						credits = Integer.toString(Integer.parseInt(credits) + Integer.parseInt(classes[1][x])); 
					}
				}
			}
			i++;
		}

		UserProfile[4] = credits;
	}

	//Setters and getters*********************************************
	protected void setMajor() {

		majorList.getItems().add(UserProfile[3]);

		UserProfile[3] = majorList.getValue();

		currentMajor.setText(UserProfile[3]);

		majorList.getItems().remove(UserProfile[3]);


	}

	protected String[] getClassList() {
		String[] list = new String[UserProfile.length];

		for(int i = 0; i < UserProfile.length; i++) {

			list[i] = UserProfile[i];
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