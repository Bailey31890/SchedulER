/*	SchedulER
 * 
 * code format with help from https://www.callicoder.com/javafx-registration-form-gui-tutorial/
 * 
 * 
 */

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;

public class Login_GUI extends Pane {

	public Login_GUI(SchedulERlauncher go, FileIO inOut) {

		Group root = new Group();

		GridPane loginGridpane = new GridPane();

		loginGridpane.setAlignment(Pos.CENTER);
		loginGridpane.setPadding(new Insets(40, 40, 40, 40));

		// Set the horizontal gap between columns
		loginGridpane.setHgap(10);

		// Set the vertical gap between rows
		loginGridpane.setVgap(10);

		//columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		loginGridpane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

		Label loginLabel = new Label("SchedulER Application");
		loginLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		loginGridpane.add(loginLabel, 0,0,2,1);

		GridPane.setHalignment(loginLabel, HPos.CENTER);
		GridPane.setMargin(loginLabel, new Insets(20,0,20,0));

		// Add username Label
		Label userLabel = new Label("Username: ");
		loginGridpane.add(userLabel, 0,1);

		// Add Name Text Field
		TextField userField = new TextField();
		userField.setPrefHeight(40);
		loginGridpane.add(userField, 1,1);

		// Add Password Label
		Label passwordLabel = new Label("Password: ");
		loginGridpane.add(passwordLabel, 0, 3);

		// Add Password Field
		PasswordField passwordField = new PasswordField();
		passwordField.setPrefHeight(40);
		loginGridpane.add(passwordField, 1, 3);

		// Add Submit Button
		Button submitButton = new Button("Submit");
		submitButton.setPrefHeight(60);
		submitButton.setDefaultButton(true);
		submitButton.setPrefWidth(200);
		loginGridpane.add(submitButton, 0, 4, 2, 1);
		GridPane.setHalignment(submitButton, HPos.CENTER);
		GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

		// Add switch screen button
		Button switchScreen = new Button("Create Profile");
		switchScreen.setPrefHeight(40);
		switchScreen.setDefaultButton(true);
		switchScreen.setPrefWidth(200);
		loginGridpane.add(switchScreen, 0, 5, 2, 1);
		GridPane.setHalignment(switchScreen, HPos.CENTER);
		GridPane.setMargin(switchScreen, new Insets(20, 0,20,0));

		root.getChildren().add(loginGridpane);
		getChildren().add(root);

		//***************************************create account page not added
		Group Croot = new Group();

		GridPane createPane = new GridPane();

		createPane.setAlignment(Pos.CENTER);
		createPane.setPadding(new Insets(40, 40, 40, 40));

		createPane.setHgap(10);
		createPane.setVgap(10);

		//columnOneConstraints will be applied to all the nodes placed in column one.
		ColumnConstraints createOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
		columnOneConstraints.setHalignment(HPos.RIGHT);

		// columnTwoConstraints will be applied to all the nodes placed in column two.
		ColumnConstraints createTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
		columnTwoConstrains.setHgrow(Priority.ALWAYS);

		createPane.getColumnConstraints().addAll(createOneConstraints, createTwoConstrains);


		Label createLabel = new Label("Create Account");
		createLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		createPane.add(createLabel, 0,0,2,1);

		GridPane.setHalignment(createLabel, HPos.CENTER);
		GridPane.setMargin(createLabel, new Insets(20,0,20,0));

		// Add username create Label
		Label userCreateLabel = new Label("Create Username: ");
		userCreateLabel.setWrapText(true);
		createPane.add(userCreateLabel, 0,1);

		// Add user Text Field
		TextField userCreateField = new TextField();
		userCreateField.setPrefHeight(40);
		createPane.add(userCreateField, 1,1);

		// Add create Password Label
		Label passwordCreateLabel = new Label("Create Password: ");
		passwordCreateLabel.setWrapText(true);;
		createPane.add(passwordCreateLabel, 0, 3);

		// Add Password Field
		PasswordField passwordCreateField = new PasswordField();
		passwordCreateField.setPrefHeight(40);
		createPane.add(passwordCreateField, 1, 3);

		// combo box label
		Label majorLabel = new Label("Select your Major: ");
		majorLabel.setPrefWidth(200);
		majorLabel.setWrapText(true);
		createPane.add(majorLabel, 0, 4, 1, 2);

		// add select major combo box
		//create options first
		String majors[] = {"Computer Science", "Computer Engineering", "Software Engineering", "Mechanical Engineering", "Aerospace Engineering", "Cyber Security Engineering", "Electrical Engineering"};
		ComboBox<String> majorSelect = new ComboBox<String>(FXCollections.observableArrayList(majors));
		createPane.add(majorSelect, 1, 5);

		// Add SubmitCreate Button
		Button submitCreateButton = new Button("Submit");
		submitCreateButton.setPrefHeight(60);
		submitCreateButton.setDefaultButton(true);
		submitCreateButton.setPrefWidth(200);
		createPane.add(submitCreateButton, 0, 6, 2, 1);
		GridPane.setHalignment(submitCreateButton, HPos.CENTER);
		GridPane.setMargin(submitCreateButton, new Insets(20, 0,20,0));

		// Add switch back button
		Button switchBack = new Button("Back");
		switchBack.setPrefHeight(40);
		//switchBack.setDefaultButton(true);
		switchBack.setPrefWidth(100);
		createPane.add(switchBack, 0, 7, 2, 1);
		GridPane.setHalignment(switchBack, HPos.CENTER);
		GridPane.setMargin(switchBack, new Insets(20, 0,20,0));	

		Croot.getChildren().add(createPane);

		submitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(userField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, loginGridpane.getScene().getWindow(), "Login Error!", "Please enter your username");
					return;
				}


				if(passwordField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, loginGridpane.getScene().getWindow(), "Login Error!", "Please enter a password");
					return;
				}

				//login test here

				showAlert(Alert.AlertType.CONFIRMATION, loginGridpane.getScene().getWindow(), "Login Successful!", "Welcome " + userField.getText());
				go.switchScreens(1);

			} });

		switchScreen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				getChildren().clear(); 

				getChildren().add(Croot);
			}
		});

		submitCreateButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(userCreateField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, createPane.getScene().getWindow(), "Input Error!", "Please enter your username");
					return;
				}


				if(passwordCreateField.getText().isEmpty()) {
					showAlert(Alert.AlertType.ERROR, createPane.getScene().getWindow(), "Input Error!", "Please enter a password");
					return;
				}

				if(majorSelect.getValue() == null) {
					showAlert(Alert.AlertType.ERROR, createPane.getScene().getWindow(), "Input Error!", "Please select a major");
					return;
				}

				showAlert(Alert.AlertType.CONFIRMATION, createPane.getScene().getWindow(), "Account Creation Successful!", "Welcome " + userCreateField.getText());
				go.switchScreens(1);
				
			} });

		switchBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				getChildren().clear(); 

				getChildren().add(root);
			}
		});
	}

	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}


