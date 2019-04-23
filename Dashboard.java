// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 3/6/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: Dashboard extends Pane
//
// Attributes: degree, minor, credits, degreeCredits
//
// Methods: 
//
// Description:
// Front and back end functionality of a menu page allowing users see the
// status their education
//
// ***************************************************************

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The Dashboard class maintains front and back end functionality of the main menu page
 *
 *@author - Matthieu Privat, Nathaniel Deen
 */
public class Dashboard extends Pane {

	public String degree = "Software";
	public String minor = "None";
	public int credits = 0;
	public int degreeCredits = 127;
	public int creditsLeft = degreeCredits - credits;

	/**
	 * Dashboard creates the front end functionality of the menu page 
	 *
	 *@author - Nathaniel Deen
	 * @param  recieves an object of the SchedulER class so screens can be changed
	 */
	public Dashboard(SchedulERlauncher go, FileIO inOut){

		Group root = new Group();
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		Text statusText = new Text();
		statusText.setText("Status");
		statusText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
		statusText.setX(250);
		statusText.setY(315);
		
		Label statusLabel = new Label("My Degree: " + degree + "\nCredits Left: " + creditsLeft + "/" + degreeCredits);
		gridpane.add(statusLabel, 15, 32);
		statusLabel.setFont(new Font("verdana", 20));
		
		MenuBar menuBar = new MenuBar();
		
		Image image = new Image("er.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);
        imageView.setFitHeight(300);
        imageView.setX(150); 
        imageView.setY(5);

		Menu menu = new Menu("Menu");
		 
		MenuItem settingsBtn = new MenuItem("Settings", null);
		MenuItem scheduleBtn = new MenuItem("Make My Schedule", null);
		MenuItem logout = new MenuItem("Logout", null);
		
		//adds all GUI elements 
		root.getChildren().add(statusText);
		root.getChildren().add(gridpane);
		root.getChildren().add(imageView);
		menu.getItems().add(settingsBtn);
		menu.getItems().add(scheduleBtn);
		menu.getItems().add(logout);
		menu.getItems().add(new SeparatorMenuItem());
		
		menuBar.getMenus().add(menu);
		root.getChildren().add(menuBar);
		
		getChildren().add(root);
		
		//event handlers**************************************************************************
		settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
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