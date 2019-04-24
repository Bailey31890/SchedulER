// ***************************************************************
// Names: Nathaniel Deen, Bailey Roberts, Jayson Tinsley, Liam Kehoe, Matthieu Privat
// Last Updated: 3/6/2019
// Version: 0.01
//
// SE 300, Section 1, Final Group Project Run File
//
// Class: Dashboard extends Pane
//
// Attributes: degree, credits, degreeCredits
//
// Methods: profile(FileIO inOut), major(FileIO inOut), creds(FileIO inOut), majorCreds(FileIO, inOut), Dashboard(SchedulERlauncher go, FileIO inOut)
//
// Description:
// Front and back end functionality of a menu page allowing users see the
// status their education
//
// ***************************************************************

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The Dashboard class maintains front and back end functionality of the main menu page.
 * It also includes methods for updating the Dashboard page after the Settings page has been changed.
 *
 *@author - Matthieu Privat, Nathaniel Deen
 */
public class Dashboard extends Pane {

	public String degree;
	public String credits;
	public String degreeCredits;
	
	String[] profileStr;
	String[] majorStr;
	String[] credsStr;
	
	/**
	 * Profile reads from FileIO the current User's profile and allows the program to display
	 * the User's username in their dashboard status, gotten from the read array.
	 * 
	 * @author Matthieu Privat
	 * @param inOut
	 * @throws IOException
	 * @returns profileStr[1]
	 */
	public String profile(FileIO inOut) /*throws IOException*/ {
		// String[] profileStr;
		try {
			profileStr = inOut.getProfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profileStr[1];
	}
	
	/**
	 * Major reads from the User's profile and gets from the array the name of the User's
	 * major and assigns it to String degree.
	 * 
	 * @author Matthieu Privat
	 * @param inOut
	 * @throws IOException
	 */
	public String major(FileIO inOut) /*throws IOException*/ {
		// String[] majorStr;
		try {
			majorStr = inOut.getProfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		degree = majorStr[3];
		return degree;
	}
	
	/**
	 * Creds reads from the User's profile and get from the array the number of credits
	 * the user has completed.
	 * 
	 * @author Matthieu Privat
	 * @param inOut
	 * @throws IOException
	 */
	public String creds(FileIO inOut) /*throws IOException*/ {
		// String[] credsStr;
		try {
			credsStr = inOut.getProfile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		credits = credsStr[4];
		return credits;
	}
	
	/**
	 * MajorCreds parses the Major.csv file and compares the read major name with the
	 * major defined in major(). Once a match between the two is found, the method stores
	 * the appropriate credit number, representing the number of credits for the given
	 * major.
	 * 
	 * @author Matthieu Privat
	 * @param inOut
	 * @throws IOException
	 */
	public String majorCreds(FileIO inOut) {
		String csvFile = "Majors.csv";
		BufferedReader br = null;
		String line = "";
		String delim = ",";
		
		try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] major = line.split(delim);
                System.out.println("Major: " + major[0] + " || Credits: " + major[1]);
                if(degree .equals(major[0])) {
                		System.out.println("Breaking. Major: " + major[0]);
                		degreeCredits = major[1];
                		break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return degreeCredits;
	}

	/**
	 * Dashboard creates the front end functionality of the menu page 
	 *
	 *@author - Nathaniel Deen
	 * @param  recieves an object of the SchedulER class so screens can be changed
	 * @throws IOException 
	 */
	public Dashboard(SchedulERlauncher go, FileIO inOut) {

		major(inOut);
		creds(inOut);
		majorCreds(inOut);
		
		Group root = new Group();
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		Text statusText = new Text();
		statusText.setText(profile(inOut) + "'s Status");
		statusText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
		statusText.setX(175);
		statusText.setY(315);

		Label statusLabel = new Label("My Degree: " + degree + "\nCredits Left: " + credits + "/" + degreeCredits);
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
		
		logout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
	}
}//end Dashboard
