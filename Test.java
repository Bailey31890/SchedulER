package missionControl;

import javafx.application.Application;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author matthieu
 * Code to generate dashboard window with buttons
 * 
 * Current variables are placeholders
 * 
 * <start> Method that creates window including menu bar, buttons, ER logo and status
 * </start>
 * @param primaryStage sets the primary stage of the scene
 * @since 1.0
 * 
 * @version 1.0
 */

public class Test extends Application {
	
	// Placeholder values
	public String degree = "Computer Science";
	public String minor = "Spaceflight Operations";
	public int credits = 12;
	public int degreeCredits = 20;
	public int creditsLeft = degreeCredits - credits;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("SchdulER");
		Group root = new Group();
		Scene scene = new Scene(root, 400, 300, Color.WHITE);
		
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
		
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		Image image = new Image("er.png");

		Menu menu = new Menu("Menu");
		 
		MenuItem settingsBtn = new MenuItem("Settings", null);
		MenuItem scheduleBtn = new MenuItem("Make My Schedule", null);
		
		settingsBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Selected Add My Classes");
		    }
		});
	  
		scheduleBtn.setOnAction(new EventHandler<ActionEvent>() {
		    	public void handle(ActionEvent event) {
		    		System.out.println("Selected Make My Schedule");
		    }
		});
		
		root.getChildren().add(statusText);
		root.getChildren().add(gridpane);
		root.getChildren().add(new ImageView(image));
		menu.getItems().add(settingsBtn);
		menu.getItems().add(scheduleBtn);
		menu.getItems().add(new SeparatorMenuItem());
		
		menuBar.getMenus().add(menu);
		root.getChildren().add(menuBar);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
