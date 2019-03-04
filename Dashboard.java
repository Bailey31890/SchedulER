// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 2/20/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: Courses_Taken extends Pane
//
// Attributes: 
//
// Methods: 
// ***************************************************************

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Dashboard extends Pane {

	public String degree = "Computer Science";
	public String minor = "Spaceflight Operations";
	public int credits = 12;
	public int degreeCredits = 20;
	public int creditsLeft = degreeCredits - credits;

	//constructor
	public Dashboard(){

		//initializes objects
		SchedulERlauncher go = new SchedulERlauncher();

		//builds GUI elements
		Group root = new Group();

		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);

		Text statusText = new Text();
		statusText.setText("Status");
		statusText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
		statusText.setX(105);
		statusText.setY(199);

		Label statusLabel = new Label("My Degree: " + degree + "\nMy Minor: " + minor + "\nMy Credits: " + credits + "\nCredits Left: " +creditsLeft);
		gridpane.add(statusLabel, 10, 20);

		//Image image = new Image("er.png");

		//builds menu options
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		MenuItem infoBtn = new MenuItem("My Information", null);
		MenuItem scheduleBtn = new MenuItem("Make a Schedule", null);

		//adds all GUI elements 
		root.getChildren().add(statusText);
		root.getChildren().add(gridpane);
		//root.getChildren().add(new ImageView(image));
		menu.getItems().add(infoBtn);
		menu.getItems().add(scheduleBtn);
		menu.getItems().add(new SeparatorMenuItem());

		menuBar.getMenus().add(menu);
		root.getChildren().add(menuBar);
		
		//event handlers**************************************************************************
		infoBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				go.switchScreens(2);
			}
		});

		scheduleBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				go.switchScreens(3);
			}
		});

	}
}//end Dashboard